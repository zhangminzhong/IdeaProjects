package test6;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-1
 * Time: 下午1:29
 * To change this template use File | Settings | File Templates.
 */
public class MakeDirectories {
    private static void fileData(File f){
        System.out.println("Absolute path: "+f.getAbsolutePath()+
        "\n Can read: "+f.canRead()+
        "\n getName: "+f.getName()+
        "\n getParent: "+f.getParent()+
        "\n getPath: "+f.getPath()+
        "\n length: "+f.length()+
        "\n lastModified: "+f.lastModified());
        if(f.isFile())
            System.out.println("It's a file");
        else if(f.isDirectory())
            System.out.println("It's a directory");
    }
    public static void main(String[] args) throws IOException {
        File f = new File("A.dat");
        f.createNewFile();
    }
}
