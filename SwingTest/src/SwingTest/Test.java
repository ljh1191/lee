package SwingTest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Test extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextField textField;
	private JComboBox comboBox;
	private JComboBox comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnNewButton());
		contentPane.add(getTextField());
		contentPane.add(getComboBox());
		contentPane.add(getComboBox_1());
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("버튼");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textField.setText("버튼클릭");
				}
			});
			btnNewButton.setBounds(12, 10, 97, 23);
		}
		return btnNewButton;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(121, 11, 301, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(36, 57, 62, 21);
			comboBox.addItem("딸기");
			comboBox.addItem("바나나");
			comboBox.addItem("사과");
		}
		return comboBox;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"딸기", "바나나", "사과"}));
			comboBox_1.setBounds(133, 57, 62, 21);
		}
		return comboBox_1;
	}
}
