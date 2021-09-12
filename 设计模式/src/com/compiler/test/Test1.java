package com.compiler.test;

import com.动态代理.Moveable;
import com.动态代理.Tank;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-15
 * Time: 下午4:38
 * To change this template use File | Settings | File Templates.
 */
public class Test1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, InterruptedException {
        String src = "package com.动态代理;\n"+
                "public class TankTimeProxy implements Moveable {\n"
                +"    private Moveable t;\n"

                +"    public TankTimeProxy(Moveable t) {\n"
                +"        this.t = t;\n"
                +"    }\n\n"

                +"    @Override\n"
                +"    public void move() {\n"
                +"        long start = System.currentTimeMillis();\n"
                +"        t.move();\n"
                +"        long end = System.currentTimeMillis();\n"
                +"        System.out.println(\"time：\"+(end-start));\n"
                +"    }\n"
                +"}\n";
        System.out.println(System.getProperty("user.dir"));
        String fileName = System.getProperty("user.dir")+"/src/com/动态代理/TankTimeProxy.java";
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();

        //编译
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //System.out.println(compiler.getClass().getName());
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null,null);
        Iterable units = fileManager.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask t = compiler.getTask(null,fileManager,null,null,null,units);
        t.call();
        fileManager.close();

        //Thread.sleep(1000);

        //load到内存，实例化一个对象
        URL[] urls = new URL[]{new URL("file:/"+System.getProperty("user.dir") +"/src/")};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class c = urlClassLoader.loadClass("com.动态代理.TankTimeProxy");
        System.out.println(c);

        Constructor constructor = c.getConstructor(Moveable.class);
        Moveable m = (Moveable) constructor.newInstance(new Tank());
        m.move();
    }
}
