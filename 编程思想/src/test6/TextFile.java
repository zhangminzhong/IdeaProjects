package test6;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-1
 * Time: 下午7:44
 * To change this template use File | Settings | File Templates.
 */
public class TextFile extends ArrayList<String>{
    public static String read(String fileName)  {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            String s;
            try {
                while((s = br.readLine()) != null){
                    sb.append(s);
                    sb.append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }   finally {
                br.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);  //To change body of catch statement use File | Settings | File Templates.
        }
        return sb.toString();
    }
    public static void write(String fileName,String text){
        try {
            PrintWriter pw = new PrintWriter(new File(fileName).getAbsoluteFile());
            try{
                pw.print(text);
            }finally {
                pw.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    public TextFile(String fileName,String splitter){
        super(Arrays.asList(read(fileName).split(splitter)));
        if(get(0).equals(""))
            remove(0);
    }
    public TextFile(String fileName){
        this(fileName,"\n");
    }
    public void write(String fileName){
        try {
            PrintWriter pw = new PrintWriter(new File(fileName).getAbsoluteFile());
            try{
                for(String item : this)
                    pw.println(item);
            }finally {
                pw.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    public static void main(String[] args){
        String file = read("BasicFileOutput.out");
        write("dynamicproxy.txt",file);
        TextFile text = new TextFile("dynamicproxy.txt");
        text.write("test2.txt");
        TreeSet<String> words = new TreeSet<String>(new TextFile("BasicFileOutput.out","\\W+"));
        System.out.println(words.headSet("a"));
    }
}
