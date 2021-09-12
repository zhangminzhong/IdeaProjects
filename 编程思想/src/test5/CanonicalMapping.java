package test5;

import java.util.WeakHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-6-30
 * Time: 下午4:33
 * To change this template use File | Settings | File Templates.
 */
public class CanonicalMapping {
    public static void main(String[] args){
        System.out.println(args[0]+args[1]);
        int size = 100;
        if(args.length > 0)
            size = new Integer(args[0]);
        Key[] keys = new Key[size];
        WeakHashMap<Key,Value> map = new WeakHashMap<Key, Value>();
        for(int i = 0; i < size; i++){
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if(i % 3 == 0)
                  keys[i] = k;
            map.put(k,v);
        }
        System.gc();
    }
}
