package 笔试2017.科大讯飞;

import java.util.*;

/**
 * Created by zhang_minzhong on 2017/9/16.
 */
public class 课程冲突 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> list = new ArrayList<String>();
        for(int i=0;i<n;i++){
            list.add(sc.nextLine());
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.substring(0,2).compareTo(o2)<=0)
                    return -1;
                else
                    return 1;
            }
        });
        for(int i=0;i<n;i++){
            System.out.println(list.get(i));
        }

        List<String> result = new ArrayList<String>();
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i).substring(0,2).equals(list.get(i+1).substring(0,2))){

            }
        }
    }
}
