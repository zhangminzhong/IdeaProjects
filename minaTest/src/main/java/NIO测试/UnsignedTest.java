package NIO测试;

import java.nio.ByteBuffer;

public class UnsignedTest {

	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(10);
		Unsigned.putUnsignedByte(byteBuffer, 200);
		byteBuffer.flip();
		System.out.println(byteBuffer.get());
	}

}
