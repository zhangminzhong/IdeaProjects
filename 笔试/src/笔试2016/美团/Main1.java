package 笔试2016.美团;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/3/14.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        int number = scanner.nextInt();
        for(int i=0;i<=number;i++)
            list.add(i);
        while (list.size()>1){
            for(int i=0;i<list.size();i=i+1)
                list.remove(i);
        }
        System.out.println(list.get(0));
    }
}
