package 笔试2017.test;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by zhang_minzhong on 2017/9/10.
 */
public class 前m项和_每一项是前一项平方根 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            double n = sc.nextInt();
            int m = sc.nextInt();
            double sum = 0.0;
            double temp = 0;
            for(int i=0;i<m;i++){
                if(i==0){
                    sum += n;
                    continue;
                }
                temp = Math.sqrt(n);
                sum += temp;
                n = temp;
            }
            System.out.println(new DecimalFormat("#.00").format(sum));
        }
        sc.close();
    }
}
