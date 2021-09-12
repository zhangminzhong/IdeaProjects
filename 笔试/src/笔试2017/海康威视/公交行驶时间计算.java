package 笔试2017.海康威视;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/14.
 */
public class 公交行驶时间计算 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(",");
        int n = Integer.parseInt(strings[0]);
        String begin = strings[1];
        String end = strings[2];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long from = simpleDateFormat.parse(begin).getTime();
        long to = simpleDateFormat.parse(end).getTime();
        int minutes = (int)((to-from)/(1000*60));
        int size = 15*n;
        int circle = minutes/size+1;
        int sub = minutes%size;
        int mod_1 = sub%15;
        int zhandian;
        if(mod_1<=5){
            zhandian = sub/15+1;
            System.out.println(circle+":"+zhandian+"-"+zhandian);
        }

        else{
            zhandian = sub/15+1;
            System.out.print(circle+":"+zhandian+"-");
            if(zhandian+1>n){
                System.out.println(1);
            }
            else{
                System.out.println(zhandian+1);
            }
        }
    }
}
