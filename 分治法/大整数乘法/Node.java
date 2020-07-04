
public class Node {
	static int M = 1000;	//设置大整数最高位数
	int s[] = new int[M];
	int length;	//大整数长度
	int cm;	//大整数次幂
	
	public int[] getS() {
		return s;
	}

	public void setS(int[] s) {
		this.s = s;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getCm() {
		return cm;
	}

	public void setCm(int cm) {
		this.cm = cm;
	}

}
