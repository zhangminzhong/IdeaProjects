package 笔试2017.携程;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class 中位数 {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>();

        Scanner sc = new Scanner(System.in);
        int count1 = sc.nextInt();
        for(int i=0;i<count1;i++){
            set.add(sc.nextInt());
        }
        int count2 = sc.nextInt();
        for(int j = 0;j<count2;j++){
            set.add(sc.nextInt());
        }
        sc.close();
        int size = set.size();
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(set);
        if(size%2 != 0){
            System.out.println(list.get(size/2));
        }else{
            System.out.println((list.get(size/2)+list.get(size/2-1))/2.0);
        }
    }
}
