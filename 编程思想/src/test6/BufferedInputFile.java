package test6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-1
 * Time: 下午2:49
 * To change this template use File | Settings | File Templates.
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"gbk"));
        String s;
        StringBuilder sb = new StringBuilder();
        LinkedList<String> linkedList = new LinkedList<String>();
        while((s = br.readLine()) != null){
            sb.append(s + "\n");
            linkedList.add(s);
        }
        br.close();
        /*int i = 0;
        while(linkedList.size() > 0){
            System.out.println(i+"："+linkedList.removeLast()+"\n");
            i++;
        }*/
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        System.out.println(read("F:\\新建文件夹\\BufferedInputFile.txt"));
    }
}
