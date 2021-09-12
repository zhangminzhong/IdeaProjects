/**
 * Created by AdministratorZhang on 2019/6/27.
 */
public class Main3 {
    public static String intToHexString(int in){
        String out=Integer.toHexString(in);
        while(out.length()<8){
            out="0"+out;
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println(intToHexString(-1));
    }
}
