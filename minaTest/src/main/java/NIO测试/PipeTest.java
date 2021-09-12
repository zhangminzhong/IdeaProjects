package NIO测试;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Random;

public class PipeTest {

	public static void main(String[] args) {
		WritableByteChannel out = Channels.newChannel(System.out);
		ReadableByteChannel workChannel = startWork(10);
		ByteBuffer buffer = ByteBuffer.allocate(100);
		try {
			while(workChannel.read(buffer)>=0){
				buffer.flip();
				out.write(buffer);
				buffer.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static ReadableByteChannel startWork(int reps) {
		Pipe pipe = null;
		try {
			pipe = Pipe.open();
			Worker worker = new Worker(pipe.sink(),reps);
			worker.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pipe.source();
	}
	
	private static class Worker extends Thread{
		
		WritableByteChannel channel;
		private int reps;
		private String [] products = {
				"No good deed goes unpunished",
				"To be, or what?",
				"No matter where you go, there you are",
				"Just say \"Yo\"",
				"My karma ran over my dogma"};
		private Random rand = new Random( );

		public Worker(WritableByteChannel channel, int reps) {
			this.channel = channel;
			this.reps = reps;
		}

		@Override
		public void run() {
			ByteBuffer buffer = ByteBuffer.allocate(100);
			try{
				for(int i=0;i<this.reps;i++){
					doSomeWork(buffer);
					while(channel.write(buffer)>0){
						
					}
				}
				this.channel.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
		private void doSomeWork (ByteBuffer buffer)
		{
		int product = rand.nextInt (products.length);
		buffer.clear( );
		buffer.put (products [product].getBytes( ));
		buffer.put ("\r\n".getBytes( ));
		buffer.flip( );
		}
		
		
		
	}

}
