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
		add=add/2;//add为增量 增量为1 最后一次
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
		if(b>=e){
			return;
		}
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
		quickSort(a,b,begin-1);
		quickSort(a,begin==b?begin+1:begin,e);//begin+1 防止目标值就是最小值 递归溢出
	}

	//归并排序
//	public static void mergeSort(int[] a){
//		int length = a.length;
//		if(length>1){
//			int length_2 = length/2;
//
//			int[] subL = new int[length_2];
//			System.arraycopy(a,0,subL,0,length_2);
//			mergeSort(subL);
//
//			int[] subR = new int[length-length_2];
//			System.arraycopy(a,length_2,subR,0,length-length_2);
//			mergeSort(subR);
//
//			int cursorL = 0;
//			int cursorR = 0;
//			for(int i=0;i<length;i++){
//				if(cursorR==length-length_2 ||subL[cursorL]<=subR[cursorR]){
//					a[i]=subL[cursorL];
//					cursorL++;
//				}else if(cursorL==length_2 ||subL[cursorL]>subR[cursorR]){
//					a[i]=subR[cursorR];
//					cursorR++;
//				}
//			}
//		}
//	}

	
	public static void show(int[] data) {
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i]);
		}
	}
	

	public static void main(String[] args) {
		int[] data= {6,5,4,3,3,3,4,2,14,1};
//		insertSort(data);
//		bubbleSort(data);
//		selectSort(data);
//		quickSort(data,0,data.length-1);

 		shellSort(data);

//		mergeSort(data);
		show(data);
}
	}
