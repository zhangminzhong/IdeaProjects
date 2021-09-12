import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-12
 * Time: 下午4:43
 * To change this template use File | Settings | File Templates.
 */
public class ChatServer {
    boolean started = false;
    ServerSocket serverSocket = null;
    List<Client> clients = new ArrayList<Client>();

    public static void main(String[] args){
        //Socket socket = null;
        //DataInputStream dis = null;
        new ChatServer().start();
    }

    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            started = true;
            while(true){
                //boolean bConnected = false;
                Socket socket = serverSocket.accept();
                Client client = new Client(socket);
                new Thread(client).start();
                clients.add(client);
                System.out.println("a client connected!");

            }
        } catch (IOException e) {
            //e.printStackTrace();
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
    private class Client implements Runnable{
        private Socket socket = null;
        private DataInputStream dis = null;
        private DataOutputStream dos = null;
        private boolean bConnected = false;

        public Client(Socket socket){
            this.socket = socket;
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                bConnected = true;
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        public void send(String s) {
                try {
                    dos.writeUTF(s);
                } catch (IOException e){
                    clients.remove(this);
                    System.out.println("对方退出了，我从List里面去掉了。");
                }
        }

        @Override
        public void run() {
            try{
                while(bConnected){
                    String  s = dis.readUTF();
System.out.println(s);
                    for(int i = 0;i < clients.size();i++){
                        Client c = clients.get(i);
                        c.send(s);
                    }
                }
            }
              catch (EOFException e) {
                //e.printStackTrace();
                System.out.println("Client closed!");
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } finally {
                try {
                    if (dis != null)
                        dis.close();
                    if(dos != null)
                        dos.close();
                    if (socket != null)
                        socket.close();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }

        }
    }
}
