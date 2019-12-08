package lyy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.*;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStreamReader;  
public class Choose extends JFrame implements ActionListener{

    private JPanel Pane;
    private JTextField jtfName,jtfNum;
    private JTextArea massage;
    private JRadioButton jrb1,jrb2;
    private JCheckBox jcb1,jcb2,jcb3;
    private JComboBox<String > t1,t2,t3;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                	LoginTest frame=new LoginTest();     
                    frame.setVisible(true);                                   
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        LoginTest frame=new LoginTest();
     frame.setVisible(true);
    }

    public Choose(){
        setTitle("选课系统");                          
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        setSize(700,500);                                  
        setLocationRelativeTo(null);                        
        Pane=new JPanel();                           
        Pane.setBorder(new EmptyBorder(3, 3, 0, 0));
        Pane.setLayout(new BorderLayout(0, 0));      
        setContentPane(Pane);
        JPanel panel=new JPanel(new GridLayout(3,3 ,0,0));  
        panel.setBorder(new TitledBorder(null,"",TitledBorder.LEADING ,TitledBorder.TOP,null,null));
        Pane.add(panel,BorderLayout.CENTER);          
        JPanel panel_1=new JPanel();
        panel.add(panel_1);
        JLabel label=new JLabel("姓名");
        panel_1.add(label);
        jtfName=new JTextField();
        panel_1.add(jtfName);
        jtfName.setColumns(10);
        JLabel label_2=new JLabel("学号");
        panel_1.add(label_2);
        jtfNum=new JTextField();
        jtfNum.setColumns(10);
        panel_1.add(jtfNum);
        jrb1=new JRadioButton("男");
        panel_1.add(jrb1);
        jrb1.setSelected(true);                               
        jrb2=new JRadioButton("女");
        panel_1.add(jrb2);
        ButtonGroup bts=new ButtonGroup();                   
        bts.add(jrb1);
        bts.add(jrb2);
        JPanel panel2=new JPanel();
        panel.add(panel2);
        jcb1=new JCheckBox("高数");
        panel2.add(jcb1);
        t1=new JComboBox<String >();
        t1.setModel(new DefaultComboBoxModel<String>(new String[]{"任正民","Mary","崔后浪"}));
        panel2.add(t1);
        jcb2=new JCheckBox("离散数学");
        panel2.add(jcb2);
        t2=new JComboBox<String >();
        t2.setModel(new DefaultComboBoxModel<String >(new String[]{"魏薇","李次媛"}));
        panel2.add(t2);
        jcb3=new JCheckBox("java");
        panel2.add(jcb3);
        t3=new JComboBox<String >();
        t3.setModel(new DefaultComboBoxModel<String>(new String[]{"张世博","崔后浪"}));
        panel2.add(t3);
        JPanel panel3=new JPanel();
        panel.add(panel3);
        JButton jbOk=new JButton("确定");
        panel3.add(jbOk);
        jbOk.addActionListener(this);
        JButton jbRest=new JButton("重填");
        panel3.add(jbRest);
        JButton jbRst=new JButton("退课");
        panel3.add(jbRst);
        JButton jbTet=new JButton("打印列表");
        panel3.add(jbTet);
        JPanel panelSouth=new JPanel();
        Pane.add(panelSouth,BorderLayout.SOUTH);
        JLabel labe=new JLabel("选课信息");
        panelSouth.add(labe);
        massage=new JTextArea(3, 50);
        panelSouth.add(massage);
        
        JPanel panelNorth=new JPanel();
        Pane.add(panelNorth,BorderLayout.NORTH);
        JLabel labelTitle=new JLabel("学生选课系统");
        labelTitle.setForeground(Color.DARK_GRAY);
        panelNorth.add(labelTitle);

        jbOk.addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent e) {
                StringBuilder info=new StringBuilder();
                String name=jtfName.getText();
                String num=jtfNum.getText();
                String sex;
                if(jrb1.isSelected()){
                    sex="男";
                }else {
                    sex="女";
                }
                info.append("姓名："+name+"\n学号："+num+"\n性别："+sex+"\n所选课程:");
                if(jcb1.isSelected()){
                    String c=jcb1.getText();
                    String t=t1.getSelectedItem().toString();
                    info.append(c+"\n授课老师:"+t);
                }
                if(jcb2.isSelected()){
                    String c=jcb2.getText();
                    String t=t2.getSelectedItem().toString();
                    info.append(""+c+"\n授课老师:"+t);
                }
                if(jcb3.isSelected()){
                    String c=jcb3.getText();
                    String t=t3.getSelectedItem().toString();
                    info.append(""+c+"\n授课老师:"+t);
                }
                massage.setText(info.toString());                               
            }
        });

        jbRest.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                jtfName.setText("");
                jtfNum.setText("");
                jrb1.setSelected(true);
                jcb1.setSelected(false);
                t1.setSelectedIndex(0);
                jcb2.setSelected(false);
                t2.setSelectedIndex(0);
                massage.setText("");
            }
        });
    }

	public void actionPerformed(ActionEvent e) {
		File file = new File("d:\\Text.txt");  
        try {  
            file.createNewFile();  
        } catch (IOException e1) {  
            e1.printStackTrace();  
        }  
  
        String str = massage.getText();  
        byte bt[] = new byte[1024];  
        bt = str.getBytes();  
        try {  
            FileOutputStream in = new FileOutputStream(file);  
            try {  
                in.write(bt, 0, bt.length);  
                in.close();  
            } catch (IOException e1) {  
                e1.printStackTrace();  
            }  
        } catch (FileNotFoundException e1) {  
            e1.printStackTrace();  
        }  
        try {  
            FileInputStream out = new FileInputStream(file);  
            InputStreamReader isr = new InputStreamReader(out);  
            int ch = 0;  
            while ((ch = isr.read()) != -1) {  
                System.out.print((char) ch);  
            }  
        } catch (Exception e1) {  
        }  
    }  
		
	}


