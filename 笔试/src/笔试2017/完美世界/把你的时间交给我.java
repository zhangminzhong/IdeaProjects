package 笔试2017.完美世界;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/26.
 */
public class 把你的时间交给我 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String begin = sc.nextLine();
        String end = sc.nextLine();
        sc.close();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date beginTime = format.parse(begin);
        Date endTime = format.parse(end);

    }

}
