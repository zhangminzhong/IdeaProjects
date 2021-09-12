package 笔试2016.京东;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-9-5
 * Time: 下午8:07
 * To change this template use File | Settings | File Templates.
 */
public class CountMinMax {

    public static void main(String[] args){
        int n=0,m=0;
        int[] money = null;
        int b=0;
        int a=0;
        Set<String> goods = new HashSet<String>();
        File file = null;
        BufferedReader br = null;
        try {
            file = new File("test.txt");
            br = new BufferedReader(new FileReader(file));
            String line = "";
            String[] arrs = null;
           // String =
            while(true){
                if((line = br.readLine())!=null){
                    arrs = line.split(" ");
                    n = Integer.parseInt(arrs[0]);
                    m = Integer.parseInt(arrs[1]);
                    line = br.readLine();
                    arrs = line.split(" ");
                    money = new int[arrs.length];
                    //System.out.println(arrs);
                    for(int i=0;i<arrs.length;i++){
                        money[i] = Integer.parseInt(arrs[i]);
                    }
                    Arrays.sort(money);
                    for(int j=0;j<m;j++){
                        goods.add(br.readLine());
                        //System.out.println(goods);
                    }

                    for(int i=0;i<goods.size();i++){
                        a+=money[i];
                    }
                    for(int j=money.length-1;j>=(money.length-goods.size());j--)  {
                        b += money[j];
                    }
                    System.out.println("a="+a+",b="+b);
                    a = 0;
                    b = 0;
                    goods.removeAll(goods);
                }
                else
                    break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
