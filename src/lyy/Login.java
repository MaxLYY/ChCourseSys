package lyy;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

class LoginTest extends Panel implements ActionListener, MouseListener {

	JLabel jlb = new JLabel("                            ��ӭ����ѧ��ѡ��ϵͳ                           ");
	JLabel jlb1 = new JLabel("�û�����");
	JTextField jtf1 = new JTextField(11);
	JLabel jlb2 = new JLabel("���룺");
	JPasswordField jpf = new JPasswordField(11);

	LoginTest() {
		Panel p = new Panel();
		Panel p1 = new Panel();
		JFrame f = new JFrame("��¼����");
		f.setSize(180, 250);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
		f.add(p1);
		p1.add(jlb);
		f.add(jlb1);
		f.add(jtf1);
		f.add(jlb2);
		f.add(jpf);
		jtf1.setLayout(new FlowLayout());
		jpf.setLayout(new FlowLayout());
		f.add(p);
		JButton bn1 = new JButton("��¼");
		p.add(bn1);
		bn1.addActionListener(this);
		JButton bn2 = new JButton("����");
		p.add(bn2);
		bn2.addMouseListener(this);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String user = new String();
		String password = new String();
		user = jtf1.toString();
		password = jpf.toString();
		if (jtf1.getText().equals("lyy") && jpf.getText().equals("111")) {
			Choose choose = new Choose();
			choose.setVisible(true);
		} else {
			System.out.print("��������������");
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		jtf1.setText("");
		jpf.setText("");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

}

public class Login {
	public static void main(String[] args) {
		new LoginTest();
	}
}