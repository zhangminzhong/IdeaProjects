package 笔试2016.test;
import java.util.HashSet;
import java.util.Set;


public class NowCoder {
	public static void main(String[] args){
		Set<MyClass> set = new HashSet<MyClass>();
		set.add(new MyClass(5));
		set.add(new MyClass(2));
		set.add(new MyClass(6));
		System.out.print(set.size());
		//int a[][3]={{0,1},{0}};
		//int a[][3]={0,1,2,3,4,5};
		//int a[3][2]={{0,1},{2,3},{4,5}};
		//int a[2][3]={0};
	}
	

}

class MyClass{
	Integer i;
	public MyClass(Integer y){
		i=y;
	}
	public boolean equals(MyClass c){
		return false;
	}
	public boolean equals(Object o){
		return false;
	}
	public int hashCode(){
		//int a[][3]={{0,1},{0}};
				//int a[][3]={0,1,2,3,4,5};
				//int a[3][2]={{0,1},{2,3},{4,5}};
				//int a[2][3]={0};
		return 32;
	}
}