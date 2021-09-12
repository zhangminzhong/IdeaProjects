import java.util.ArrayList;
import java.util.List;

/**
 * Created by AdministratorZhang on 2019/6/27.
 */
public class Main1 {

    public static void main(String[] args) {
        //FA0001470A71201906271953
        String input = "FA0001470A71201906271953";
        List<Byte> list = new ArrayList<Byte>();
        for(int i=0;i<input.length();i+=2){
            int tmp = Integer.valueOf(input.substring(i,i+2),16);
            System.out.println(tmp);
            list.add((byte)tmp);
        }

        int result = cal_crc(list);
        System.out.println(result+":"+Integer.toHexString(result));
    }

    public static int cal_crc(List<Byte> list) {
        short crc;
        byte da;
        short[] crc_ta = { 			/* CRC 余式表 */
                0x0000, 0x1021, 0x2042, 0x3063, 0x4084, 0x50a5, 0x60c6, 0x70e7,
                (short) 0x8108, (short) 0x9129, (short) 0xa14a, (short) 0xb16b, (short) 0xc18c, (short) 0xd1ad, (short) 0xe1ce, (short) 0xf1ef
        };
        crc = 0;
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "次循环");
            da = (byte) (crc >> 12);     /* 暂存CRC 的高四位 */
            System.out.println("da:" + da + ":" + Integer.toHexString(da));
            System.out.println("crc:" + crc + ":" + Integer.toHexString(crc));
            crc <<= 4;                      /* CRC 左移4 位，相当于取CRC 的低12 位）*/
            System.out.println("crc:" + crc + ":" + Integer.toHexString(crc));
            System.out.println("list.get(i)="+list.get(i));
            int index1 = Byte.toUnsignedInt((byte) (Byte.toUnsignedInt(da) ^ (Byte.toUnsignedInt(list.get(i)) >> 4)));
            System.out.println("index1:" + index1 + ":" + Integer.toHexString(index1));
            crc ^= crc_ta[index1];    /* CRC 的高4 位和本字节的前半字节相加后查表计算CRC,然后加上上一次CRC 的余数 */
            System.out.println("crc:" + crc + ":" + Integer.toHexString(crc));
            System.out.println("############################");
            da = (byte) (crc >> 12);     /* 暂存CRC 的高4 位 */
            System.out.println("da:" + da + ":" + Integer.toHexString(da));
            System.out.println("crc:" + crc + ":" + Integer.toHexString(crc));
            crc <<= 4;                      /* CRC 左移4 位，相当于CRC 的低12 位）*/
            System.out.println("crc:" + crc + ":" + Integer.toHexString(crc));
            System.out.println(Byte.toUnsignedInt(da));
            System.out.println(Byte.toUnsignedInt(list.get(i)));
            int index2 = Byte.toUnsignedInt((byte) (Byte.toUnsignedInt(da) ^ (Byte.toUnsignedInt(list.get(i)) & 0x0f)));
            System.out.println("index2:" + index2 + ":" + Integer.toHexString(index2));
            crc ^= crc_ta[index2];  /* CRC 的高4 位和本字节的后半字节相加后查表计算CRC,然后加上本字节的CRC */
            System.out.println("crc:" + crc + ":" + Integer.toHexString(crc));
            System.out.println();
        }
        return crc;
    }
}
