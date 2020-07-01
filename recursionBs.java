public class recursionBs{
	public static void main(String args[]){//递归实现二分查找，递归方法一定要慎用，一般是不推荐使用
		int s[]={11,12,13,18,20};
		System.out.println(recursion(s,0,s.length-1,17));
	}
	public static int recursion(int s[],int low,int high,int x){
		
		if(low>high)
			return -1;
		int middle=(low+high)/2;
		if(x==s[middle])
			return middle;
		else if(x<s[middle]){
			return recursion(s,low,middle-1,x);
		}else{
			return recursion(s,middle+1,high,x);
		}
		
	}
}