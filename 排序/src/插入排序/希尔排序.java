package 插入排序;

public class 希尔排序 {

    public static void main(String[] args) {
        int arr[]={8,6,12,5,14,7,21,2,9,3};
        shellSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static int[] shellSort(int[] a){
        int j;
        for(int increment=a.length/2;increment>0;increment/=2){
            for(int i=increment;i<a.length;i++){
                int temp = a[i];
                for(j=i;j>=increment&&a[j-increment]>temp;j-=increment)
                    a[j] = a[j-increment];
                a[j] = temp;
            }
        }
        return a;
    }

}
