package 笔试2017.test;

import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/2.
 */
public class 计算字符串中字符次数ABBC结果为A1B2C1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            System.out.println(compressString(s));
        }
    }
    public static String compressString(String str){
        if(str==null||str.equals("")||str.length()==1)
            return str;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                count++;
                if(i==str.length()-1){
                    sb.append(str.charAt(i)).append(count);
                }
            }
            else {
                sb.append(str.charAt(i-1)).append(count);
                count = 1;
                if(i==str.length()-1){
                    sb.append(str.charAt(i)).append(count);
                }
            }
        }
        String result = sb.toString();
        if(result.length()<str.length()) {
            return result;
        }
        else{
            return str;
        }
    }
}
