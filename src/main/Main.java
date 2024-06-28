package main;

import ui.MyFrame;

public class Main extends Thread {

	/**
	 * 主函数
	 */
	public static void main(String[] args) {
		new Main("eightqueen").start();
	}

	public Main(String name) {
		super(name);
	}

	@Override
	public void run() {
		new MyFrame();
	}

}
