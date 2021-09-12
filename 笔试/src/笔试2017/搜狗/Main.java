package 笔试2017.搜狗;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Created by zhang_minzhong on 2017/9/8.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] nums = new double[n];
        DecimalFormat format = new DecimalFormat("#.00000000");
        for(int i=0;i<n;i++){
            nums[i] = Double.parseDouble(br.readLine());
        }
        double max = 0;
        if((nums[nums.length-1]-nums[0])<180.0) {
            System.out.println(format.format(nums[nums.length - 1] - nums[0]));
            max = nums[nums.length-1]-nums[0];
        }
        else{
            max = 360 - (nums[nums.length-1]-nums[0]);
            for(int i=nums.length-2;i>=0;i--){
                double temp = nums[i]-nums[0];
                if(temp>180.0){
                    if(max<(360-temp)){
                        max = 360-temp;
                    }
                }
                else {
                    if(max<temp){
                        max = temp;
                    }
                }
            }
        }
        String str = format.format(max);
        System.out.println(str);
        /*double[] result = new double[n*(n-1)/2];
        int k = 0;
        for(int i=0;i<doubles.length;i++){
            for(int j=i+1;j<doubles.length;j++){
                result[k] = Math.abs(doubles[i]-doubles[j]);
                k++;
            }
        }
        for(int i=0;i<result.length;i++){
            if(result[i]>=180.0){
                result[i] = 360 - result[i];
            }
        }
        Arrays.sort(result);
        String str = format.format(result[result.length-1]);
        System.out.println(str);*/
    }
}
