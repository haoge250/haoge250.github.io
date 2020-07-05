public class Zcggzxl {//求解最长公共子序列问题
	/* 二维数组c用来存放各个子问题的最优值 */
	public static void LCSLength(char x[], char y[], int c[][], int b[][]) {
		int m = x.length;
		int n = y.length;
		int i, j;
		for (i = 1; i < m; i++) {
			c[i][0] = 0;
		}
		for (j = 1; j < n; j++) {
			c[0][j] = 0;
		}
		for (i = 1; i < m; i++) { // 控制x序列不同的子问题
			for (j = 1; j < n; j++) { // 控制y序列不同的子问题
				if (x[i] == y[j]) { // 循环从1开始，说明了x数组中x[0]和y数组中y[0]值无用
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = 1;
				} else if (c[i - 1][j] >= c[i][j - 1]) { // 当此数的上面值与左面值相等时，取上面
					c[i][j] = c[i - 1][j];
					b[i][j] = 3;
				} else {
					c[i][j] = c[i][j - 1];
					b[i][j] = 2;
				}
			}
		}
	}

	/* 子序列x的长度-1，子序列y的长度-1，子序列x，二维数组b存放各个子问题最优值的来源 */
	public static void PrintLCS(int i, int j, char x[], int b[][]) {// 将最长公共子序列输出
		if (i == 0 || j == 0) {
			return; // 递归调用的结束条件
		}
		if (b[i][j] == 1) {
			PrintLCS(i - 1, j - 1, x, b);
			System.out.print(x[i]);
		} else if (b[i][j] == 2) {
			PrintLCS(i, j - 1, x, b);
		} else {
			PrintLCS(i - 1, j, x, b);
		}
	}

	public static void main(String args[]) {
		char[] x = { '0', 'A', 'B', 'C', 'B', 'D', 'A', 'B' };
		char[] y = { '0', 'B', 'D', 'C', 'A', 'B', 'A' };//第一位无用
		int i = x.length;
		int j = y.length;
		int c[][] = new int[i][j];
		int b[][] = new int[i][j];	//8行7列
		LCSLength(x, y, c, b); // 得出最优值
		PrintLCS(i-1, j-1, x, b); // 输出最优值
	}
}