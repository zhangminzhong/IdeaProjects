package com.jdksocketclient;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: zhang_minzhong
 * Date: 16-10-20
 * Time: 下午2:01
 * To change this template use File | Settings | File Templates.
 */
public class Client {

    private static Socket socket = null;

    public static void main(String[] args) {
        try {
            InetAddress ipAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(ipAddress,1234);
            System.out.println("连接成功");
            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,Charset.forName("utf-8")));

           /* byte[] bytes = {0xA,0xB};
            os.write(bytes);

            byte[] inBytes = new byte[1024];
            is.read(inBytes);
            System.out.println(inBytes);*/

            Scanner scanner = new Scanner(System.in);
            String outString="";
            String backString = "";
            while(!outString.equalsIgnoreCase("quit")){
                outString = scanner.nextLine();
                bw.write(outString);
                bw.flush();
                backString = br.readLine();
                //byte[] bytes = new byte[1024];
                //is.read(bytes);
                System.out.println(backString);
            }

            bw.close();
            br.close();

            if(socket!=null){
                socket.close();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
