package 笔试2017.今日头条;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/8/22.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Point> list = new ArrayList<Point>();
        for(int i=0;i<N;i++){
            Point p = new Point();
            p.x = scanner.nextInt();
            p.y = scanner.nextInt();
            list.add(p);
        }
        Collections.sort(list);
        List<Point> result = new ArrayList<Point>();
        Point p = list.get(list.size()-1);
        result.add(p);
        for(int i=list.size()-2;i>=0;i--){
            if(list.get(i).y>p.y){
                p = list.get(i);
                result.add(list.get(i));
            }
        }
        Collections.sort(result);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i).x+" "+result.get(i).y);
        }

    }
    static class Point implements Comparable<Point>{
        int x;
        int y;

        @Override
        public int compareTo(Point point) {
            if(this.x>point.x)
                return 1;
            else
                return -1;
        }
    }
}
