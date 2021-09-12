package _2_编程之美;

/**
 * Created by zhang_minzhong on 2017/8/25.
 */
public class _1_1让CPU占用率曲线听你的指挥 {
    public static void main(String[] args) throws InterruptedException {
        for(;;){
            for(int i=0;i<9600000;i++)
                ;
            Thread.sleep(10);
        }
    }
}
