package 笔试2016.完美世界;

import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
	
	LinkedList<Integer> list = new LinkedList<Integer>();
	
	public void addLast(Integer e){
		list.addLast(e);
	}
	public void addIndexItem(int i,Integer e){
		list.add(i, e);
	}
	public void delete(int i){
		list.remove(i);
	}
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String[] lineArray = scanner.nextLine().trim().split(" ");
		int[] intArray = new int[lineArray.length];
		
		for(int i=0;i<intArray.length;i++){
			intArray[i] = Integer.parseInt(lineArray[i]);
		}
		MyLinkedList linkedList = new MyLinkedList();
		for(int j=0;j<intArray.length;j++){
			if(intArray[j]==3){
				linkedList.addLast(intArray[j+1]);
				linkedList.addLast(intArray[j+2]);
				linkedList.addLast(intArray[j+3]);
			}
		}
		for(int j=0;j<intArray.length;j++){
			if(intArray[j]==1){
				linkedList.addIndexItem(1, intArray[j+1]);
			}
		}
		for(int j=0;j<intArray.length;j++){
			if(intArray[j]==2){
				linkedList.delete(2);;
			}
		}
		linkedList.print();
	}
}

class MyLinkedList{
	LinkedList<Integer> list = new LinkedList<Integer>();
	
	public void addLast(Integer e){
		list.addLast(e);
	}
	public void addIndexItem(int i,Integer e){
		list.add(i, e);
	}
	public void delete(int i){
		list.remove(i);
	}
	public void print(){
		for(int i=0;i<list.size();i++)
			System.out.print(list.get(i)+" ");
	}
}