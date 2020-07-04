
public class Mb {
	/* src待分解，dec是分解后，st表示开始位置(就是下标)，l代表长度 */
	public void Cp(Node src, Node dec, int st, int l) {//划分方法
		int i;
		int j;
		for (i = st, j = 0; i < st + l; i++, j++) {
			dec.s[j] = src.s[i];
		}
		dec.length = l;
		dec.cm = src.cm + st;
	}

	public void Add(Node pa, Node pb, Node ans) {// 将分解的数进行相加
		int cc;
		int k;
		Node temp;
		int alen;
		int blen;
		int len;
		int i;
		int ta; // 相加时pa的对应位
		int tb; // 相加时pb的对应位
		if (pa.cm < pb.cm) { // 交换保证pa的幂大
			temp = pb;
			pb = pa;
			pa = temp;
		}
		ans.cm = pb.cm; // 结果的次幂为结果中较小的次幂
		cc = 0; // 初始进位cc为0
		k = pa.cm - pb.cm; // k为pa左侧需要补零的个数
		alen = pa.length + pa.cm;
		blen = pb.length + pb.cm;
		if (alen > blen) { // 取pa,pb总长度最大值
			len = alen;
		} else {
			len = blen;
		}
		len = len - pb.cm; // 最低次幂不进行加法运算
		for (i = 0; i < len; i++) {
			if (i < k) { // pa左侧位上的数是0
				ta = 0;
			} else {
				ta = pa.s[i - k];
			}
			if (i < pb.length) {
				tb = pb.s[i];
			} else {
				tb = 0; // pb数字先取完，pb右侧补0
			}
			if (i >= pa.length + k) { // pa数字先取完，pa右侧补0
				ta = 0;
			}
			ans.s[i] = (ta + tb + cc) % 10; // 记录两数之和的个位数，商做进位处理
			cc = (ta + tb + cc) / 10;
		}
		if (cc != 0) {
			ans.s[i] = cc;
			i++;
		}
		ans.length = i;
	}

	public void Mul(Node pa, Node pb, Node ans) {//乘法运算
		int ma = pa.length / 2;	//大整数a的长度的一半
		int mb = pb.length / 2;	//大整数b的长度的一半
		Node temp;
		int w;
		int cc;	//表示进位
		int i;
		Node ah = new Node();
		Node al = new Node();
		Node bh = new Node();
		Node bl = new Node();
		Node t1 = new Node();
		Node t2 = new Node();
		Node t3 = new Node();
		Node t4 = new Node();
		Node z = new Node();
		if (ma == 0 || mb == 0) { // 如果其中有个位数为1
			if (ma == 0) { // 如果pa的长度为1，pa,pb交换，pa的长度大于pb的长度
				temp = pb;
				pb = pa;
				pa = temp;
			}
			ans.cm = pa.cm + pb.cm;	//结果的次幂等于两乘数次幂之和
			w = pb.s[0];	//存放的是个一位数整数
			cc = 0; // 进位初始化为0
			for (i = 0; i < pa.length; i++) {
				ans.s[i] = (pa.s[i] * w + cc) % 10;
				cc = (pa.s[i] * w + cc) / 10;
			}
			if (cc != 0) {	//如果还有进位就还要放入结果中
				ans.s[i] = cc;
				i = i + 1;
			}
			ans.length = i;
			return;	//处理完成要结束
		}
		//分治法的核心
		Cp(pa, ah, ma, pa.length - ma); // 先分成四个部分
		Cp(pa, al, 0, ma);
		Cp(pb, bh, mb, pb.length - mb);
		Cp(pb, bl, 0, mb);

		Mul(ah, bh, t1); // 分成四个部分相乘，这里实现递归调用
		Mul(ah, bl, t2);
		Mul(al, bh, t3);
		Mul(al, bl, t4);

		Add(t3, t4, ans); // 将分开相乘的全部加起来
		Add(t2, ans, z);
		Add(t1, z, ans);

	}
}
