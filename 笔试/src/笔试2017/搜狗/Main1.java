package 笔试2017.搜狗;

import java.io.BufferedReader;
import java.io .IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

public class Main1 {
    static double dist(double n1, double n2){
        double diff = Math.abs(n1 - n2);
        return Double.compare(diff,180.0) > 0 ? 360.0 - diff : diff;
    }
    public static void main(String args[]) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        double[] points = new double[n];
        for (int i = 0; i < n; i++) {
            points[i] = Double.valueOf(br.readLine());
        }
        Arrays.sort(points);
        double max = 0.0;
        int n1 = 0;
        int n2 = 1;
        while(n2 < n){
            double diff = points[n2] - points[n1];
            if(Double.compare(diff , 180.0) > 0){
                double dist = dist(points[n1], points[n2]);
                if(dist > max)
                    max = dist;
                n1++;
            }else{
                if(diff > max)
                    max = diff;
                n2++;
            }
        }
        DecimalFormat format = new DecimalFormat("#.00000000");
        String str = format.format(max);
        System.out.println(str);
    }
}
