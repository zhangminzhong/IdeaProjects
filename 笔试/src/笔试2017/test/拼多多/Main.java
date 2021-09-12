package 笔试2017.test.拼多多;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nStr = scanner.nextLine();
        int n = Integer.parseInt(nStr);
        String hStr = scanner.nextLine();
        String[] hStrArr = hStr.split(" ");
        //int[] h = new int[hStrArr.length];
        List<Integer> hList = new LinkedList<Integer>();
        for(int i=0;i<hStrArr.length;i++){
            hList.add(Integer.parseInt(hStrArr[i]));
        }
        String mStr = scanner.nextLine();
        int m = Integer.parseInt(mStr);
        String wStr = scanner.nextLine();
        String[] wStrArr = wStr.split(" ");
        //int[] w = new int[wStrArr.length];
        List<Integer> wList = new LinkedList<Integer>();
        for(int i=0;i<wStrArr.length;i++){
            wList.add(Integer.parseInt(wStrArr[i]));
        }
        Collections.sort(hList);
        Collections.sort(wList);
        int count = 0;
        for(int i=0;i<hList.size();i++){
            for(int j=0;j<wList.size();j++){
                if(hList.get(i)<=wList.get(j)){
                    count++;
                    wList.remove(j);
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
