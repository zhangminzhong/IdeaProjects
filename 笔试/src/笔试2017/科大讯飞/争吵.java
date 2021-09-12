package 笔试2017.科大讯飞;

import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/16.
 */
public class 争吵 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=  sc.nextLine();
        StringBuilder sb = new StringBuilder(s);
        do {
            //System.out.println(sb.toString());
        }while (remove(sb));
        System.out.println(sb.toString().length());
    }
    public static boolean remove(StringBuilder sb){
        if(sb.length()==0||sb.length()==1)
            return false;
        if(sb.length()==2){
            if(sb.charAt(0)=='R'&&sb.charAt(1)=='L'){
                sb.deleteCharAt(0);
                sb.deleteCharAt(1);
                return true;
            }
        }
        for(int i=0;i<sb.length()-1;i++){
            if(sb.charAt(i)=='R'&&sb.charAt(i+1)=='L'){
                if(i==0){
                    if(sb.charAt(i)=='R'&&sb.charAt(i+1)=='L'){
                        if(sb.charAt(i+2)=='L'){
                            sb.deleteCharAt(i+1);
                        }
                        else {
                            sb.deleteCharAt(i);
                        }
                    }
                    return true;
                }
                else {
                    if(sb.charAt(i-1)=='R'){
                        sb.deleteCharAt(i);
                    }else if((i<sb.length()-2)&&sb.charAt(i+2)=='L'){
                        sb.deleteCharAt(i+1);
                    }else {
                        sb.deleteCharAt(i);
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
