import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AdministratorZhang on 2019/6/28.
 */
public class Change {


    public static void main(String[] args) {
        //FA0001470A71201906271953 FA0001470A71201906281027 FA0001500D672019062818130101df
        String input = "FA0001500D672019062818130101df";
        System.out.println("input:"+input);
        int crc = cal_crc(input);
        System.out.println("CRC="+Integer.toHexString(crc).toUpperCase());
        String orStr = orSelf(input,crc);
        System.out.println(orStr);
        byte[] send = hexStringToBytes(orStr);
        System.out.println(Arrays.toString(send));
        for(int i=0;i<send.length;i++) {
            System.out.print(intToHexString(Byte.toUnsignedInt(send[i]), 2).toUpperCase());
        }
    }

    public static byte[] hexStringToBytes(String hexString){
        byte[] bytes = new byte[hexString.length()/2];
        for(int i=0;i<hexString.length();i+=2){
            bytes[i/2] = (byte) Integer.parseInt(hexString.substring(i,i+2),16);
        }
        return bytes;
    }

    /**
     *
     * @param input 16进制字符串
     * @param crc crc的值
     * @return 返回拼接异或后的16进制字符串
     */
    public static  String orSelf(String input,int crc){
        input = input.toUpperCase();
        String str = input + intToHexString(crc,4);
        System.out.println("拼接后："+str);
        String result = "";
        for(int i=0;i<str.length();i+=2){
            if(i<6){
                result += str.substring(i,i+2);
            }
            else{
                int tmp = Integer.parseInt(str.substring(i,i+2),16)^1^0xC5;
                String s = intToHexString(tmp,2);
                result += s;
            }
        }
        System.out.println("异或后："+result);
        return result;
    }

    /**
     *
     * @param input 16进制字符串
     * @return CRC的值
     */
    public static int cal_crc(String input) {
        input = input.toUpperCase();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<input.length();i+=2){
            int tmp = Integer.valueOf(input.substring(i,i+2),16);
            list.add(tmp);
        }
        int crc;
        int da;
        int[] crc_ta = { 			/* CRC 余式表 */
                0x0000, 0x1021, 0x2042, 0x3063,
                0x4084, 0x50a5, 0x60c6, 0x70e7,
                0x8108, 0x9129, 0xa14a, 0xb16b,
                0xc18c, 0xd1ad, 0xe1ce, 0xf1ef
        };
        crc = 0;
        for (int i = 0; i < list.size(); i++) {
            String crcHexStr = intToHexString(crc,4);
            da = Integer.valueOf(crcHexStr.substring(0,1),16);     /* 暂存CRC 的高四位 */
            System.out.println("da="+Integer.toHexString(da).toUpperCase());
            crc = Integer.valueOf(crcHexStr.substring(1),16) << 4;      /* CRC 左移4 位，相当于取CRC 的低12 位）*/
            System.out.println("crc="+Integer.toHexString(crc).toUpperCase());
            int index1 = da ^ (list.get(i) >> 4);
            crc ^= crc_ta[index1];    /* CRC 的高4 位和本字节的前半字节相加后查表计算CRC,然后加上上一次CRC 的余数 */
            System.out.println("crc="+Integer.toHexString(crc).toUpperCase());
            crcHexStr = intToHexString(crc,4);
            da = Integer.valueOf(crcHexStr.substring(0,1),16);     /* 暂存CRC 的高4 位 */
            System.out.println("da="+Integer.toHexString(da).toUpperCase());
            crc = Integer.valueOf(crcHexStr.substring(1),16) << 4;      /* CRC 左移4 位，相当于CRC 的低12 位）*/
            System.out.println("crc="+Integer.toHexString(crc).toUpperCase());
            int index2 = da ^ (list.get(i) & 0x0f);
            crc ^= crc_ta[index2];  /* CRC 的高4 位和本字节的后半字节相加后查表计算CRC,然后加上本字节的CRC */
            System.out.println("第"+(i+1)+"次循环后,crc="+crc+"16进制："+Integer.toHexString(crc).toUpperCase());
            System.out.println("##############################");
        }
        return crc;
    }

    /**
     * @param in 正整数
     * @param len 要转换的16进制字符串长度
     * @return 转换的16进制字符串
     */
    public static String intToHexString(int in,int len){
       if(in<0){
           return "";
       }
        String out = Integer.toHexString(in);
        while(out.length()<len){
            out = "0" + out;
        }
        return out.toUpperCase();
    }
}
