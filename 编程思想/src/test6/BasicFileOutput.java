package test6;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-1
 * Time: 下午4:31
 * To change this template use File | Settings | File Templates.
 */
public class BasicFileOutput {
    static String file = "BasicFileOutput.out";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(BufferedInputFile.read("F:\\新建文件夹\\BufferedInputFile.txt")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file))); //或者PrintWriter pw = new PrintWriter(file);
        String s;
        int lineCount = 1;
        while((s = br.readLine()) != null)
            pw.println(lineCount++ +"："+s);
        pw.close();
        br.close();

    }
}
