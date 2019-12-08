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
        setTitle("ѡ��ϵͳ");                          
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
        JLabel label=new JLabel("����");
        panel_1.add(label);
        jtfName=new JTextField();
        panel_1.add(jtfName);
        jtfName.setColumns(10);
        JLabel label_2=new JLabel("ѧ��");
        panel_1.add(label_2);
        jtfNum=new JTextField();
        jtfNum.setColumns(10);
        panel_1.add(jtfNum);
        jrb1=new JRadioButton("��");
        panel_1.add(jrb1);
        jrb1.setSelected(true);                               
        jrb2=new JRadioButton("Ů");
        panel_1.add(jrb2);
        ButtonGroup bts=new ButtonGroup();                   
        bts.add(jrb1);
        bts.add(jrb2);
        JPanel panel2=new JPanel();
        panel.add(panel2);
        jcb1=new JCheckBox("����");
        panel2.add(jcb1);
        t1=new JComboBox<String >();
        t1.setModel(new DefaultComboBoxModel<String>(new String[]{"������","Mary","�޺���"}));
        panel2.add(t1);
        jcb2=new JCheckBox("��ɢ��ѧ");
        panel2.add(jcb2);
        t2=new JComboBox<String >();
        t2.setModel(new DefaultComboBoxModel<String >(new String[]{"κޱ","�����"}));
        panel2.add(t2);
        jcb3=new JCheckBox("java");
        panel2.add(jcb3);
        t3=new JComboBox<String >();
        t3.setModel(new DefaultComboBoxModel<String>(new String[]{"������","�޺���"}));
        panel2.add(t3);
        JPanel panel3=new JPanel();
        panel.add(panel3);
        JButton jbOk=new JButton("ȷ��");
        panel3.add(jbOk);
        jbOk.addActionListener(this);
        JButton jbRest=new JButton("����");
        panel3.add(jbRest);
        JButton jbRst=new JButton("�˿�");
        panel3.add(jbRst);
        JButton jbTet=new JButton("��ӡ�б�");
        panel3.add(jbTet);
        JPanel panelSouth=new JPanel();
        Pane.add(panelSouth,BorderLayout.SOUTH);
        JLabel labe=new JLabel("ѡ����Ϣ");
        panelSouth.add(labe);
        massage=new JTextArea(3, 50);
        panelSouth.add(massage);
        
        JPanel panelNorth=new JPanel();
        Pane.add(panelNorth,BorderLayout.NORTH);
        JLabel labelTitle=new JLabel("ѧ��ѡ��ϵͳ");
        labelTitle.setForeground(Color.DARK_GRAY);
        panelNorth.add(labelTitle);

        jbOk.addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent e) {
                StringBuilder info=new StringBuilder();
                String name=jtfName.getText();
                String num=jtfNum.getText();
                String sex;
                if(jrb1.isSelected()){
                    sex="��";
                }else {
                    sex="Ů";
                }
                info.append("������"+name+"\nѧ�ţ�"+num+"\n�Ա�"+sex+"\n��ѡ�γ�:");
                if(jcb1.isSelected()){
                    String c=jcb1.getText();
                    String t=t1.getSelectedItem().toString();
                    info.append(c+"\n�ڿ���ʦ:"+t);
                }
                if(jcb2.isSelected()){
                    String c=jcb2.getText();
                    String t=t2.getSelectedItem().toString();
                    info.append(""+c+"\n�ڿ���ʦ:"+t);
                }
                if(jcb3.isSelected()){
                    String c=jcb3.getText();
                    String t=t3.getSelectedItem().toString();
                    info.append(""+c+"\n�ڿ���ʦ:"+t);
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


