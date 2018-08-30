package Sort;

public class Sort {
	
	
	public static void insertSort(int[] a) {
		int lenght=a.length;
		for(int i=1;i<lenght;i++) {
			int data=a[i];
			int j;
			for(j=i;j>=1&&a[j-1]>data;j--) {
				a[j]=a[j-1];
			}
			a[j]=data;
		}
	}
	
	public static void bubbleSort(int[] a) {
		int lenght=a.length;
		for(int i=0;i<lenght;i++) {
			for(int j=0;j<lenght-i-1;j++) {
				if(a[j]>a[j+1]) {
					int temp=a[j+1];
					a[j+1]=a[j];
					a[j]=temp;
					
				}
			}
		}
	}
	
	public static void SelectSort(int[] a) {
		int lenght=a.length;
		int max=a[0];
		int index=0;
		int j;
		for(int i=0;i<lenght;i++) {
			for(j=0;j<lenght-i;j++) {
				index=a[j]>max?j:index;
				max=a[j]>max?a[j]:max;
			}
			int temp=a[j-1];
			a[j-1]=max;
			a[index]=temp;
			max=a[0];
			index=0;
		}
	}
	
	public static void shellSort(int[] a) {
		int add=a.length;
		add=(add/2)+1;
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

	
	public static void show(int[] data) {
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i]);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data= {5,4,3,2,1};
		//insertSort(data);
		//bubbleSort(data);
		//SelectSort(data);
		shellSort(data);
		show(data);

}
	}
