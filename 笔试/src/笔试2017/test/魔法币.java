package 笔试2017.test;

import java.util.Scanner;
import java.util.Stack;


public class 魔法币 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        Stack<Integer> stack = new Stack<Integer>();
        while(n>0){
            if(n%2==0){
                n = (n-2)/2;
                stack.push(2);
            }
            else{
                stack.push(1);
                n = (n-1)/2;
            }
        }
        while(!stack.empty()){
            System.out.print(stack.pop());
        }
    }
}
