package 笔试2017.去哪儿;

import java.util.*;
public class 模拟LRU_Cache {
    private static List<Cache> list = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int m = Integer.parseInt(arr[0]);
        int n = Integer.parseInt(arr[1]);
        list = new ArrayList<Cache>(m);
        for(int i=0;i<n;i++){
            add_1();
            arr = sc.nextLine().split(" ");
            String s1 = arr[0];
            String key = arr[1];
            if(s1.equals("put")){
                String value = arr[2];
                if(list.size()<m){
                    Cache cache = findCache(key);
                    if(cache==null){
                        list.add(new Cache(key,value,1));
                    }
                    else {
                        cache.value = value;
                        cache.num++;
                    }
                }
                else {
                    Cache cache = findCache(key);
                    if(cache==null){
                        change(key,value,1);
                    }
                    else {
                        cache.value = value;
                        cache.num++;
                    }
                }
            }
            if(s1.equals("get")){
                //add_1();
                Cache cache = findCache(key);
                if(cache!=null){
                    System.out.println(cache.value);
                }
                else {
                    System.out.println("null");
                }
            }
        }
    }
    public static void add_1(){
        for(int i=0;i<list.size();i++){
            Cache cache = list.get(i);
            cache.num = cache.num+1;
        }
    }
    public static Cache findCache(String key){
        for(int i=0;i<list.size();i++){
            Cache cache = list.get(i);
            if (cache.key.equals(key)){
                return cache;
            }
        }
        return null;
    }
    public static void change(String key,String value,int num){
        Collections.sort(list, new Comparator<Cache>() {
            @Override
            public int compare(Cache o1, Cache o2) {
                return o1.num>o2.num?1:-1;
            }
        });
        Cache cache = list.get(list.size()-1);
        cache.key = key;
        cache.value = value;
        cache.num = num;
    }

    static class Cache{
        String key;
        String value;
        int num;

        public Cache(String key, String value,int num ) {
            this.key = key;
            this.num = num;
            this.value = value;
        }
    }
}
