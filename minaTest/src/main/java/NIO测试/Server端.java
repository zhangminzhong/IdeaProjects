package NIO测试;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server端 {

	public static void main(String[] args) {
		try {
			ServerSocketChannel ssc = ServerSocketChannel.open();
			//ssc.configureBlocking(false);
			ServerSocket serverSocket = ssc.socket();
			serverSocket.bind (new InetSocketAddress (1234));
			SocketChannel accept = ssc.accept();
			System.out.println("hello");
			ByteBuffer bb = ByteBuffer.allocate(10);
			accept.read(bb);
			System.out.println(bb.position());
			bb.flip();
			CharBuffer cb = bb.asCharBuffer();
			System.out.println("hello "+cb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
