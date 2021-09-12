package NIO测试;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelCopy {

	public static void main(String[] args) {
		ReadableByteChannel source = Channels.newChannel(System.in);
		WritableByteChannel dest = Channels.newChannel(System.out);
		channelCopy1(source, dest);
		try {
			source.close();
			dest.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void channelCopy1(ReadableByteChannel source,
			WritableByteChannel dest) {
		ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
		try {
			while (source.read(buffer) != -1) {
				buffer.flip();
				dest.write(buffer);
				buffer.compact();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void channelCopy2(ReadableByteChannel src,
			WritableByteChannel dest) {
		ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
		try {
			while (src.read(buffer) != -1) {
				buffer.flip();
				while (buffer.hasRemaining()) {
				}
				buffer.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
