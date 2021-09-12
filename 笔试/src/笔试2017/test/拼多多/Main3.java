package 笔试2017.test.拼多多;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/8/1.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in

        );
        int n = sc.nextInt();
        int[] m = new int[n];
        for (int i = 0; i < n; i++) {
            m[i] = sc.nextInt();
        }
        Arrays.sort(m);
        int sum = 0;
        if (m[1] >= 0) {
            sum = m[n - 1] * m[n - 2] * m[n - 3];
        } else {
            if (m[0] * m[1] >= m[n - 2] * m[n - 3]) {
                sum = m[0] * m[1] * m[n - 1];
            }
        }
        System.out.println(sum);
    }

}
