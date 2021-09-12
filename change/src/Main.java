import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //FA0001470A71201906271953 FA0001470A71201906281027
        String input = "FA0001470A71201906281027";
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<input.length();i+=2){
            int tmp = Integer.valueOf(input.substring(i,i+2),16);
            System.out.println(tmp);
            list.add(tmp);
        }
        int result = cal_crc(list);
        System.out.println(result+":"+Integer.toHexString(result).toUpperCase());

    }

    public static int cal_crc(List<Integer> list) {
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
            String crcHexStr = intToHexString(crc);
            da = Integer.valueOf(crcHexStr.substring(0,1),16);     /* 暂存CRC 的高四位 */
            crc = Integer.valueOf(crcHexStr.substring(1),16) << 4;      /* CRC 左移4 位，相当于取CRC 的低12 位）*/
            int index1 = da ^ (list.get(i) >> 4);
            crc ^= crc_ta[index1];    /* CRC 的高4 位和本字节的前半字节相加后查表计算CRC,然后加上上一次CRC 的余数 */
            crcHexStr = intToHexString(crc);
            da = Integer.valueOf(crcHexStr.substring(0,1),16);     /* 暂存CRC 的高4 位 */
            crc = Integer.valueOf(crcHexStr.substring(1),16) << 4;      /* CRC 左移4 位，相当于CRC 的低12 位）*/
            int index2 = da ^ (list.get(i) & 0x0f);
            crc ^= crc_ta[index2];  /* CRC 的高4 位和本字节的后半字节相加后查表计算CRC,然后加上本字节的CRC */
        }
        return crc;
    }
    //将整型转换成16进制字符串
    public static String intToHexString(int in){
        String out=Integer.toHexString(in);
        while(out.length()<4){
            out="0"+out;
        }
        return out;
    }
}
