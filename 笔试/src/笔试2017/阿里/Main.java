package 笔试2017.阿里;

import java.lang.reflect.Array;
import java.util.Scanner;
public class Main {
/** 请完成下面这个process函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    private static int process() {
        return 0;
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int boxLong = scanner.nextInt();
        int boxWidth = scanner.nextInt();
        int boxHigh = scanner.nextInt();
        int n = scanner.nextInt();
        Item[] items = new Item[n];
        for(int i=0;i<n;i++){
            items[i].itemLong = scanner.nextInt();
            items[i].itemWidth = scanner.nextInt();
            items[i].itemHigh = scanner.nextInt();
        }
    }
    static class Item{
        public int price;
        public int itemLong;
        public int itemWidth;
        public int itemHigh;
    }

}
