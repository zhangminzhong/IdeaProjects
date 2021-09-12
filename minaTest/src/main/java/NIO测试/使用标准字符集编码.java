package NIO测试;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Set;

public class 使用标准字符集编码 {

    public static void main(String[] args) {
        String input = "你";
        String [] charsetNames = {
                "US-ASCII", "ISO-8859-1", "UTF-8", "UTF-16BE",
                "UTF-16LE", "UTF-16"
        };
        for(int i=0;i<charsetNames.length;i++){
            doEncode(Charset.forName(charsetNames[i]),input);
        }
		/*Charset charset = Charset.forName("gb2312");
		System.out.println(charset.name());
		System.out.println("");
		Set<String> aliases = charset.aliases();
		for(String s:aliases){
			System.out.println(s);
		}*/
        Charset charset1 = Charset.forName("utf-8");
        Charset charset2 = Charset.forName("gbk");
        System.out.println(charset2.contains(charset1));
    }

    private static void doEncode(Charset cs, String input) {
        ByteBuffer bb = cs.encode(input);
        System.out.println("CHarset: "+cs.name());
        System.out.println(" Input: "+input);
        System.out.println("Encoded: ");
        for(int i=0;bb.hasRemaining();i++){
            int b = bb.get();
            int ival = ((int)b)&0xff;
            char c = (char)ival;
            if(i<10)
                System.out.print(" ");
            System.out.print (" " + i + ": ");
            if(ival<16)
                System.out.print(Integer.toHexString(ival));
            if(Character.isWhitespace(c)||Character.isISOControl(c))
                System.out.println("");
            else
                System.out.println("("+c+")");
        }
        System.out.println ("");
    }

}
