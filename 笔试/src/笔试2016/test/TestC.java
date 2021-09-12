package 笔试2016.test;


public class TestC {

	static {
		x=1;
	}
	static int x,y;
	public static void main(String[] args){
		x--;
		method();
		System.out.println(x+y+ ++x);
		
		
		
	}
	static void method(){
		y=x++ + ++x;
	}
}
