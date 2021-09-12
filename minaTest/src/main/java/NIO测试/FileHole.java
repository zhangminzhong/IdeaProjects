package NIO测试;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileHole {

	public static void main(String[] args) {
		try {
			File temp = new File("temp.txt");
			RandomAccessFile file = new RandomAccessFile(temp, "rw");
			FileChannel channel = file.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
			putData(0,byteBuffer,channel);
			putData(5000000,byteBuffer,channel);
			putData(50000,byteBuffer,channel);
			System.out.println("Worte temp file '"+temp.getPath()
					+"', size="+channel.size());
			channel.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void putData(int position, ByteBuffer buffer,
			FileChannel channel) {
		String string = "*<-- location"+position;
		buffer.clear();
		try {
			buffer.put(string.getBytes("US-ASCII"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		buffer.flip();
		try {
			channel.position(position);
			channel.write(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
