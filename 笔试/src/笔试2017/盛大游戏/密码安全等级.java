package 笔试2017.盛大游戏;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhang_minzhong on 2017/9/10.
 */
public class 密码安全等级 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        int total = 0;
        total += lenScore(password);
        total += zimuScore(password);
        total += numScore(password);
        total += fuhaoScore(password);
        total += giveScore(password);
        if(total>=90){
            System.out.println("VERY_SECURE");
        }
        else if(total>=80){
            System.out.println("SECURE");
        }
        else if(total>=70){
            System.out.println("VERY_STRONG");
        }
        else if(total>=60){
            System.out.println("STRONG");
        }
        else if(total>=50){
            System.out.println("AVERAGE");
        }
        else if(total>=25){
            System.out.println("WEAK");
        }
        else {
            System.out.println("VERY_WEAK");
        }

    }



    public static int lenScore(String s){
        int score = 0;
        if(s.length()<=4) {
            score = 5;
        }
        else if (s.length()<=7) {
            score = 10;
        }
        else{
            score=25;
        }
        return score;
    }
    public static int zimuScore(String s){
        int score = 0;
        Pattern pattern1 = Pattern.compile("[A-Z]+$");
        Pattern pattern2 = Pattern.compile("[a-z]+$");
        Pattern pattern3 = Pattern.compile("[a-zA-Z]+$");
        Matcher matcher1 = pattern1.matcher(s);
        Matcher matcher2 = pattern1.matcher(s);
        Matcher matcher3 = pattern1.matcher(s);
        boolean b1 = matcher1.matches();
        boolean b2 = matcher1.matches();
        boolean b3 = matcher1.matches();
        if(!b1&&!b2){
            score = 0;
        }
        if((b1&&!b2)||(!b1&&b2)){
            score = 10;
        }
        if(b3){
            score = 20;
        }
        return score;
    }
    public static int numScore(String s){
        int score = 0;
        int num = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>=48&&s.charAt(i)<57)
                num++;
        }
        if(num==0){
            score = 0;
        }else if(num==1){
            score=10;
        }else {
            score = 20;
        }
        return score;
    }
    public static int fuhaoScore(String s){
        int score = 0;
        int num = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c<=47||(c>=58&&c<=64)||(c>=91||c<=96)||(c>=123)){
                num++;
            }
        }
        if(num==0){
            score = 0;
        }else if(num==1){
            score=10;
        }else {
            score = 25;
        }
        return score;
    }
    private static int giveScore(String s) {
        int score = 0;
        Pattern pattern1 = Pattern.compile("[a-z]|[A-Z]|[0-9]");
        return 0;
    }

}
