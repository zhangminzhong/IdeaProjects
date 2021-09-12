package NIO测试;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Marketing {
	
	private static final String DEMOGRAPHIC = "blahblah.txt";
	private static String [] col1 = {
		"Aggregate", "Enable", "Leverage",
		"Facilitate", "Synergize", "Repurpose",
		"Strategize", "Reinvent", "Harness"
		};
	private static String [] col2 = {
		"cross-platform", "best-of-breed", "frictionless",
		"ubiquitous", "extensible", "compelling",
		"mission-critical", "collaborative", "integrated"
		};
	private static String [] col3 = {
		"methodologies", "infomediaries", "platforms",
		"schemas", "mindshare", "paradigms",
		"functionalities", "web services", "infrastructures"
		};
	//private static String newline = System.getProperty ("line.separator");
	private static Random rand = new Random();

	public static void main(String[] args) {
		int reps = 10;
		if(args.length > 0){
			reps = Integer.parseInt(args[0]);
		}
		try {
			FileOutputStream fos = new FileOutputStream(DEMOGRAPHIC);
			GatheringByteChannel gatherChannel = fos.getChannel();
			ByteBuffer[] bs = utterBS(reps);
			while(gatherChannel.write(bs)>0){
				
			}
			System.out.println ("Mindshare paradigms synergized to "
					+ DEMOGRAPHIC);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static ByteBuffer[] utterBS(int howMany) {
		List<ByteBuffer> list = new LinkedList<ByteBuffer>();
		for(int i=0;i<howMany;i++){
			list.add(pickRandom(col1," "));
			list.add(pickRandom(col2, " "));
			list.add(pickRandom(col3, "\n"));
		}
		ByteBuffer[] bufs = new ByteBuffer[list.size()];
		list.toArray(bufs);
		return bufs;
	}

	private static ByteBuffer pickRandom(String[] strings, String suffix) {
		String string = strings[rand.nextInt(strings.length)];
		int total = string.length()+suffix.length();
		ByteBuffer buf = ByteBuffer.allocate(total);
		try {
			buf.put(string.getBytes("US-ASCII"));
			buf.put(suffix.getBytes("US-ASCII"));
			buf.flip();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buf;
		
	}

}
