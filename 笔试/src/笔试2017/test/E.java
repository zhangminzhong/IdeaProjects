package 笔试2017.test;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by zhang_minzhong on 2017/8/31.
 */
public class E {
    public static void main(String[] args) {

    }
    public static int findDifferentWays(int size, int allowedChanges, String str) {
        char ch[] = str.toCharArray();
        int in[] = new int[size];
        Arrays.fill(in, -1);
        int k = 0;
        int i = 0;
        int count = 0;
        while (i < size) {
            if (ch[i] == '1') {
                if (i != 0)
                    in[k++] = count;
                count = 0;
                in[k++] = 0;
            } else {
                count++;
            }
            i++;
        }
        int maxlength = 0;
        int sum = 0;
        for (int j = 0; j < in.length; j++) {
            if (in[j] >= allowedChanges) {
                sum = allowedChanges;
                int m = j + 1;
                while (m < size && in[m] == 0) {
                    sum += 1;
                    m++;
                }
            } else if (in[j] != -1) {
                int m = j + 1;
                int n = allowedChanges - in[j];
                if (in[j] == 0)
                    sum += 1;
                else
                    sum = in[j];
                while (n > 0 && m < in.length) {
                    if (in[m] >= n) {
                        sum += n;
                        break;
                    } else if (in[m] == 0) {
                        sum += 1;
                        n -= in[m];
                        m++;
                    } else if (in[m] > 0 && in[m] < n) {
                        sum += 1;
                        n -= in[m];
                        m++;
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
            if (sum > maxlength) {
                maxlength = sum;
                count = 1;
            } else if (sum == maxlength) {
                count++;
            }
        }
        return count;
    }
}
