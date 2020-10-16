package Sort;

public class Sort {
	
	//插入排序
	public static void insertSort(int[] a) {
		int length=a.length;
		for(int i=1;i<length;i++) {//a[0] 已排序
			int data=a[i];
			int v;
			for(v=i;v>=1&&a[v-1]>data;v--) {//从v位置开始往回比较大小，直到0或第一个小于data的位置插入
				a[v]=a[v-1];
			}
			a[v]=data;
		}
	}

	//冒泡排序
	public static void bubbleSort(int[] a) {
		int length=a.length;
		for(int i=0;i<length;i++) { //这里的i 代表需要循环的次数
			for(int v=0;v<length-i-1;v++) {//开始冒泡
				if(a[v]>a[v+1]) {
					int temp=a[v+1];
					a[v+1]=a[v];
					a[v]=temp;
				}
			}
		}
	}

	//选择排序
	public static void selectSort(int[] a) {
		int length=a.length;
		int max=a[0];
		int index=0;
		int v;
		for(int i=0;i<length;i++) {//这里的i 代表需要循环的次数
			for(v=0;v<length-i;v++) {
				index=a[v]>max?v:index;
				max=a[v]>max?a[v]:max;
			}
			int temp=a[v-1];//这里-1 v等于了length-i
			a[v-1]=max;
			a[index]=temp;

			max=a[0];
			index=0;
		}
	}

	//希尔排序
	public static void shellSort(int[] a) {
		int add=a.length;
		add=(add/2)+1;//add为增量 增量为1 最后一次
		while(add>0) {
			for(int i=0;i+add<a.length;i++) {
				if(a[i]>a[i+add]) {
					int temp=a[i+add];
					a[i+add]=a[i];
					a[i]=temp;
				}
			}
			add=add/2;
		}
	}

	//快速排序
	public static void quickSort(int[] a,int b,int e){
		int mid = a[b];//以起始点为目标值
		int begin = b;
		int end = e;
		while(begin<end){
			while(a[begin]<mid && begin<end){begin++;}
			while(a[end]>=mid && begin<end){end--;}
			int temp = a[end];
			a[end] = a[begin];
			a[begin] = temp;
		}
		if(b<begin){quickSort(a,b,begin);}
		if(begin+1<e){quickSort(a,begin+1,e);}//防止目标值本身就是最小值，死循环，故 判断begin+1
	}

	
	public static void show(int[] data) {
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i]);
		}
	}
	

	public static void main(String[] args) {
		int[] data= {5,3,3,2,1};
//		insertSort(data);
//		bubbleSort(data);
//		selectSort(data);
//		shellSort(data);
		quickSort(data,0,data.length-1);
		show(data);

}
	}
