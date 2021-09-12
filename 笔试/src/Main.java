import java.util.concurrent.ThreadPoolExecutor;

public class Main extends Thread{
//    public static int test(){
//        int a = 1;
//        try{
//            return (a+1);
//        }catch (Exception e){
//            return (a+2);
//        }finally {
//            System.out.println(a);
//            return a;
//        }
//    }
    private static int A=123;
    protected Main(){
        System.out.println("Main()");
    }

    public static void main(String[] args) {
        System.out.println(A);
    }
    public void start(){

        System.out.println("start()");
    }
}
