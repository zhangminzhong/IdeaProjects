package _5_算法;

/**
 * Created by zhang_minzhong on 2017/9/13.
 */
public class 数组子串的和的最大值 {
    public static void main(String[] args) {

    }
    public static int maxSubSum(int arr[]){
        int len = arr.length;
        if(len == 0){
            return 0;
        }
        int sum = arr[0];
        int max = arr[0];
        for(int i=1;i<len;i++){
            if(sum > 0){
                sum = sum + arr[i];
            }else{
                sum = arr[i];
            }
            if(max < sum){
                max = sum;
            }
        }
        return max;
    }
}
