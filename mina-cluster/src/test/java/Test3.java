import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;

import java.net.*;
import java.nio.charset.Charset;


/**
 * Created by AdministratorZhang on 2017/11/20.
 */
public class Test3 {
    public static void main(String args[]) throws Exception {
        double d = 123.454565;
        System.out.println(Double.parseDouble(String.format("%.4f", d)));
    }
}
