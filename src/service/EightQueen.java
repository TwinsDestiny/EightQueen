package service;

public class EightQueen {

    private int[] position = new int[9];// 存储每行皇后的位置
    private int[][] solutions = new int[100][9];// 存储所有解
    private boolean[] columns = new boolean[9];// 标记列是否被占用
    private boolean[] mainDiagonal = new boolean[17];// 标记主对角线是否被占用
    private boolean[] antiDiagonal = new boolean[17];// 标记副对角线是否被占用
    private int solutionCount = 0;

    public int[][] getSolutions() {
        return solutions;
    }

    private void output() {
        solutionCount++;
        for (int row = 1; row <= 8; row++) {
            solutions[solutionCount][row] = position[row];
        }
    }

    private void moveQueen(int i, int j) {
        columns[j] = mainDiagonal[i + j] = antiDiagonal[i - j + 9] = true;
    }

    /**
     * 八皇后算法
     */
    public EightQueen() {
        int i, j;
        for (i = 2; i <= 16; i++) {
            if (i >= 2 && i <= 9)
                columns[i - 1] = true;
            mainDiagonal[i] = antiDiagonal[i] = true;
        }
        i = j = 1;
        while (i >= 1) {
            while (j <= 8) {
                if (columns[j] && mainDiagonal[i + j] && antiDiagonal[i - j + 9])
                    break;
                j++;
            }
            if (j <= 8) {
                columns[j] = mainDiagonal[i + j] = antiDiagonal[i - j + 9] = false;
                position[i] = j;
                if (i == 8) {
                    output();
                    moveQueen(i, j);
                    i--;
                    j = position[i];
                    moveQueen(i, j);
                    j++;
                } else {
                    i++;
                    j = 1;
                }
            } else {
                i--;
                if (i >= 1) {
                    j = position[i];
                    moveQueen(i, j);
                    j++;
                }
            }
        }
    }

}
