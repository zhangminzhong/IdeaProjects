package 笔试2016.顺丰;

import java.util.Scanner;

public class 单词前缀{
	
	private static int[] counts;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//t���
		int t = Integer.parseInt(scanner.nextLine());
		for(int i=1;i<=t;i++){
			int n,m;
			String[] nmArr = scanner.nextLine().trim().split(" ");
			n = Integer.parseInt(nmArr[0]);
			m = Integer.parseInt(nmArr[1]);
			String[] totalWords = new String[n];
			String[] words = new String[m];
			for(int j = 0;j<n;j++){
				totalWords[j] = scanner.nextLine();
			}
			for(int k = 0;k<m;k++){
				words[k] = scanner.nextLine();
			}
			findPrefixCount(totalWords, words);
			System.out.println("Case #"+t+":");
			for(int w=0;w<counts.length;w++)
				System.out.println(counts[w]);
		}
	}
	
	public static void findPrefixCount(String[] totalWords,String[] words){
		
		counts = new int[words.length];
		for(int i=0;i<words.length;i++){
			String str=words[i];
			int count = 0;
			for(int j=0;j<totalWords.length;j++){
				if(totalWords[j].length()<str.length())
					continue;
				if(totalWords[j].length()==str.length()){
					if(totalWords[j].equals(str))
						count++;
					continue;
				}
		
				int wordLength = words[i].length();
				String temp = totalWords[j].substring(0, wordLength);
				//System.out.println(temp);
				if(temp.equals(str))
					count++;
			}
			//System.out.println(count);
			counts[i]=count;
		}
	}

}
