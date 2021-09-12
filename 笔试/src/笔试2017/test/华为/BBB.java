package 笔试2017.test.华为;

/**
 * Created by zhang_minzhong on 2017/8/30.
 */
import java.util.Scanner;

public class BBB {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.next();
            char[] c=s.toCharArray();
            long l=0;
            for(int i=0;i<c.length;++i){
                l+=(c[i]-'a'+1)*Math.pow(26, c.length-(i+1));
            }
            System.out.println(l);
        }
    }
}

