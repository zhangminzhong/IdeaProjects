package 笔试2017.携程;

import java.util.*;

/**
 * Created by zhang_minzhong on 2017/9/21.
 */
public class 中位数1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set= new HashSet<Integer>();
        //List<Integer> list=  new ArrayList<Integer>();
        //int[] A = new int[n];
        for(int i=0;i<n;i++){
            //A[i] = sc.nextInt();
            set.add(sc.nextInt());
            //list.add(sc.nextInt());
        }
        int m = sc.nextInt();
        //int[] B = new int[m];
        for(int i=0;i<m;i++){
            //B[i] = sc.nextInt();
            set.add(sc.nextInt());
            //if(!has)
        }
        List<Integer> list=  new ArrayList<Integer>(set);
        Collections.sort(list);
        if(list.size()%2!=0){
            System.out.println(list.get(list.size()/2));
        }
        else {
            int a = list.get(list.size()/2);
            int b = list.get(list.size()/2-1);
            System.out.println((double)(a+b)/2);
        }
    }
    public boolean has(List<Integer> list,int n){
        for(int i=0;i<list.size();i++){
            if(list.get(i)==n)
                return true;
        }
        return false;
    }
}
