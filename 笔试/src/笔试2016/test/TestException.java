package 笔试2016.test;

public class TestException {

	public static void main(String[] args) {
		int a[] = {0,1,2,3,4};
		int sum = 0;
		try{
			for(int i=1;i<=6;i++)
				sum = sum + a[i];
			System.out.println("sum="+sum);
			
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("����Խ��");
		}finally{
			System.out.println("�������");
		}
	}

}
