package test6;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-1
 * Time: 下午3:51
 * To change this template use File | Settings | File Templates.
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("F:\\新建文件夹\\BufferedInputFile.txt"));
        int c;
        while((c = in.read()) != -1)
            System.out.print((char)c);
    }
}
