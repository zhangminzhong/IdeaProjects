package 笔试2016.滴滴;

import java.util.*;

public class XiaoQingWa {

	private static int n;
	private static int m;
	private static int p;
	private static int[][] matrix;
	private static Point start;
	private static Point end;
	private static LinkedList<Point> stack = new LinkedList<Point>();
	private static List<List<Point>> totalPathList = new ArrayList<List<Point>>();

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] nmp = scanner.nextLine().trim().split(" ");
		n = Integer.parseInt(nmp[0]);
		m = Integer.parseInt(nmp[1]);
		p = Integer.parseInt(nmp[2]);
 		
		//��ʼ��һ��(n+2)*(m+2)�ľ���
		matrix = new int[n+2][m+2];
		for(int i=0;i<=m+1;i++){
			matrix[0][i] = 1;
			matrix[n+1][i] = 1;
		}
		for(int i=1;i<=n+1;i++){
			matrix[i][0] = 1;
			matrix[i][m+1] = 1;
		}

		for (int i = 1; i < n+1; i++) {
			int j = 1;
			while (scanner.hasNextInt()) {
				matrix[i][j] = scanner.nextInt();
				j++;
				if (j == m+1)
					break;
			}
		}
		
		matrix[1][1] = -1;
		matrix[4][3] = 2;
		
		System.out.println("*************");
		System.out.println(Arrays.deepToString(matrix));
		for (int i = 0; i < n+2; i++) {
			for (int j = 0; j < m+2; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
		
		//��ʼ�������㣬�յ�
		
		
		
		
		start = new Point(1,1,0);
		stack.push(start);
		end = new Point(4,3,-1);
		
		//�ҳ�����·��
		findPath(start.getX(),start.getY(),start.getStep());
		
		//�ҳ�stepֵ��С��·��
		//findMinPath();
	}

	private static void findMinPath() {
		long min = 10000;
		LinkedList<Point> stackI;
		for(int i=0;i<totalPathList.size();i++){
			stackI = (LinkedList<Point>) totalPathList.get(i);
			int tempStep = stackI.peek().getStep();
			if(tempStep<min)
				min = tempStep;
		}
		if(min>p)
			System.out.println("Can not escape!");
		else
			for(int i=0;i<totalPathList.size();i++){
				stackI = (LinkedList<Point>) totalPathList.get(i);
				if(min == stackI.peek().getStep()){
					for(int j=0;j<stackI.size();j++){
						Point point = stack.get(i);
						if(i<stack.size()-1)
							System.out.println("["+(point.getX()-1)+","+(point.getY()-1)+"],");
						else
							System.out.println("["+(point.getX()-1)+","+(point.getY()-1)+"]");
					}
					break;
				}
			}
	}

	private static void findPath(int x, int y, int step) {
		//����ҵ�����
		if(x==end.getX()&&y==end.getY()){
			//totalPathList.add(new LinkedList<Point>(stack));
			//return;
			//addTotalList();
			//if(step<=p){
			stack.pop();  
            printPath();  
            System.out.println("("+end.getX()+","+end.getY()+")");  
            return;  
			//}
				
			//else 
				//return;
		}
		test(x,y-1,step+1);//������  
        test(x,y+1,step+1);//������
        test(x-1,y,step+1);//������
        test(x+1,y,step+1);//������
	}

	private static void printPath() {
		for (int i = 0; i < stack.size(); i++) {  
            Point point = stack.get(i);
            System.out.print("("+point.getX()+","+point.getY()+")->");  
        } 
	}

	private static void test(int x, int y, int step) {
		//���õ��ܲ����ߣ����ڵݹ飬֮ǰ�����ҵ���·������Ҫ��ջ��stepֵ���ڵ�ǰֵ�ĵ��ջ�����õ�ǰ���ջ��
		if(canGo(x,y)){
			Point point = new Point(x, y, step);
			insertToPath(point);
			findPath(x, y, step);
		}
	}

	private static void insertToPath(Point point) {
		while (stack.peek().getStep() >= point.getStep()) {  
			stack.pop();  
        }  
		stack.push(point);		
	}

	private static boolean canGo(int x, int y) {
		//����õ�Ϊ0����������
		if(matrix[x][y]==1)
			return false;
		//����õ���֮ǰ�߹��ĵ㣬��������
		for(int i=0;i<stack.size();i++)
			if(stack.get(i).getX()==x&&stack.get(i).getY()==y)
				return false;
		return true;
	}
	
}
