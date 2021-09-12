package 笔试2016.test;

public class NULL {

	public static void print(){
		System.out.println("MTDP");
	}
	public static void main(String[] args) {

		try{
			((NULL)null).print();
		}catch(NullPointerException e){
			System.out.println("NullPointerException");
		}
		boolean result = false?false:true==false?true:false;
		System.out.println(""+result+"");
		
	}
	

}
