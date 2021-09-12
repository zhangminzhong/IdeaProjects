package test6;

import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-1
 * Time: 下午8:40
 * To change this template use File | Settings | File Templates.
 */
public class ChangeSystemOut {
    public static void main(String[] args){
        PrintWriter pw = new PrintWriter(System.out,true);
        pw.println("hello world");
    }
}
