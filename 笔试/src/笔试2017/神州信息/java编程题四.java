package 笔试2017.神州信息;

import java.util.*;

/**
 * Created by zhang_minzhong on 2017/9/27.
 */
public class java编程题四 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            Integer num = map.get(s.charAt(i));
            if(num==null)
                map.put(s.charAt(i),1);
            else
                map.put(s.charAt(i),num+1);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            int value = list.get(i).getValue();
            if (min>value){
                min = value;
            }
        }
        for(int i=0;i<list.size();i++){
            int value = list.get(i).getValue();
            if(value>min){
                for(int j=0;j<value;j++)
                    System.out.print(list.get(i).getKey());
            }
        }
    }
}
