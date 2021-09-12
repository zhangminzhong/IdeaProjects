package 笔试2017.搜狐;

import java.util.*;

/**
 * Created by zhang_minzhong on 2017/9/17.
 */
public class Unix路径简化 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        String[] strings = s.split("");
        String result = simplePath(s);
        System.out.println(result);
    }

    public static String simplePath(String path) {
        String[] ss = path.split("/");
        LinkedList<String> ll = new LinkedList<String>();
        for(int i=0; i<ss.length; i++) {
            if(!ll.isEmpty() && ss[i].equals("..")) {
                ll.removeLast();
            } else if(ss[i].length() != 0 && !ss[i].equals(".") && !ss[i].equals("..")){
                ll.add(ss[i]);
            }
        }

        if(ll.isEmpty()) {
            return "/";
        }

        String s = "";
        while( !ll.isEmpty() ) {
            s += "/";
            s += ll.remove();
        }
        return s;
    }

    /*public static String simplePath(String path) {
        Stack<String> s = new Stack<String>();
        String[] p = path.split("/");
        for (String t : p) {
            if (!s.isEmpty() && t.equals("..")) {
                s.pop();
            } else if (!t.equals(".") && !t.equals("") && !t.equals("..")) {
                s.push(t);
            }
        }
        List<String> list = new ArrayList(s);
        String result = "";
        for(int i=0;i<list.size();i++){
            if(list.size()==1){
                return "/"+list.get(0);
            }
            if(i<list.size()-1){
                result += list.get(i)+"/";
            }
            else {
                result += list.get(list.size()-1);
            }
        }
        return result;
    }*/

}
