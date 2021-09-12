package test4;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-6-27
 * Time: 下午2:28
 * To change this template use File | Settings | File Templates.
 */
public class Countries {
    public static final String[][] DATA = {
            {"ALGERIA","Algiers"},{"ANGOLA","Luanda"}
    };
    private static class FlyweightMap extends AbstractMap<String,String>{
        private static class Entry implements Map.Entry<String,String>{
            int index;
            Entry(int index){
                this.index = index;
            }

            @Override
            public boolean equals(Object o) {
                return DATA[index][0].equals(o);
            }

            @Override
            public int hashCode() {
                return DATA[index][0].hashCode();
            }

            @Override
            public String getKey() {
                return DATA[index][0];  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getValue() {
                return DATA[index][1];  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String setValue(String value) {
                throw new UnsupportedOperationException();  //To change body of implemented methods use File | Settings | File Templates.
            }
        }
        static class EntrySet extends AbstractSet<Map.Entry<String,String>>{
           private int size;
           EntrySet(int size){
                if(size < 0)
                    this.size = 0;
                else if(size >DATA.length)
                    this.size = DATA.length;
                else
                    this.size = size;
            }
            public int size(){
                return size;
            }
            private class Iter implements Iterator<Map.Entry<String,String>>{
                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index < size - 1;  //To change body of implemented methods use File | Settings | File Templates.
                }

                @Override
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;  //To change body of implemented methods use File | Settings | File Templates.
                }

                @Override
                public void remove() {
                   throw new UnsupportedOperationException(); //To change body of implemented methods use File | Settings | File Templates.
                }
            }

            @Override
            public Iterator<Map.Entry<String, String>> iterator() {
                return new Iter();  //To change body of implemented methods use File | Settings | File Templates.
            }
        }
        private static Set<Map.Entry<String,String>> entries = new EntrySet(DATA.length);

        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            return entries;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }
    static Map<String,String> select(final int size){
        return new FlyweightMap(){
            @Override
            public Set<Map.Entry<String, String>> entrySet() {
                return new EntrySet(size);    //To change body of overridden methods use File | Settings | File Templates.
            }
        };
    }
    static Map<String,String> map = new FlyweightMap();
    public static Map<String,String> capitals(){
        return map;
    }
    public static Map<String,String> capitals(int size){
        return select(size);
    }
    static List<String> names = new ArrayList<String>(map.keySet());
    public static List<String> names(){
        return names;
    }
    public static List<String> names(int size){
        return new ArrayList<String>(select(size).keySet());
    }
    public static void main(String[] args){
        System.out.println(capitals(2));
        System.out.println(names(10));
        System.out.println(new HashMap<String,String>(capitals(3)));
        System.out.println(new LinkedHashMap<String,String>(capitals(3)));
        System.out.println(new TreeMap<String,String>(capitals(3)));
        System.out.println(new Hashtable<String,String>(capitals(3)));
        System.out.println(new HashSet<String>(names(6)));
        System.out.println(new LinkedHashSet<String>(names(6)));
        System.out.println(new TreeSet<String>(names(6)));
        System.out.println(new ArrayList<String>(names(6)));
        System.out.println(new LinkedList<String>(names(6)));
        System.out.println(capitals().get("ANGOLA"));
    }
}
