package 笔试2017.京东;

import java.util.*;

public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        if (str.equals("")) {
            System.out.println(0);
        }
        int m = 1;
        int len = str.length();

        int k = 0;
        for (int i = 0; i < len; i++) {
            if (str.substring(i, i + 1).equals("(")) {
                k++;
            }
            if (str.substring(i, i + 1).equals(")")) {
                m *= k;
                k--;
            }
        }
        System.out.println(m);
    }
}

