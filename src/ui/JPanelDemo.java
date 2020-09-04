package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

import fun.Eightqueen;

public class JPanelDemo extends JPanel {

	// 二维数组（储存八皇后的解）
	private int a[][] = new int[100][9];
	// 当前解
	public int x = 1;

	/**
	 * 下一解
	 */
	public void xadd() {
		x++;
	}

	/**
	 * 构造方法 得到八皇后所有解 储存在数组中
	 */
	public JPanelDemo() {
		Eightqueen s = new Eightqueen();
		a = s.getD();
	}

	/**
	 * 绘制棋盘
	 */
	private void drawChessboard(Graphics g) {
		g.setColor(Color.BLACK);
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j += 2)
				g.fillRect(60 * (i % 2 + j), 60 * i, 60, 60);
		g.drawRect(0, 0, 480, 480);
	}

	/**
	 * 绘制皇后
	 */
	private void drawChessqueen(Graphics g) {
		g.setColor(Color.RED);
		for (int i = 0; i < 8; i++)
			g.fillOval(i * 60, (a[x][i + 1] - 1) * 60, 60, 60);
	}
	
	/**
	 * 绘制字符串 显示当前解数
	 */
	private void drawText(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font("宋体",Font.BOLD , 20));
		g.drawString("共92解  "+"当前解:"+x, 0, 520);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.drawChessboard(g);
		this.drawChessqueen(g);
		this.drawText(g);
		this.repaint();
	}

}
