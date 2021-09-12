package 笔试2016.test;
import java.util.Scanner;


public class Search {
	private static  String s="";
	private static Scanner scanner;
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		binarySearch(t);
		System.out.print(s);
				
	}
	public static int binarySearch(int des){   
	      
		int k = 0;
        int low = -90;   
        int high = 90;   
        while(low <= high) { 
        	k++;
        	if(k>6)
        		break;
            int middle = (low + high)/2; 
            if(des == middle) {   
                return middle;   
            }else if(des <middle) {
            	s+="0";
                high = middle;   
            }else { 
            	s+="1";
                low = middle;   
            }  
        }  
        return -1;  
   }  
	
}