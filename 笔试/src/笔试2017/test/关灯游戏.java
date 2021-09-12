package 笔试2017.test;

import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/14.
 作者：大哉乾元
 链接：https://www.nowcoder.com/discuss/41715
 来源：牛客网

 #include <iostream>  using namespace std;
 int main(int argc, char* argv[]) { 
     int n; 
     while(cin >> n) { 
         int nums[n]; 
         for(int i = 0;i < n;++i) { 
             cin >> nums[i];
     } 
         if(nums[n - 1] == 1) { 
             cout << "Alice" << endl;
     }
         else { 
             cout << "Bob" << endl;
     }
   }  return 0;
 }
 */

public class 关灯游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine().replaceAll(" ","");

    }
}
