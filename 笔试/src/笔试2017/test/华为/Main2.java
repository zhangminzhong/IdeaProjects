package 笔试2017.test.华为;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashSet<Character> chars = new HashSet<Character>();
        for(int i=0;i<s.length();i++)
            chars.add(s.charAt(i));
        List<Character> list = new ArrayList<Character>();
        for(Character c:chars){
            list.add(c);
        }
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1 >= o2 ? -1 : 1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());

    }
}
