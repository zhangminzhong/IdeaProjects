package 笔试2017.test;

import java.util.*;


public class 选举 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");
        String[] s2 = sc.nextLine().split(" ");
        int[] v = new int[s1.length];
        int[] w = new int[s2.length];
        int n = v.length;
        for(int i=0;i<n;i++){
            v[i] = Integer.parseInt(s1[i]);
            w[i] = Integer.parseInt(s2[i]);
        }
        Map<Integer,String> map = new HashMap<Integer, String>();
        for(int i=0;i<n;i++){
            if(map.get(v[i])==null){
                map.put(v[i],w[i]+" "+0);
            }
            else {
                String s = map.get(v[i]);
                String[] strings = s.split(" ");
                int total = Integer.parseInt(strings[0])+w[i];
                int count = Integer.parseInt(strings[1])+1;
                map.put(v[i],total+" "+count);
            }
        }
        List<Map.Entry<Integer,String>> list = new ArrayList<Map.Entry<Integer, String>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println(list.get(list.size()-1).getKey());
    }
}
