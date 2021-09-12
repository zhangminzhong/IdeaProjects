package 笔试2016.美团;

/**
 * Created by zhang_minzhong on 2017/3/14.
 */
public class Printer {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] a = new Printer().arrayPrint(arr,4);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public int[] arrayPrint(int[][] arr, int n) {
        int[] result = new int[n*n];
        int[] right = new int[n*(n+1)/2];
        int[] left = new int[n*(n-1)/2];
        int rightIndex = 0;
        int y1 = n-1;
        for(int i=0;i<n;i++){
            int x1 = 0;
            for(int j=0;j<=i;j++){
                right[rightIndex] = arr[x1][y1+j];
                x1++;
                rightIndex++;
            }
            y1--;
        }
        int leftIndex = 0;
        for(int i=1;i<n;i++){
            int y2 = 0;
            for(int j=0;j<n-i;j++){
                left[leftIndex] = arr[i+j][y2];
                y2++;
                leftIndex++;
            }
        }
        for(int i=0;i<right.length;i++)
            result[i] = right[i];
        for(int i=0;i<left.length;i++)
            result[right.length+i] = left[i];
        return result;
    }
}
