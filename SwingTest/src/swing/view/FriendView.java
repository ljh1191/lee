package swing.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import swing.model.Friend;
import swing.model.FriendDBAimpl;

public class FriendView extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField tfName;
	private JTextField tfBirth;
	private JTextField tfPhone;
	private JTextField tfAddr;
	private JButton button;
	private JButton button_1;
	private JSplitPane splitPane_1;
	private JPanel panel_2;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JTextArea taView;
	private JTextField tfSearch;
	private JButton btn;
	
	FriendDBAimpl dba = new FriendDBAimpl();
	private JTextField tf;
	private JButton btnSelect;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendView frame = new FriendView();
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
	public FriendView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getSplitPane_1());
			splitPane.setDividerLocation(230);
		}
		return splitPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "\uCE5C\uAD6C\uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setLayout(null);
			panel.add(getLabel());
			panel.add(getLabel_1());
			panel.add(getLabel_2());
			panel.add(getLabel_3());
			panel.add(getTfName());
			panel.add(getTfBirth());
			panel.add(getTfPhone());
			panel.add(getTfAddr());
			panel.add(getButton());
			panel.add(getButton_1());
			panel.add(getTf());
			panel.add(getBtnSelect());
			panel.add(getBtnUpdate());
			panel.add(getBtnDelete());
			panel.add(getBtnNewButton());
		}
		return panel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("이름");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setBounds(12, 61, 57, 15);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("생일");
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setBounds(12, 94, 57, 15);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("전화번호");
			label_2.setHorizontalAlignment(SwingConstants.RIGHT);
			label_2.setBounds(12, 127, 57, 15);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("주소");
			label_3.setHorizontalAlignment(SwingConstants.RIGHT);
			label_3.setBounds(12, 160, 57, 15);
		}
		return label_3;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(72, 58, 116, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfBirth() {
		if (tfBirth == null) {
			tfBirth = new JTextField();
			tfBirth.setColumns(10);
			tfBirth.setBounds(72, 91, 116, 21);
		}
		return tfBirth;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(72, 124, 116, 21);
		}
		return tfPhone;
	}
	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setColumns(10);
			tfAddr.setBounds(72, 157, 116, 21);
		}
		return tfAddr;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("전체보기");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					taView.setText("");
					ArrayList<Friend> arr = dba.friendView();
					for(Friend f : arr) {
						taView.append("번호 : "+ f.getNum()+"\n");
						taView.append("이름 : "+ f.getName()+"\n");
						taView.append("생일 : "+ f.getBirth()+"\n");
						taView.append("전화번호 : "+ f.getPhone()+"\n");
						taView.append("주소 : "+ f.getAddr()+"\n\n");
					}
				}
			});
			button.setBounds(12, 246, 97, 23);
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("추가");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent argo) {
					Friend f = new Friend();
					f.setName(tfName.getText());
					f.setBirth(tfBirth.getText());
					f.setPhone(tfPhone.getText());
					f.setAddr(tfAddr.getText());
					dba.friendInsert(f);
					button.doClick();
				}
			});
			button_1.setBounds(120, 246, 97, 23);
		}
		return button_1;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setRightComponent(getPanel_2());
			splitPane_1.setLeftComponent(getScrollPane());
			splitPane_1.setDividerLocation(280);
		}
		return splitPane_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.add(getComboBox());
			panel_2.add(getTfSearch());
			panel_2.add(getBtn());
		}
		return panel_2;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"선택하세요", "이름", "주소"}));
			comboBox.setBounds(12, 24, 67, 21);
		}
		return comboBox;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\uC804\uCCB4\uBCF4\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPane.setViewportView(getTextArea_1());
		}
		return scrollPane;
	}
	private JTextArea getTextArea_1() {
		if (taView == null) {
			taView = new JTextArea();
		}
		return taView;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(80, 24, 84, 21);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtn() {
		if (btn == null) {
			btn = new JButton("검색");
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String key = "";
					if (comboBox.getSelectedIndex() == 1) {
						key = "name";
					} else if (comboBox.getSelectedIndex() == 2) {
						key = "addr";
					}else {
						tfSearch.setText("선택오류");
						return;
					}
					ArrayList<Friend> arr = dba.friendSearch(key,tfSearch.getText());
					taView.setText("");
					for(Friend f : arr) {
						taView.append("번호 : "+ f.getNum()+"\n");
						taView.append("이름 : "+ f.getName()+"\n");
						taView.append("생일 : "+ f.getBirth()+"\n");
						taView.append("전화번호 : "+ f.getPhone()+"\n");
						taView.append("주소 : "+ f.getAddr()+"\n\n");
					}
				}
			});
			btn.setBounds(163, 23, 61, 23);
		}
		return btn;
	}
	private JTextField getTf() {
		if (tf == null) {
			tf = new JTextField();
			tf.setBounds(12, 279, 97, 21);
			tf.setColumns(10);
		}
		return tf;
	}
	private JButton getBtnSelect() {
		if (btnSelect == null) {
			btnSelect = new JButton("상세보기");
			btnSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
					int num = Integer.parseInt(tf.getText());
					Friend f = dba.friendSelect(num);
			/*		if(f==null) {
						JOptionPane.showMessageDialog(null, "찾는친구가 없습니다.");
					}*/
					tfName.setText(f.getName());
					tfBirth.setText(f.getBirth());
					tfPhone.setText(f.getPhone());
					tfAddr.setText(f.getAddr());
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
				}catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, " 숫자넣기.");
				}catch (NullPointerException  e2) {
					JOptionPane.showMessageDialog(null, "찾는친구가 없습니다.");
				}
				}	
			});
			btnSelect.setBounds(120, 278, 97, 23);
		}
		return btnSelect;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수정");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int num = Integer.parseInt(tf.getText());
					Friend f = new Friend();
					f.setName(tfName.getText());
					f.setBirth(tfBirth.getText());
					f.setPhone(tfPhone.getText());
					f.setAddr(tfAddr.getText());
					dba.friendUpdate(f,num);
					button.doClick();
				}
			});
			btnUpdate.setBounds(12, 310, 97, 23);
			btnUpdate.setEnabled(false);
		}
		return btnUpdate;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "삭제할까요?","confirm",JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.YES_OPTION) {
						int num = Integer.parseInt(tf.getText());
						dba.friendDelete(num);
						button.doClick();
					}
				}
			});
			btnDelete.setEnabled(false);
			btnDelete.setBounds(120, 311, 97, 23);
		}
		return btnDelete;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("공백");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfName.setText("");
					tfBirth.setText("");
					tfPhone.setText("");
					tfAddr.setText("");
					tf.setText("");
				}
			});
			btnNewButton.setBounds(120, 216, 68, 23);
		}
		return btnNewButton;
	}
}
