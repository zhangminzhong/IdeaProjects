package 笔试2017.test;

/**
 * Created by zhang_minzhong on 2017/9/9.
 */
public class 找出数组中超过一半的数时间复杂度On空间复杂度O1 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,1,1,2,2,2};
        System.out.println(find(a));
    }
    public static int find(int[] a){
        int count = 0;
        int num = 0;
        for(int i=0;i<a.length;i++){
            if(count==0){
                num = a[i];
                count = 1;
            }
            else {
                if(num==a[i])
                    count++;
                else
                    count--;
            }
        }
        return count;
    }
}
