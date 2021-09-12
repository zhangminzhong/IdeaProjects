package NIO测试;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class 一般通道服务端 {

    public static final String GREETING = "Hello I must be going.";
    private static ByteBuffer sendBuffer = null;
    private static ByteBuffer recBuffer = null;
    private static ServerSocketChannel ssc = null;
    private static SocketChannel sc = null;

    public static void main(String[] args) throws UnsupportedEncodingException, CharacterCodingException {
        int port = 1234;
        if(args.length>0){
            port = Integer.parseInt(args[0]);
        }
        sendBuffer = ByteBuffer.wrap(GREETING.getBytes("utf-8"));
        recBuffer = ByteBuffer.allocate(1024);
        try {
            ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(port));
            ssc.configureBlocking(false);
            while(true){
                //System.out.println("Waiting for connections");
                sc = ssc.accept();//非阻塞
                if(sc==null){

                }
                else{
                    newReceiveThread(sc);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                if(sc!=null){
                    sc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void newReceiveThread(final SocketChannel socketChannel) throws IOException {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while(true){
                    String rString= receive(socketChannel);
                    if (rString.equals("quit"))
                        break;
                    System.out.println("id="+Thread.currentThread().getId()+",服务端收到："+rString);
                    try {
                        socketChannel.write(sendBuffer);
                        sendBuffer.position(0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            private String receive(SocketChannel socketChannel) {
                String s = "";
                try {
                    System.out.println(sc==null);
                    System.out.println("Incoming connection from: "
                            + socketChannel.socket().getRemoteSocketAddress());
                    System.out.println("reading...");
                    socketChannel.read(recBuffer);//阻塞
                    recBuffer.flip();
                    System.out.println("read");
                    CharBuffer charBuffer = Charset.forName("utf-8").newDecoder().decode(recBuffer);
                    s = charBuffer.toString();
                    recBuffer.clear();
                } catch (CharacterCodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return s;
            }
        }).start();
    }
}
