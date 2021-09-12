package 笔试2017.烽火实习;

import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/6/5.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        boolean flag = false;
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(i==0) {
                if (isBig(s.charAt(i)))
                    count++;
            }
            else {
                    if ((isBig(s.charAt(i)) && !isBig(s.charAt(i - 1))) || (!isBig(s.charAt(i)) && isBig(s.charAt(i - 1)))) {
                        count++;
                    }
                }
        }
        System.out.println(count+s.length());
    }
    public static boolean isBig(char a){
        byte b = (byte)a;
        if(b>=65&&b<=90){
            return true;
        }
        else return false;
    }
}
