package 笔试2017.携程;

import java.util.*;

/**
 * Created by zhang_minzhong on 2017/9/21.
 */
public class 删除字符串中的重复字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        LinkedHashSet<Character> set = new LinkedHashSet<Character>();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        List<Character> list = new LinkedList<Character>(set);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());
    }
}
