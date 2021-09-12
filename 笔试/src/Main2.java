import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main2 extends Main{
    public Main2() {
        System.out.println("Main2()");
    }

    public static void main(String[] args) {
//        String s1 = "计算机";
//        String s2 = s1.intern();
//        String s3 = "计算机";
//        System.out.println(s2);//计算机
//        System.out.println(s1 == s2);//true
//        System.out.println(s3 == s2);//true，因为两个都是常量池中的 String 对象

        String s1 = new String("计算")+new String("机");
        s1.intern();
        String s4 = "计算机";
        System.out.println(s1==s4);

//        Integer i1 = 40;
//        Integer i2 = new Integer(40);
//        System.out.println(i1==i2);//输出 false

        String s2 = "ab";
        String s3 = "c";
        String s5 = "ab"+"c";//s2+s3;
        String s6 = "abc";
        System.out.println(s5==s6);


        new Thread(() -> { //Lambda表达

            while(true){
                try {
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:sss").format(new Date()));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }



    public static void m1(StringBuilder sb){
        try {
            throw new Exception();
        } catch (Exception e) {
            return;
        }finally {
            sb.append("b");
        }
    }


    public static String output="";
    public static void foo(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
            output += "1";
        }catch (Exception e){
            output+="2";
            return;
        }finally {
            output+="3";
        }
        output+="4";
    }


    public enum CodeEnum {
        A("1","1"),
        B("1","2"),
        C("1","3"),
        ;
        private String s1;
        private String s2;

        CodeEnum(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
        public static void test(){
            System.out.println(A.getDeclaringClass());
            System.out.println(A.name());
            System.out.println(B.ordinal());
            System.out.println(A);
        }

        public static void main(String[] args) {
            test();
        }
    }

}
