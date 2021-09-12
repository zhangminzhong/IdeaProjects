import java.util.ArrayList;
import java.util.List;

/**
 * Created by AdministratorZhang on 2019/6/27.
 */
public class Main2 {

    public static void main(String[] args) {
        //FA0001470A71201906271953
        String input = "FA0001470A71201906271953";
        List<Short> list = new ArrayList<Short>();
        for(int i=0;i<input.length();i=i+2){
            int tmp = Integer.valueOf(input.substring(i,i+2),16);
            System.out.println(tmp);
            list.add((short)tmp);
        }

        int result = cal_crc(list);
        System.out.println(result+":"+Integer.toHexString(result));
    }

    public static int cal_crc(List<Short> list) {
        int crc;
        short da;
        int[] crc_ta = { 			/* CRC 余式表 */
                0x0000, 0x1021, 0x2042, 0x3063,
                0x4084, 0x50a5, 0x60c6, 0x70e7,
                0x8108, 0x9129, 0xa14a, 0xb16b,
                0xc18c, 0xd1ad, 0xe1ce, 0xf1ef
        };
        crc = 0;
        for (int i = 0; i < list.size(); i++) {
            da = (byte) (crc >> 12);     /* 暂存CRC 的高四位 */
            crc <<= 4;                      /* CRC 右移4 位，相当于取CRC 的低12 位）*/
            int index1 = Byte.toUnsignedInt((byte) (da ^ (list.get(i) >> 4)));
            crc ^= crc_ta[index1];    /* CRC 的高4 位和本字节的前半字节相加后查表计算CRC,然后加上上一次CRC 的余数 */
            da = (byte) (crc >> 12);     /* 暂存CRC 的高4 位 */
            crc <<= 4;                      /* CRC 右移4 位，相当于CRC 的低12 位）*/
            int index2 = Byte.toUnsignedInt((byte) (da ^ (list.get(i) & 0x0f)));
            crc ^= crc_ta[index2];  /* CRC 的高4 位和本字节的后半字节相加后查表计算CRC,然后加上本字节的CRC */
        }
        return crc;
    }
}
