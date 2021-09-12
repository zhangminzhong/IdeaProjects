package test6;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-1
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));
        dos.writeDouble(3.1415926);
        dos.writeUTF("That was pi");
        dos.writeDouble(1.41413);
        dos.writeUTF("Square root of 2");
        dos.close();
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
        System.out.println(dis.readDouble());
        System.out.println(dis.readUTF());
        System.out.println(dis.readDouble());
        System.out.println(dis.readUTF());

    }
}
