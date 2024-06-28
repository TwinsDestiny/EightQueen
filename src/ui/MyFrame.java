package ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame {

	public MyFrame() {
		// 设置标题
		setTitle("八皇后全解");
		// 设置关闭窗口
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗口大小
		setSize(487, 580);
		// 不允许用户改变窗口大小
		setResizable(false);
		// 居中
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = screen.width - this.getWidth() >> 1;
		int y = (screen.height - this.getHeight() >> 1) - 20;
		this.setLocation(x, y);
		// 创建一个JPanel的实例
		final MyPanel panel = new MyPanel();
		// 设置无布局
		panel.setLayout(null);
		// 添加Panel
		setContentPane(panel);
		// 创建JButton实例
		JButton button = new JButton("Next");
		// 设置按钮位置
		button.setBounds(190, 500, 100, 30);
		// 将JButton实例添加到JPanel中
		panel.add(button);
		// 添加按钮监听器
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				if (panel.getIndex() >= 92) {
					JOptionPane.showMessageDialog(null, "已显示所有解!");
					panel.setIndex(0);
				}
				panel.next();
			}
		});
		setVisible(true);
	}

}