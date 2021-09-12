package 笔试2017.网易;

import java.util.*;

/**
 * Created by zhang_minzhong on 2017/9/25.
 */
public class 数位重排 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int x = sc.nextInt();
            if(find(x)){
                System.out.println("Possible");
            }
            else{
                System.out.println("Impossible");
            }
        }
    }

    private static boolean find(int x) {
        String s = String.valueOf(x);
        int i = 2;
        int tmp = x*i;
        String tmpStr = String.valueOf(tmp);
        while(tmpStr.length()==s.length()){
            if(same(tmpStr,s)){
                return true;
            }
            i++;
            tmp = x*i;
            tmpStr = String.valueOf(tmp);
            //System.out.println(tmpStr);
        }
        return false;
    }

    private static boolean same(String tmpStr, String s) {
        List<Character> list1 = new ArrayList<Character>();
        List<Character> list2 = new ArrayList<Character>();
        for(int i=0;i<tmpStr.length();i++){
            list1.add(tmpStr.charAt(i));
        }
        for(int i=0;i<s.length();i++){
            list2.add(s.charAt(i));
        }
        Collections.sort(list1);
        Collections.sort(list2);
        for(int i=0;i<s.length();i++){
            if(list1.get(i)!=list2.get(i)){
                return false;
            }
        }
        return true;
    }
}
