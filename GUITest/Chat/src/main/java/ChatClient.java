import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-12
 * Time: 下午4:10
 * To change this template use File | Settings | File Templates.
 */
public class ChatClient extends Frame{
    private TextField textField = new TextField();
    private TextArea textArea = new TextArea();
    private Socket socket = null;
    private DataOutputStream dos = null;
    private DataInputStream dis = null;
    private boolean bCnnected = false;
    private Thread receiveThread = new Thread(new ReceiveThread());

    public static void main(String[] args){
        new ChatClient().launchFrame();
    }

    public void launchFrame(){
        this.setLocation(400, 300);
        this.setSize(400, 500);
        this.add(textField,BorderLayout.SOUTH);
        this.add(textArea,BorderLayout.NORTH);
        this.pack();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                disconnect();
                System.exit(0);
            }
        });
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = textField.getText();
                String s2 = textArea.getText();
                //textArea.setText(s2 + (s2.equals("") ? s1 : "\n" + s1));
                textField.setText("");
                try {
                    dos.writeUTF(s1);
                    dos.flush();
                    //dos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });

        this.setVisible(true);
        connect();
        receiveThread.start();
    }

    public void connect(){
        try {
            socket = new Socket("127.0.0.1",8888);
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            System.out.println("connected!");
            bCnnected = true;
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void disconnect(){
        try{
            if (dis != null)
                dis.close();
            if (dos != null)
                dos.close();
            if (socket != null)
                socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        /*try {
            bCnnected = false;
            receiveThread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            try{
                if (dis != null)
                    dis.close();
                if (dos != null)
                    dos.close();
                if (socket != null)
                    socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }*/
    }

    private class ReceiveThread implements Runnable{
        @Override
        public void run() {
            String s1 = null;
            try {
                while (bCnnected){
                    s1 = dis.readUTF();
                    String s2 = textArea.getText();
                    textArea.setText(s2 + (s2.equals("") ? s1 : "\n" + s1));
                }
            }catch (SocketException e){
                System.out.println("退出了，bye!");
            }
             catch (IOException e) {
                e.printStackTrace();
            } /*finally {
                disconnect();
            }*/
        }
    }
}
