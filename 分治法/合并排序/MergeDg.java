public class MergeDg{
	
	public static void main(String args[]){//用递归方法实现合并排序。
		int s[]={42,15,20,6,8,38,50,12};//这是一个无序数组
		int low=0;
		int high=s.length-1;
		mergeSort(s,low,high);
		for(int i=0;i<=high;i++){
			System.out.println("排序后的下标为"+i+"的值:"+s[i]);
		}
	}
	
	public static void merge(int s[],int low,int middle,int high){//这里是排序
		int i=low;
		int j=middle+1;
		int k=0;
		int b[]=new int[high-low+1];//b数组的大小取值为high-low+1很好。
		while(i<=middle && j<=high){
			if(s[i]<=s[j]){//加上等于是为了保持s[i]=s[j]时，其相对位置还是不变。
				b[k]=s[i];
				i++;
				k++;
			}else{
				b[k]=s[j];
				j++;
				k++;
			}
		}
		while(i<=middle){//将剩余的值赋给数组b
			b[k]=s[i];
			i++;
			k++;
		}
		while(j<=high){
			b[k]=s[j];
			j++;
			k++;
		}
		for(i=low,k=0;i<=high;i++){//将值赋给数组时要留意，b数组的下标是从0开始
			s[i]=b[k++];           //s数组的下标是从low开始，到high结束。
		}
	}
	
	public static void mergeSort(int s[],int low,int high){//这里是分组
		if(low<high){ //最多就是low=high,所以加个=就是个死循环。
			int middle=(low+high)/2;    //在这里是采用递归。
			mergeSort(s,low,middle);
			mergeSort(s,middle+1,high);
			merge(s,low,middle,high);
		}
	}
}