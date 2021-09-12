package 笔试2017.test;

import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/10.
 */
public class 括号匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int max = 0;
        int temp = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                temp ++;
            }
            else {
                if(temp>max){
                    max = temp;
                }
                temp = 0;
            }
        }
        System.out.println(max);
    }
}
