package 笔试2016.test;
import java.util.Scanner;


public class BlackString {

	public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        if(n==1){
            System.out.println(3);
            return;
        }
        if(n==2){
            System.out.println(9);
            return;
        }
        int [] qss=new int[n];
        int [] qds=new int[n];
        for(int i=2;i<n;i++){
            if(i==2){
                qss[i]=3;
                qds[i]=6;
            }else {
                qss[i]  = qss[i-1]+qds[i-1];
                qds[i]=qss[i-1]*2+qds[i-1];
            }
        }
        System.out.println(qss[n-1]*3+qds[n-1]*2);
    }

}
