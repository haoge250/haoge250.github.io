public class Merge{
	//合并排序，就是两个有序子序列合并成一个
	public static void main(String args[]){
		int s[]={4,9,15,24,30,2,6,18,20,23,45,};
		int low=0;
		int middle=4; //其实表达的意思不是最中间元素，是第一个子序列的最后一个数的下标。
		int high=s.length-1;
		merge(s,low,middle,high);
		for(int i=0;i<=high;i++){
			System.out.println("排序后的下标为"+i+"的值:"+s[i]);
		}
	}
	
	public static void merge(int s[],int low,int middle,int high){
		int i=low;//第一个子序列的开始
		int j=middle+1;//第二个子序列的开始
		int k=0;
		int a[]=new int[high+1];//中间数组，把排好顺序的值放入数组a中。
		while(i<=middle && j<=high){
			if(s[i]<=s[j]){//虽然以下可以更简写，但是为了方便理解还是不简写。
				a[k]=s[i];
				i++;
				k++;
			}else{
				a[k]=s[j];
				j++;
				k++;
			}
		}
		while(i<=middle){//把剩下的值赋值给数组a。
			a[k]=s[i];
			i++;
			k++;
		}
		while(j<=high){
			a[k]=s[j];
			j++;
			k++;
		}
		for(i=0;i<=high;i++){
			s[i]=a[i];
		}
	}
}