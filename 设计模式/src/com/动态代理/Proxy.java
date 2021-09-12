package com.动态代理;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-15
 * Time: 下午3:57
 * To change this template use File | Settings | File Templates.
 */
public class Proxy {
    public static Object newProxyInstance(Class infce,InvocationHandler handler)throws Exception{
        String methodString = "";
        Method[] methods = infce.getMethods();
        /*for(Method m:methods){
            methodString += "@Override\n"
                           +"public void " + m.getName() + "(){\n"
                           +"        long start = System.currentTimeMillis();\n"
                           +"        t."+m.getName()+"();\n"
                           +"        long end = System.currentTimeMillis();\n"
                           +"        System.out.println(\"time：\"+(end-start));\n"
                           +"}\n";
        }*/
        for(Method m:methods){
            methodString += "@Override\n"
                    +"public void " + m.getName() + "(){\n"
                    +"  try{ \n"
                    +"    Method md = "+infce.getName()+".class.getMethod(\""+m.getName()+"\");\n"
                    +"    handler.invoke(this,md);\n"
                    +"  }catch (Exception e) {\n" +
                    "            e.printStackTrace();  \n" +
                    "        }\n"
                    +"}\n";
        }
        System.out.println(methodString);

        String src = "package com.动态代理;\n"
                +"import java.lang.reflect.Method;\n"
                +"public class TankTimeProxy implements "+infce.getName()+" {\n"
                //+"    private "+infce.getName()+" t;\n"
                +"    com.动态代理.InvocationHandler handler;\n"

                +"    public TankTimeProxy(InvocationHandler handler) {\n"
                +"        super();\n"
                +"        this.handler = handler;\n"
                +"    }\n\n"
                + methodString
                +"}\n";
        System.out.println(System.getProperty("user.dir"));
        String fileName = "D:/src/com/动态代理/TankTimeProxy.java";
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

        //load到内存，实例化一个对象
        URL[] urls = new URL[]{new URL("file:/"+"D:/src/")};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class c = urlClassLoader.loadClass("com.动态代理.TankTimeProxy");
        System.out.println(c);

        Constructor constructor = c.getConstructor(InvocationHandler.class);
        Object m = constructor.newInstance(handler);
        //m.move();
        return m;
    }
}
