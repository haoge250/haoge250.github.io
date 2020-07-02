public class QuickSort2{//优化的快速排序
	public static void main(String args[]){
		int s[]={30,24,5,58,20,36,12,12,12};
		fen(s,0,s.length-1);
		//可以把上条语句注释，看看下面这条语句的排序是否错误。
		//System.out.println("基准元素的下标"+f2(s,0,s.length-1));
		for(int i=0;i<=s.length-1;i++){
				System.out.println("排序后的下标为"+i+"的值:"+s[i]);
		}
	}
	//每躺排序只是排好一个数
	public static int f2(int s[],int low,int high){//返回基准元素的下标。
		int i=low;
		int j=high;
		int point=s[i];//默认第一个数是为基准元素。
		int swap;
		while(i<j){
			while(i<j&&point<=s[j]){//寻找一个小于point的数，未找到就j--
				j--;    //我看好多教材这里是小于，而我是小于等于，我想让相同的数相对位置还是不发生改变
			}
			
			while(i<j&&point>=s[i]){//寻找一个大于point的数，未找到就i++
				i++;
			}
			if(i<j){//这里要写条件
				swap=s[j];
				s[j]=s[i];
				s[i]=swap;
				i++;    //交换后，i要加一，j要减一，可能造成i>j与i=j两种情况
				j--;    //这里的i和j要发生改变，这里忘了变化也调试好久
			}
		}
		if(point<s[i]){//s[i]比基准元素大就把下标为i的前一个数与point交换（如果为了理解还可以&& i>0）
			s[low]=s[i-1]; //相同的数比较无法进入交换，使得相同的数的相对位置不变 
			s[i-1]=point;//这里是跟s[i-1]交换，没写i-1而写成i,调试了好久
			return i-1;
		}
		s[low]=s[i];
		s[i]=point;
		return i;
	}
	
	public static void fen(int s[],int low,int high){//分解
		if(low<high){//low=high,就是一个数，没有排序的概念。
			int middle=f2(s,low,high);//这里是基准元素的下标
			fen(s,low,middle-1);  
			fen(s,middle+1,high);
		}
	}
}