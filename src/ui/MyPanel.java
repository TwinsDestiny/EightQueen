package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

import service.EightQueen;

public class MyPanel extends JPanel {

	// 二维数组（储存八皇后的解）
	private int result[][] = new int[100][9];
	// 当前解
	private int index = 1;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * 下一解
	 */
	public void next() {
		index++;
	}

	/**
	 * 构造方法 得到八皇后所有解 储存在数组中
	 */
	public MyPanel() {
		EightQueen eightQueen = new EightQueen();
		result = eightQueen.getSolutions();
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
			g.fillOval(i * 60, (result[index][i + 1] - 1) * 60, 60, 60);
	}
	
	/**
	 * 绘制字符串 显示当前解数
	 */
	private void drawText(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font("宋体",Font.BOLD , 20));
		g.drawString("共92解  "+"当前解:"+ index, 0, 520);
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
