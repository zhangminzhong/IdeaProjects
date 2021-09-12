package 笔试2017.科大讯飞;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in );
        int n = sc.nextInt();
        sc.nextLine();
        boolean isConflict = false;
        Map<String, List<String>> lines = new LinkedHashMap<String, List<String>>();
        for (int i = 0; i < n; i++) {
            String[] name = sc.nextLine().split(" ");
            String time = name[0];
            String courseNum = name[1];
            if (lines.containsKey(time)) {
                List<String> num = lines.get(time);
                num.add(courseNum);
                lines.put(time, num);
            } else {
                List<String> num = new ArrayList<String>();
                num.add(courseNum);
                lines.put(time, num);
            }
        }
        for (Map.Entry<String, List<String>> en : lines.entrySet()) {
            if (en.getValue().size() > 1) {
                isConflict = true;
                StringBuilder res = new StringBuilder(en.getKey());
                for (String s : en.getValue()) {
                    res.append(" " + s);
                }
                System.out.println(res.toString());
            }

        }
        if (!isConflict) {
            System.out.println("YES");
        }
    }
}