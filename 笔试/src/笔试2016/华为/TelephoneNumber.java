package 笔试2016.华为;
import java.util.Scanner;

public class TelephoneNumber {
    public static void main(String[] args) {
        System.out.print("输入字符串（输入exit退出）：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] strArray = str.toCharArray();
        while(!str.equals("exit")){
            if(!isNumeric(strArray)){
                System.out.println("Error");
            }
            /*else if((strArray[0]!='1')||(strArray[0]!='6')||(strArray[0]!='8')) {
                System.out.println("Error");
            }*/
            else if((str.length()==8)&&(strArray[0]=='6'||strArray[0]=='8')){
                System.out.println("PSTN:"+str.substring(0,4)+"_"+str.substring(4));
            }
            else if ((str.length()==11)&&(strArray[0]=='1')){
                System.out.println("MOBILE:"+strArray[0]+str.substring(1,3)+"_"+str.substring(3,7)+"_"+str.substring(7));
            }
            else
                System.out.println("Error");
            System.out.print("输入字符串（输入exit退出）：");
            scanner = new Scanner(System.in);
            str = scanner.nextLine();
            strArray = str.toCharArray();
        }

    }
    public static boolean isNumeric(char[] strArray){
        int i=0;
        for(i=0;i<strArray.length;i++){
            int j = 0;
            for(j=0;j<10;j++){
                if(strArray[i]==j+48){
                     break;
                }
                else{
                    continue;
                }
            }
            if(j>=10){
                return false;
            }

        }
        return true;
    }

}
