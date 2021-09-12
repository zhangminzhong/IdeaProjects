package NIO测试;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

public class 缓冲区Test {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte)'c').put((byte)'o').put((byte)'m').put((byte)'3').put((byte)'d').put((byte)'y');
        //System.out.println((char)buffer.get(0));
        //buffer.put(0, (byte)'M').put((byte)'w');
        buffer.flip();
        while(buffer.hasRemaining()){
            System.out.print((char)buffer.get());
        }
        buffer.position(0);
        System.out.println();
        //buffer.limit(buffer.position()).position(0);
		/*byte[] byteArray = new byte[buffer.remaining()];
		System.out.println(byteArray.length);
		for(int i=0;i<byteArray.length;i++){
			byteArray[i] = buffer.get();
		}*/
        ByteBuffer buffer2 = ByteBuffer.allocate(10);
        buffer2.put((byte)'c').put((byte)'o').put((byte)'m').put((byte)'3').put((byte)'d').put((byte)'y');
        buffer2.flip();
        buffer2.position(2);
        while(buffer2.hasRemaining()){
            System.out.print((char)buffer2.get());
        }
        System.out.println();
        buffer2.position(2);
        if(buffer.compareTo(buffer2)<0){
            System.out.println("buffer<buffer2");
        }

        CharBuffer cBuffer = CharBuffer.allocate(8);
        cBuffer.position (3).limit (6).mark( ).position (5);
        CharBuffer dupeBuffer = cBuffer.duplicate();
        buffer.clear();

        System.out.println(buffer.isDirect());
    }

}
