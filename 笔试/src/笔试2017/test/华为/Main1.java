package 笔试2017.test.华为;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String result = ConvertStr(s);
        System.out.println(result);
    }
    public static String ConvertStr(String s){
        if(s.length()>20)
            return "ERROR!";
        /*for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if((c<48)||(c>57&&c<65)||(c>90&&c<97)||(c>122))
                return "ERROR!";
        }*/
        Pattern pattern = Pattern.compile("[0-9a-zA-z]+");
        Matcher matcher = pattern.matcher(s);
        if(!matcher.matches())
            return "ERROR!";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i+=2){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
