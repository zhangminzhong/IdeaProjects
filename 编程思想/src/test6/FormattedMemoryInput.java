package test6;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-1
 * Time: 下午4:11
 * To change this template use File | Settings | File Templates.
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("F:\\新建文件夹\\BufferedInputFile.txt").getBytes()));
        try{
            while(true)
                System.out.print((char) dis.readByte());
        }catch (EOFException e){
            System.out.println("End of stream");
        }
    }
}
