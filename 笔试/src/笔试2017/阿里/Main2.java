package 笔试2017.阿里;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/8/25.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 5) {
                break;
            }
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
        }
        scanner.close();

        // wirte your code here
        List<String> result = calculateUnilateral(lineList);

        for (String str : result) {
            System.out.println(str);
        }
    }
    public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
        List<String> result = new ArrayList<String>();

        for (int i = 0;i < lineList.size() - 1;i++) {
            UnilateralLine lineA = lineList.get(i);
            UnilateralLine lineB = lineList.get(i+1);

            if (lineA.getECen().equals(lineB.getSCen()) && lineA.getSCen().equals(lineB.getECen()) && lineA.getTType().equals(lineB.getTType())) {
                result.add("rule1:" + lineA.getId() + "+" + lineB.getId());
            }

            if (i < lineList.size() - 2) {
                UnilateralLine lineC = lineList.get(i+2);

                if (lineA.getECen().equals(lineB.getSCen()) && lineB.getECen().equals(lineC.getSCen()) && lineC.getECen().equals(lineA.getSCen())) {
                    if (lineA.getTType().equals(lineB.getTType()) && lineB.getTType().equals(lineC.getTType())) {
                        result.add("rule2:" + lineA.getId() + "+" + lineB.getId() + "+" + lineC.getId());
                    }
                }

                if (lineA.getSCen().equals(lineB.getECen()) && lineA.getEPro().equals(lineB.getSPro())) {
                    if (lineA.getTType().equals(lineB.getTType()) && lineB.getTType().equals(lineC.getTType())) {
                        result.add("rule3:" + lineA.getId() + "+" + lineB.getId());
                    }
                }
            }

        }

        return result;
    }



    public static class UnilateralLine {
        private String id;
        private String sCen;//出发分拨
        private String sPro;//出发省
        private String eCen;//到达分拨
        private String ePro;//到达省
        //9.6m/17.5m
        private String tType;//车型
        public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro,String tType) {
            this.id = id;this.sCen = sCen;this.sPro = sPro;this.eCen = eCen;this.ePro = ePro;this.tType = tType;}
        public String getId() {return id;}
        public void setId(String id) {this.id = id;}
        public String getSCen() {return sCen;}
        public void setSCen(String ePro) {this.ePro = ePro;}
        public String getSPro() {return sPro;}
        public void setSPro(String sPro) {this.sPro = sPro;}
        public String getECen() {return eCen;}
        public void setECen(String eCen) {this.eCen = eCen;}
        public String getEPro() {return ePro;}
        public void setEPro(String ePro) {this.ePro = ePro;}
        public String getTType() {return tType;}
        public void setTType(String tType) {this.tType = tType;}
    }
}
