package 笔试2016.土豆;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println(maxCommanFactor(2,12));
	}
	
	public static int maxCommanFactor(int a,int b) throws Exception{
		int count = 0;
		int product = a*b;
		int x = a;
		if(a>b){
			a = b;
			b = x;
		}
		for(int i=a;i<=b;i++)
			for(int j=a;j<=b;j++)
				if(((i*j)==product)&&(i<=j)&&Max_Min(i,j,a,b)){
					count++;
					break;
				}
		return count;
	}

	//�ж�c,d�����Լ������С�������ǲ���a,b
	private static boolean Max_Min(int c, int d, int a, int b) {
		int y = 0;
		int e = c;
		int f = d;
		while(c!=0){
			y = d%c;
			d = c;
			c = y;
		}
		int t = e*f/d;
		if((t==b)&&(d==a))
			return true;
		else
			return false;
	}

}
