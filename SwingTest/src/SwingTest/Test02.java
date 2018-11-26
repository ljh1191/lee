package SwingTest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test02 extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private JLabel label;
	private JTabbedPane tabbedPane;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test02 frame = new Test02();
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
	public Test02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setBackground(SystemColor.activeCaption);
			splitPane.setDividerSize(1);
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getTabbedPane());
			splitPane.setDividerLocation(250);
		}
		return splitPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLabel());
		}
		return panel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("이름");
			label.setFont(new Font("굴림", Font.PLAIN, 16));
			label.setForeground(Color.RED);
			label.setBounds(12, 56, 99, 35);
		}
		return label;
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("New tab", null, getPanel_1(), null);
			tabbedPane.addTab("New tab", null, getPanel_2(), null);
			tabbedPane.addTab("New tab", null, getPanel_3(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getBtnNewButton());
			panel_1.add(getBtnNewButton_1());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(new LineBorder(new Color(153, 180, 209)), "\uC2A4\uC719\uD14C\uC2A4\uD2B8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setLayout(null);
			panel_2.add(getTextField());
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(new BorderLayout(0, 0));
			panel_3.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panel_3;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("h1");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText("하이");
				}
			});
			btnNewButton.setBounds(24, 22, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("h2");
			btnNewButton_1.setBounds(24, 55, 97, 23);
		}
		return btnNewButton_1;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(61, 90, 116, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
