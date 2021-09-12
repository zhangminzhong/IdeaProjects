package 笔试2017.科大讯飞;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String str=scanner.next();
            System.out.println(last(str));
        }
    }

    public static int last(String str){
        char[] chars=str.toCharArray();
        if(str.length()==1){
            return 1;
        }
        int L=0;
        int R=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='R') {
                L=L+i;
                break;
            }
        }
        for (int i = chars.length-1; i >=0; i--) {
            if (chars[i]=='R') {
                R++;
            }
            else {
                break;
            }
        }
        if (L+R!=str.length()) {
            return L+R+1;
        }
        return str.length();
    }

}
