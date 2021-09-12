package test6;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-1
 * Time: 下午8:18
 * To change this template use File | Settings | File Templates.
 */
public class BinaryFIle {
    public static byte[] read(File bFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(bFile));
        try {
            byte[] data =new byte[bis.available()];
            bis.read(data);
            return data;
        } finally {
            bis.close();
        }
    }
    public static byte[] read(String bFile){
        return read(new File(bFile).getAbsolutePath());
    }
}
