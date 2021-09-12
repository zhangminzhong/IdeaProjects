package NIO测试;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class 使用select的通道服务端 {

    private static int PORT_NUMBER = 1234;
    private ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

    public static void main(String[] args) throws Exception {
        new 使用select的通道服务端().go(args);
    }

    public void go(String[] args) throws Exception {
        int port = PORT_NUMBER;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        System.out.println("Listening on port " + port);
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverChannel.socket();
        Selector selector = Selector.open();
        serverSocket.bind(new InetSocketAddress(port));
        serverChannel.configureBlocking(false);
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            System.out.println("检查就绪通道...");
            int n = selector.select(1000);
            if (n == 0)
                continue;

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel channel = server.accept();
                    System.out.println(channel.socket()
                            .getRemoteSocketAddress() + "已连接");
                    registerChannel(selector, channel, SelectionKey.OP_READ);
                    // sayHello(channel);
                }
                if (key.isReadable()) {
                    //System.out.println("key.isReadable()");
                    readDataFromSocket(key);
                }
                iterator.remove();
            }
        }
    }

    public void readDataFromSocket(SelectionKey key) throws Exception {
        //System.out.println("readDataFromSocket()");
        //Thread.sleep(10);
        //System.out.println(Thread.currentThread().getId());
        SocketChannel socketChannel = (SocketChannel) key.channel();
        int count;
        buffer.clear();
        while ((count = socketChannel.read(buffer)) > 0) {
            buffer.flip();
			
			/*Charset charset = Charset.forName("utf-8");
			CharsetDecoder decoder = charset.newDecoder();
			CharBuffer charBuffer = decoder.decode(buffer);
			System.out.println(charBuffer.toString());*/
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
            buffer.clear();
        }
        System.out.println(count);
        if (count < 0) {
            String remoteString = socketChannel.socket().getRemoteSocketAddress().toString();
            System.out.println(remoteString + "正在断开连接......");
            socketChannel.close();
            System.out.println(remoteString + "已断开连接");
        }
    }

	/*
	 * private void sayHello(SocketChannel channel) throws Exception{
	 * System.out.println("sayHello()"); buffer.clear();
	 * buffer.put("Hi there!\t\n".getBytes()); buffer.flip();
	 * channel.write(buffer); }
	 */

    public void registerChannel(Selector selector, SocketChannel channel,
                                int ops) throws Exception {
        if (channel == null)
            return;
        //System.out.println("registerChannel()");
        channel.configureBlocking(false);
        channel.register(selector, ops);
    }

}
