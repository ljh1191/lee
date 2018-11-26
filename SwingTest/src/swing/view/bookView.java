package swing.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import swing.model.BookBean;
import swing.model.BookDBA;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class bookView extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JSplitPane splitPane_1;
	private JSplitPane splitPane_2;
	private JButton btnInsert;
	private JPanel panel;
	private JTextField tfTitle;
	private JLabel lblNewLabel;
	private JLabel label;
	private JTextField tfWriter;
	private JLabel label_1;
	private JTextField tfIndate;
	private JLabel label_2;
	private JTextField tfOutdate;
	private JLabel label_3;
	private JTextField tfGubun;
	private JLabel label_4;
	private JTextField tfPrice;
	private JSplitPane splitPane_3;
	private JButton btnView;
	private JScrollPane scrollPane;
	private JTextArea taView;
	private JScrollPane scrollPane_1;
	private JTable table;

	BookDBA dba = new BookDBA();
	ArrayList<BookBean> arr;
	int num;
	private JPanel panel_1;
	private JButton btnUpdate;
	private JButton btnDelete;
	DecimalFormat df = new DecimalFormat("###,###");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookView frame = new bookView();
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
	public bookView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
//		String [] cols = {"TITLE","WRITER","OUTDATE","PRICE"};
//		DefaultTableModel dt = new DefaultTableModel(cols, 0);
//		table.setModel(dt);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getSplitPane_1());
			splitPane.setRightComponent(getSplitPane_3());
			splitPane.setDividerLocation(270);
		}
		return splitPane;
	}

	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setRightComponent(getSplitPane_2());
			splitPane_1.setLeftComponent(getScrollPane_1());
			splitPane_1.setDividerLocation(120);
		}
		return splitPane_1;
	}

	private JSplitPane getSplitPane_2() {
		if (splitPane_2 == null) {
			splitPane_2 = new JSplitPane();
			splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_2.setRightComponent(getBtnInsert());
			splitPane_2.setLeftComponent(getPanel());
			splitPane_2.setDividerLocation(250);
		}
		return splitPane_2;
	}

	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("입력하기");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					BookBean b = new BookBean();
					b.setTitle(tfTitle.getText());
					b.setWriter(tfWriter.getText());
					b.setIndate(tfIndate.getText());
					b.setOutdate(tfOutdate.getText());
					b.setGubun(tfGubun.getText());
					b.setPrice(Integer.parseInt(tfPrice.getText().replaceAll(",", "")));
					dba.BookInsert(b);
					btnView.doClick();
				}
			});
		}
		return btnInsert;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getTfTitle());
			panel.add(getLblNewLabel());
			panel.add(getLabel());
			panel.add(getTfWriter());
			panel.add(getLabel_1());
			panel.add(getTfIndate());
			panel.add(getLabel_2());
			panel.add(getTfOutdate());
			panel.add(getLabel_3());
			panel.add(getTfGubun());
			panel.add(getLabel_4());
			panel.add(getTfPrice());
		}
		return panel;
	}

	private JTextField getTfTitle() {
		if (tfTitle == null) {
			tfTitle = new JTextField();
			tfTitle.setBounds(100, 10, 116, 21);
			tfTitle.setColumns(10);
		}
		return tfTitle;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("제목");
			lblNewLabel.setBounds(31, 13, 57, 15);
		}
		return lblNewLabel;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("저자");
			label.setBounds(31, 44, 57, 15);
		}
		return label;
	}

	private JTextField getTfWriter() {
		if (tfWriter == null) {
			tfWriter = new JTextField();
			tfWriter.setColumns(10);
			tfWriter.setBounds(100, 41, 116, 21);
		}
		return tfWriter;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("입고날짜");
			label_1.setBounds(31, 72, 57, 15);
		}
		return label_1;
	}

	private JTextField getTfIndate() {
		if (tfIndate == null) {
			tfIndate = new JTextField();
			tfIndate.setColumns(10);
			tfIndate.setBounds(100, 69, 116, 21);
		}
		return tfIndate;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("출고날짜");
			label_2.setBounds(31, 103, 57, 15);
		}
		return label_2;
	}

	private JTextField getTfOutdate() {
		if (tfOutdate == null) {
			tfOutdate = new JTextField();
			tfOutdate.setColumns(10);
			tfOutdate.setBounds(100, 100, 116, 21);
		}
		return tfOutdate;
	}

	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("책분류");
			label_3.setBounds(31, 131, 57, 15);
		}
		return label_3;
	}

	private JTextField getTfGubun() {
		if (tfGubun == null) {
			tfGubun = new JTextField();
			tfGubun.setColumns(10);
			tfGubun.setBounds(100, 128, 116, 21);
		}
		return tfGubun;
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("가격");
			label_4.setBounds(31, 159, 57, 15);
		}
		return label_4;
	}

	private JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setColumns(10);
			tfPrice.setBounds(100, 156, 116, 21);
		}
		return tfPrice;
	}

	private JSplitPane getSplitPane_3() {
		if (splitPane_3 == null) {
			splitPane_3 = new JSplitPane();
			splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_3.setLeftComponent(getScrollPane());
			splitPane_3.setRightComponent(getPanel_1());
			splitPane_3.setDividerLocation(380);
		}
		return splitPane_3;
	}
	//보기
	private JButton getBtnView() {
		if (btnView == null) {
			btnView = new JButton("보기");
			btnView.setBounds(12, 10, 75, 24);
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					taView.setText("");
					arr = dba.BookView();
//					for (BookBean b : arr) {
//						taView.append("번호 : " + b.getNum() + "\n");
//						taView.append("제목 : " + b.getTitle() + "\n");
//						taView.append("저자 : " + b.getWriter() + "\n");
//						taView.append("입고날짜 : " + b.getIndate() + "\n");
//						taView.append("출고날짜 : " + b.getOutdate() + "\n");
//						taView.append("책분류 : " + b.getGubun() + "\n");
//						taView.append("가격 : " + b.getPrice() + "\n\n");
//					}
					String[] cols = { "TITLE", "WRITER", "OUTDATE", "PRICE" };
					DefaultTableModel dt = new DefaultTableModel(cols, arr.size());
					table.setModel(dt);
					for (int i = 0; i < arr.size(); i++) {
						dt.setValueAt(arr.get(i).getTitle(), i, 0);
						dt.setValueAt(arr.get(i).getWriter(), i, 1);
						dt.setValueAt(arr.get(i).getOutdate(), i, 2);
						dt.setValueAt(df.format(arr.get(i).getPrice()), i, 3);
					}
				}
			});
		}
		return btnView;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTaView());
		}
		return scrollPane;
	}

	private JTextArea getTaView() {
		if (taView == null) {
			taView = new JTextArea();
		}
		return taView;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTable_1());
		}
		return scrollPane_1;
	}

	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					taView.setText("");
					//btnUpdate.setEnabled(true);
					//btnDelete.setEnabled(true);
					int i = table.getSelectedRow();
					taView.append("번호 : " + arr.get(i).getNum() + "\n");
					taView.append("제목 : " + arr.get(i).getTitle() + "\n");
					taView.append("저자 : " + arr.get(i).getWriter() + "\n");
					taView.append("입고날짜 : " + arr.get(i).getIndate() + "\n");
					taView.append("출고날짜 : " + arr.get(i).getOutdate() + "\n");
					taView.append("책분류 : " + arr.get(i).getGubun() + "\n");
					taView.append("가격 : " + df.format(arr.get(i).getPrice()) + "\n\n");
					tfTitle.setText(arr.get(i).getTitle());
					tfWriter.setText(arr.get(i).getWriter());
					tfIndate.setText(arr.get(i).getIndate());
					tfOutdate.setText(arr.get(i).getOutdate());
					tfGubun.setText(arr.get(i).getGubun());
					tfPrice.setText(String.valueOf(arr.get(i).getPrice()));
					num =  arr.get(i).getNum();
				}
			});
			String[] cols = { "TITLE", "WRITER", "OUTDATE", "PRICE" };
			DefaultTableModel dt = new DefaultTableModel(cols, 0);
			table.setModel(dt);
		}
		return table;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getBtnView());
			panel_1.add(getBtnUpdate());
			panel_1.add(getBtnDelete());
		}
		return panel_1;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수정");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					BookBean b = new BookBean();
					b.setTitle(tfTitle.getText());
					b.setWriter(tfWriter.getText());
					b.setIndate(tfIndate.getText());
					b.setOutdate(tfOutdate.getText());
					b.setGubun(tfGubun.getText());
					b.setPrice(Integer.parseInt(tfPrice.getText()));
					//b.setNum(num);
					dba.BookUpdate(b,num);
					btnView.doClick();
				}
			});
			btnUpdate.setBounds(111, 11, 75, 23);
		}
		//btnUpdate.setEnabled(false);
		return btnUpdate;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "삭제할까요?","confirm",JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.YES_OPTION) {
						dba.BookDelete(num);
						btnView.doClick();
					}
				}
			});
			btnDelete.setBounds(205, 11, 75, 23);
		}
		//btnDelete.setEnabled(false);
		return btnDelete;
	}
}
