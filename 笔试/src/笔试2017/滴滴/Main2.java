package 笔试2017.滴滴;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/8/26.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int[] nums = new int[strings.length];
        for(int i=0;i<strings.length;i++){
            nums[i] = Integer.parseInt(strings[i]);
        }
        int k = Integer.parseInt(scanner.nextLine());
        Arrays.sort(nums);
        System.out.println(nums[nums.length-k]);
    }
}
