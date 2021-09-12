package 笔试2017.京东;

/**
 * Created by zhang_minzhong on 2017/9/8.
 */
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        char chars[] = str.toCharArray();
        int count[] = new int[str.length()];
        if (str.length() == 0)
            System.out.print(0);
        else {
            int k = 0;
            for (int i = str.length() - 1; i >= 0; i--){
                for (k = i; k >= 0; k--){
                    if (chars[k] == ')'){
                        count[i]++;
                    }
                    else
                        break;
                }
            }
            int sum = 1;
            for (int i = 0; i < count.length; i++){
                if (count[i] != 0){
                    sum = sum * count[i];
                }
            }
            System.out.print(sum);
        }
    }
}
