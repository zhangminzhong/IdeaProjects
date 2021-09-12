package 选择排序;

public class 简单选择排序 {

    public static void main(String[] args) {
        int arr[]={8,6,12,5,14,7,21,2,9,3};
        selectSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }
    public static int[] selectSort(int[] a){
        int min,temp;
        for(int i=0;i<a.length-1;i++){
            min = i;
            for(int j=i+1;j<a.length;j++)
                if(a[min]>a[j])
                    min = j;
            if(min!=i){
                temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
        return a;
    }

}
