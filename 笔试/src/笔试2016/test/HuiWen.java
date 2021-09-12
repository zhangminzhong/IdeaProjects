package 笔试2016.test;
import java.util.Scanner;


public class HuiWen {

	public static void main(String[] args) {
		//int[] A = new int[51];
		int i,m,start,end,count;
		Scanner scanner = new Scanner(System.in);
		m = scanner.nextInt();
		int[] A = new int[m];
		//����m����������
		for(i=0;i<m;i++){
			A[i] = scanner.nextInt();
		}
		start = count =0;
		end = m-1;
		while(start<end){
			//������ڶԳƵ���������ȣ�������һ��ԳƵ���
			if(A[start]==A[end]){
				start++;
				end--;
			}
			else if(A[start]<A[end]){
				A[start+1]+=A[start];
				count++;
				start++;
			}
			else{
				A[end-1]+=A[end];
				count++;
				end--;
			}
		}
		System.out.println(count);
		
	}

}
