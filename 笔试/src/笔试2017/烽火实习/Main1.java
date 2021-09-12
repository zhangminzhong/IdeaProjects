package 笔试2017.烽火实习;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/6/5.
 */
public class Main1 {
    private static List<String> resultList = new ArrayList<String>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int T = Integer.parseInt(s);
        for(int i=0;i<T;i++){
            s = scanner.nextLine();
            String[] arr = s.split(" ");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            if (c >= n * m/2)
                resultList.add("Yes");
            else
                resultList.add("No");
        }
        for(int i=0;i<resultList.size();i++){
            System.out.println(resultList.get(i));
        }
    }
}
