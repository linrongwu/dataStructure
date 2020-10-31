package sort;

import tree.BinarySortTree;

public final  class Sort {

    private Sort(){};

    //插入排序
	public static void insertSort(int[] a) {
		int length=a.length;
		for(int i=1;i<length;i++) {//a[0] 已排序
			int data=a[i];
			int v;
			for(v=i;v>=1&&a[v-1]>data;v--) {//从v位置开始往回比较大小,直到0或第一个小于data的位置插入
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
			for(int i=0;i<add;i++){
				for(int v=add+i;v<a.length;v+=add){ //内部是个插入排序
					int temp = a[v];
					int beforeV = v-add;
					while(beforeV>=0 && a[beforeV]>temp) {
						a[beforeV+add]=a[beforeV];
						beforeV -=add;
					}
					a[beforeV + add] = temp;
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
	public static void mergeSort(int[] a){
		int length = a.length;
		if(length>1){
			int length2 = length/2;

			int[] subL = new int[length2];
			System.arraycopy(a,0,subL,0,length2);
			mergeSort(subL);

			int[] subR = new int[length-length2];
			System.arraycopy(a,length2,subR,0,length-length2);
			mergeSort(subR);

			int cursorL = 0;
			int cursorR = 0;
			for(int i=0;i<length;i++){
				if(cursorR==length-length2 || (cursorL<length2 && subL[cursorL]<=subR[cursorR])){
					a[i]=subL[cursorL];
					cursorL++;
				}else if(cursorL==length2 ||  (cursorR<length-length2) && subL[cursorL]>subR[cursorR]){
					a[i]=subR[cursorR];
					cursorR++;
				}
			}
		}
	}

	//堆排序
	public static void heapSort(int[] a){
		BinarySortTree bTree=new BinarySortTree();
		for(int data:a){
			bTree.buildTree(data);
		}
		bTree.orderByIn();
	}

	
	public static void show(int[] data) {
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i]);
		}
	}
	

	public static void main(String[] args) {
		int[] data= {55,2,6,4,32,12,9,73,26,37};
//		insertSort(data);
//		bubbleSort(data);
//		selectSort(data);
//		quickSort(data,0,data.length-1);
//		mergeSort(data);
// 		shellSort(data);
//		show(data);
		heapSort(data);
	}
}
