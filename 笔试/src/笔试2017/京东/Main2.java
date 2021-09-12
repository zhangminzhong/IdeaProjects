package 笔试2017.京东;

/**
 * Created by zhang_minzhong on 2017/9/8.
 */
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        Map<Long, String> map1 = new HashMap<Long, String>();
        Long temp =  0L;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                temp = (long) Math.pow(i, j);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    map1.put(temp, map1.get(temp) + "," + i + "-" + j);
                } else {
                    map.put(temp, 1);
                    map1.put(temp, i + "-" + j);
                }
            }
        }
        Integer count = 0;
        Integer flag = 1000000007;
        Iterator<Long> keyIterator = map.keySet().iterator();
        while(keyIterator.hasNext()){

            long l = map.get(keyIterator.next());
            System.out.print(map.get(l) + " ");
            System.out.println(map1.get(l));

            count = (int)(count + l*l)%flag;
        }
        /*for (Long lo : map.keySet()) {
            count = (count + map.get(lo) * map.get(lo)) % flag;
        }*/
        System.out.println(count);
    }
}

