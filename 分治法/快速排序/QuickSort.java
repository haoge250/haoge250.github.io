public class QuickSort{
	public static void main(String args[]){
		int s[]={30,24,5,58,18,36,12,30,39};
		fen(s,0,s.length-1);
		//可以把上条语句注释，看看下面这条语句的排序是否错误。
		//System.out.println("基准元素的下标"+f(s,0,s.length-1));
		for(int i=0;i<=s.length-1;i++){
				System.out.println("排序后的下标为"+i+"的值:"+s[i]);
		}
	}
	//每躺排序只是排好一个数
	public static int f(int s[],int low,int high){//返回基准元素的下标。
		int i=low;
		int j=high;
		int point=s[i];//默认第一个数是为基准元素。
		while(i<j){
			while(i<j&&point<=s[j]){
				j--;
			}
			     /*这里要写i<j，虽然最外层是i<j，按理应该不用，但是第二
				 个while改变了j的值，在已经排好顺序的序列中可能会出错。
				 i一定要小于j，才能执行{}中的语句*/
			if(i<j){
				s[i]=s[j];         
				s[j]=point;
				i++;
			}
			while(i<j&&point>=s[i]){
				i++;
			}
			if(i<j){
				s[j]=s[i];
				s[i]=point;
				j--;	
			}
		}
		return i;//i=j时就是基准元素的下标
	}
	
	public static void fen(int s[],int low,int high){//分解
		if(low<high){//low=high,就是一个数，没有排序的概念。
			int middle=f(s,low,high);//这里是基准元素的下标
			fen(s,low,middle-1);  
			fen(s,middle+1,high);
		}
	}
}