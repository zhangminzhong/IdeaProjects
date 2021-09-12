package 笔试2016.滴滴;

public class test {
	public static void main(String[] args){
		System.out.println(fun(254));
	}
	static int fun(int x){
		int countx = 0;
		while(x>0){
			countx++;
			x=x&(x-1);
		}
		return countx;
	}
}