package NIO测试;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Scanner;

public class 异步连接客户端 {
	
	private static ByteBuffer sendByteBuffer;
	private static ByteBuffer receiveByteBuffer = ByteBuffer.allocate(1024);
	

	public static void main(String[] args) {
		String host = "localhost";
		int port = 1234;
		if(args.length == 2){
			host = args[0];
			port = Integer.parseInt(args[1]);
		}
		InetSocketAddress addr = new InetSocketAddress(host, port);
		SocketChannel sc = null;
		try {
			sc = SocketChannel.open();
			//sc.configureBlocking(false);
			sc.configureBlocking(true);
			System.out.println("initiating connection");
			sc.connect(addr);
			while(!sc.finishConnect()){
				doSomethingUseful();
			}
			System.out.println("connection established");
			doSometingConnect(sc);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(sc!=null)
				try {
					sc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	private static void doSometingConnect(SocketChannel sc) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();		
		while(!s.equals("quit")){			
			
			byte[] bytes = null;
			try {
				bytes = s.getBytes("utf-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			sendByteBuffer = ByteBuffer.wrap(bytes);
			try {
				//System.out.println("sending......");
				sc.write(sendByteBuffer);
				sendByteBuffer.flip();
				//System.out.println("send");
				
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}

			try {
                sc.read(receiveByteBuffer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			receiveByteBuffer.flip();
			Charset charset = Charset.forName("utf-8");
			CharsetDecoder decoder = charset.newDecoder();
			CharBuffer charBuffer = receiveByteBuffer.asCharBuffer();
			try {
				charBuffer = decoder.decode(receiveByteBuffer);
			} catch (CharacterCodingException e) {
				e.printStackTrace();
			}
            receiveByteBuffer.clear();
			System.out.println(charBuffer.toString());
			s = scanner.nextLine();
		}
	}

	private static void doSomethingUseful() {
		System.out.println ("doing something useless");		
	}

}
