package fun;

public class Eightqueen {

	private int s[] = new int[9];
	private int d[][] = new int[100][9];
	private boolean a[] = new boolean[9];
	private boolean b[] = new boolean[17];
	private boolean c[] = new boolean[17];
	private int count = 0;

	public int[][] getD() {
		return d;
	}

	private void output() {
		count++;
		for (int k = 1; k <= 8; k++)
			d[count][k] = s[k];

	}

	private void movequeen(int i, int j) {

		a[j] = b[i + j] = c[i - j + 9] = true;

	}

	/**
	 * 八皇后算法
	 */
	public Eightqueen() {

		int i, j;
		for (i = 2; i <= 16; i++) {
			if (i >= 2 && i <= 9)
				a[i - 1] = true;
			b[i] = c[i] = true;
		}
		i = j = 1;
		while (i >= 1) {
			while (j <= 8) {
				if (a[j] && b[i + j] && c[i - j + 9])
					break;
				j++;
			}
			if (j <= 8) {
				a[j] = b[i + j] = c[i - j + 9] = false;
				s[i] = j;
				if (i == 8) {
					output();
					movequeen(i, j);
					i--;
					j = s[i];
					movequeen(i, j);
					j++;
				} else {
					i++;
					j = 1;
				}
			} else {
				i--;
				if (i >= 1) {
					j = s[i];
					movequeen(i, j);
					j++;
				}
			}

		}

	}

}
