package sort;

import tree.BinarySortTree;

/**
 * @author String
 */
public final class SortUtils {

    private SortUtils(){}

	public static void insertSort(int[] a) {
		int length=a.length;
		//a[0] 已排序
		for(int i=1;i<length;i++) {
			int data=a[i];
			int v;
			//从v位置开始往回比较大小,直到0或第一个小于data的位置插入
			for(v=i;v>=1&&a[v-1]>data;v--) {
				a[v]=a[v-1];
			}
			a[v]=data;
		}
	}

	public static void bubbleSort(int[] a) {
		int length=a.length;
		//这里的i 代表需要循环的次数
		for(int i=0;i<length;i++) {
			//开始冒泡
			for(int v=0;v<length-i-1;v++) {
				if(a[v]>a[v+1]) {
					int temp=a[v+1];
					a[v+1]=a[v];
					a[v]=temp;
				}
			}
		}
	}

	public static void selectSort(int[] a) {
		int length=a.length;
		int max=a[0];
		int index=0;
		int v;
		//这里的i 代表需要循环的次数
		for(int i=0;i<length;i++) {
			for(v=0;v<length-i;v++) {
				index=a[v]>max?v:index;
				max=a[v]>max?a[v]:max;
			}
			//这里-1 v等于了length-i
			int temp=a[v-1];
			a[v-1]=max;
			a[index]=temp;

			max=a[0];
			index=0;
		}
	}

	public static void shellSort(int[] a) {
		int add=a.length;
		//add为增量 增量为1 最后一次
		add=add/2;
		while(add>0) {
			for(int i=0;i<add;i++){
				//内部是个插入排序
				for(int v=add+i;v<a.length;v+=add){
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

	public static void quickSort(int[] a,int b,int e){
		if(b>=e){
			return;
		}
		//以起始点为目标值
		int mid = a[b];
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
		//begin+1 防止目标值就是最小值 递归溢出
		quickSort(a,begin==b?begin+1:begin,e);
	}

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
				boolean operateL = cursorR==length-length2 || (cursorL<length2 && subL[cursorL]<=subR[cursorR]);
				boolean operateR = cursorL==length2 ||  (cursorR<length-length2 && subL[cursorL]>subR[cursorR]);
				if(operateL){
					a[i]=subL[cursorL];
					cursorL++;
				}else if(operateR){
					a[i]=subR[cursorR];
					cursorR++;
				}
			}
		}
	}

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
}
