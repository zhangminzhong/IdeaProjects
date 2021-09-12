package NIO测试;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelTransfer {

	public static void main(String[] args) {
		if(args.length==0){
			System.err.println ("Usage: filename ...");
			return;
		}
		catFiles (Channels.newChannel(System.out), args);
	}

	private static void catFiles(WritableByteChannel target, String[] files) {
		for(int i=0;i<files.length;i++){
			try {
				FileInputStream fis = new FileInputStream(files[i]);
				FileChannel fc = fis.getChannel();
				fc.transferTo(0, fc.size(), target);
				fc.close();
				fis.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("---------------------------");
		}
		
	}

}
