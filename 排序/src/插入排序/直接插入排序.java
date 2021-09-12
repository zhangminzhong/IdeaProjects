package 插入排序;

public class 直接插入排序 {

    public static void main(String[] args) {
        int arr[]={8,6,12,5,14,7,21,2,9,3};
        insertSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static int[] insertSort(int[] a){
        int j;
        for(int i=1;i<a.length;i++){
            int temp = a[i];
            for(j=i;j>0&&a[j-1]>temp;j--)
                a[j] = a[j-1];
            a[j] = temp;
        }
        return a;
    }

}
