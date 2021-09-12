package 笔试2017.test;

import java.util.Scanner;

/**
 * Created by AdministratorZhang on 2018/3/27.
 */
public class 重复矩形 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] sX1 = in.nextLine().split(" ");
        String[] sY1 = in.nextLine().split(" ");
        String[] sX2 = in.nextLine().split(" ");
        String[] sY2 = in.nextLine().split(" ");
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        Point[] point1 = new Point[n];
        Point[] point2 = new Point[n];
        for(int i=0;i<n;i++){
            point1[i].x = Integer.parseInt(sX1[i]);
            point1[i].y = Integer.parseInt(sY1[i]);
            point2[i].x = Integer.parseInt(sX2[i]);
            point2[i].y = Integer.parseInt(sY2[i]);
        }
        int max = 1;
        for(int i=0;i<n;i++){
            int temp = 1;
            Point tempP1 = point1[i];
            Point tempP2 = point2[i];
            for(int j=i+1;j<n;j++){
                if(isCover(tempP1,tempP2,point1[j],point2[j])){
                    temp++;
                    if(tempP1.x<point1[j].x){
                        tempP1.x = point1[j].x;
                        if(tempP1.y<point1[j].y){
                            tempP1.y = point1[j].y;
                        }
                        if(tempP2.y<point2[j].y){
                            //temp2
                        }
                    }else {
                        if(tempP1.y<point1[j].y){
                            tempP1.y = point1[j].y;
                        }
                    }

                    //if(tempP2)
                }
            }
        }

    }
    public static boolean isCover(Point point1,Point point2,Point point3,Point point4){
        boolean b = false;
        if(point1.x<point3.x&&point3.x<point2.x){
            if(point1.y<point4.y&&point4.y<point2.y){
                return true;
            }
            else
                return false;
        }
        if(point1.x>point3.x){
            if(point1.x<point4.x&&point1.y<point4.y&&point4.y<point2.y){
                return true;
            }
            else{
                return
                        false;
            }
        }
        return false;

    }
    class Point{
        int x;
        int y;
    }
}
