package client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * Created by AdministratorZhang on 2017/11/1.
 */
public class SocketClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        for(int i=1;i<=100000;i++){
            Socket socket = new Socket("127.0.0.1",9123);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
            bw.write("hello world"+i);
            bw.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
            String s = br.readLine();
            System.out.println(s);
        }
        Thread.sleep(1000000);
    }
}
