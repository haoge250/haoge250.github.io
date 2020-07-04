
public class Test {
	public static void main(String args[]) {
		Node a, b;
		Node ans = new Node();
		int[] s1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // 倒序存，所以是a=987654321
		int[] s2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // 倒序存，所以是b=987654321
		Mb mb = new Mb();
		a = new Node();
		a.setLength(s1.length);
		a.setCm(0);
		a.setS(s1);
		b = new Node();
		b.setLength(s2.length);
		b.setCm(0);
		b.setS(s2);
		mb.Mul(a, b, ans);	//调用两数相乘方法
		System.out.println(ans.length);
		System.out.println(ans.cm);
		for (int i = ans.length - 1; i >= 0; i--) {
			System.out.print(ans.s[i]);//倒序输出(这样才能显示a*b真正的值)
		}
	}
}
