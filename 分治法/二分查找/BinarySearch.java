public class BinarySearch{
	public static void main(String args[]){//二分查找
		int s[]={11,12,13,18,20};
		System.out.println("寻找元素的数组下标是:"+BinarySearch(5,s,13));
	}
	
	public static int BinarySearch(int n,int s[],int x){
		int low=0;
		int high=n-1;
		while(low<=high){//当数组中元素一个、两个时，low=high有用
			int middle=(low+high)/2;
			if(x==s[middle]){
				return middle;//返回的是下标
			}
			else if(x<s[middle]){
				high=middle-1;
			}else{
				low=middle+1;
			}	
		}
		return -1;
	}
}