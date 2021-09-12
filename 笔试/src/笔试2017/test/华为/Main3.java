package 笔试2017.test.华为;

import java.util.LinkedList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        char[] chars = new char[62];
        for(int i=48;i<58;i++)
            chars[i-48] = (char)i;
        for(int i=97;i<123;i++)
            chars[i-87] = (char)i;
        for(int i=65;i<91;i++)
            chars[i-29] = (char)i;

        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int a = Integer.parseInt(strings[0]);
        int b = Integer.parseInt(strings[1]);
        String numStr = strings[2];
        int num = 0;
        for(int i=0;i<numStr.length();i++) {
            int index = findIndex(chars,numStr.charAt(i));
            num= num+(int)(index*Math.pow(a,numStr.length()-1-i));
        }
        LinkedList<Character> list = new LinkedList<Character>();
        while(num>0){
            list.addFirst((char)(num%b));
            num /= b;
        }
        StringBuilder sb = new StringBuilder();
        while(!list.isEmpty())
            sb.append(chars[list.poll()]);
        System.out.println(sb.toString());
    }

    private static int findIndex(char[] chars, char c) {
        for(int i=0;i<chars.length;i++){
            if(chars[i]==c)
                return i;
        }
        return -1;
    }
}
