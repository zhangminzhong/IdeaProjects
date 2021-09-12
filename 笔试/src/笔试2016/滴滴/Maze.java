package 笔试2016.滴滴;

import java.util.Scanner;
import java.util.Stack;

/** 
 * �Թ��� 
 * �ҵ����е����յ��·�� 
 * @author cuiods 
 */  
public class Maze {  
  
    /** 
     * ��ʱ����·�� 
     */  
    private Stack<MazeCell> pathStack = new Stack<MazeCell>();
    /** 
     * �����Թ� 
     */  
    private int[][] maze;  
    private boolean flag = false;  
    private MazeCell startCell;  
    private MazeCell endCell;  
  
    public Maze() {  
        initialMaze();  
    } 
    
    public static void main(String[] args) {  
        Maze maze = new Maze();
        maze.findPath();  
    }
  
    /** 
     * Ѱ��·�� 
     */  
    public void findPath() {  
        assert flag;  
        processCell(startCell.getX(), startCell.getY(), startCell.getStep());  
    }  
  
    private void processCell(int x, int y, int step) {  
        if (x == endCell.getX() && y == endCell.getY()) {  
            pathStack.pop();  
            printPath();  
            System.out.println("["+(endCell.getX()-1)+","+(endCell.getY()-1)+"]");  
            return;  
        }  
        test(x,y-1,step+1);//������  
        test(x,y+1,step+1);//������
        test(x-1,y,step+1);//������
        test(x+1,y,step+1);//������
    }  
  
    private void test(int x, int y, int step) {  
        if (canGo(x,y)){  
            MazeCell mazeCell = new MazeCell(x,y,step);  
            insertToPath(mazeCell);  
            processCell(x,y,step);  
        }  
    }  
  
    private void printPath(){  
        for (int i = 0; i < pathStack.size(); i++) {  
            MazeCell cell = pathStack.get(i);  
            System.out.print("["+(cell.getX()-1)+","+(cell.getY()-1)+"],");  
        }  
    }  
  
    private void insertToPath(MazeCell mazeCell) {
    	
        while (pathStack.peek().getStep() >= mazeCell.getStep()) {  
            pathStack.pop();  
        }  
        pathStack.push(mazeCell);  
    }  
  
    private boolean canGo(int x, int y) {  
        if (maze[x][y]==0) {  
            return false;  
        }  
        for (int i = 0; i < pathStack.size(); i++) {  
            MazeCell mazeCell = pathStack.get(i); 
            //�жϸõ��Ƿ��Ѿ��������Ƿ�ɻ���
            if (mazeCell.getX()==x && mazeCell.getY()==y) {  
                return false;  
            }  
        }  
        return true;  
    }  
  
    private void initialMaze() {  
        int column;  
        int row;  
        Scanner scanner = new Scanner(System.in);  
        int temp = 0;  
        do {  
            System.out.println("�������Թ�����(>0)��");  
            temp = scanner.nextInt();  
        } while (temp<=0);  
        row = temp;  
        do {  
            System.out.println("�������Թ�����(>0)��");  
            temp = scanner.nextInt();  
        } while (temp<=0);  
        column = temp;  
        maze = new int[row+2][column+2];  
        System.out.println("�������Թ���1Ϊ·��0Ϊǽ��-1Ϊ��㣬2Ϊ�յ㣩:");  
        for (int i = 0; i < column+2; i++) {  
            maze[0][i] = 0;  
        }  
        for (int i = 1; i < row+1; i++) {  
            maze[i][0] = 0;  
            for (int j = 1; j < column+1; j++) {  
                temp = scanner.nextInt();  
                switch (temp) {  
                    case -1:  
                        startCell = new MazeCell(i,j,0);  
                        maze[i][j] = temp;  
                        pathStack.push(startCell);  
                        break;  
                    case 2:endCell = new MazeCell(i,j,-1);  
                    case 0:  
                    case 1:maze[i][j] = temp;break;  
                    default:  
                        System.out.println("���벻����Ҫ��T T");  
                        return;  
                }  
            }  
            maze[i][column+1] = 0;  
        }  
        for (int i = 0; i < column+2; i++) {  
            maze[row+1][i] = 0;  
        }
        
        for(int i=0;i<row+2;i++){
        	for(int j=0;j<column+2;j++)
        		System.out.print(maze[i][j]+" ");
        	System.out.println();
        }
        
        if (startCell!=null && endCell!=null) {  
            flag = true;  
            System.out.println("����ɹ�:)");  
        } else {  
            System.out.println("����Ҫ��һ�������յ�:(");  
        }  
    }
    
    public class MazeCell {
    	private int x;  
        private int y;  
        private int step;  
      
        public MazeCell(int x, int y, int step) {  
            this.x = x;  
            this.y = y;  
            this.step = step;  
        }  
      
        public int getX() {  
            return x;  
        }  
      
        public void setX(int x) {  
            this.x = x;  
        }  
      
        public int getY() {  
            return y;  
        }  
      
        public void setY(int y) {  
            this.y = y;  
        }  
      
        public int getStep() {  
            return step;  
        }  
      
        public void setStep(int step) {  
            this.step = step;  
        } 

    }
}
