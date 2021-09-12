package 笔试2017.完美世界;

import java.util.Scanner;
import java.util.Stack;


public class 最大小栈 {
    private static Stack<Integer> stack = new Stack<Integer>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            stack.push(sc.nextInt());
        }
        stack.pop();
        int min=stack.peek();
        int max = stack.peek();
        for(int i=0;i<n-1;i++){
            int temp = stack.pop();
            if(min>temp)
                min = temp;
            if(max<temp){
                max = temp;
            }
        }
        System.out.println(max+","+min);
    }
   /* public static void push(int data){
        if(data>stack.peek())
    }
    public static int pop(){

    }
    public static int min(){

    }
    public static int max(){

    }*/
}
