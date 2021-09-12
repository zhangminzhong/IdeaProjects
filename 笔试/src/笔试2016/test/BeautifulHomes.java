package 笔试2016.test;

import java.util.ArrayDeque;
import java.util.Queue;

/** 
 * @author Administrator 
 * 
 */  
public class BeautifulHomes {  
    public static int counthHomes(int grid[][]) {  
        // �����������  
        if (grid == null || grid[0].length == 0 || grid.length == 0) {  
            return 0;  
        }  
        // һ�����  
        int rows = grid.length;  
        int cols = grid[0].length;  
        // ���ʱ�־����  
        boolean visited[] = new boolean[rows * cols];  
        int home_count = 0;  
        for (int row = 0; row < rows; row++) {  
            for (int col = 0; col < cols; col++) {  
                if (count_home(grid, rows, cols, row, col, visited)) {  
                    home_count++;  
                }  
            }  
        }  
        return home_count;  
  
    }  
  
    private static boolean count_home(int[][] grid, int rows, int cols, int row, int col, boolean[] visited) {  
        if (row >= 0 && row < rows && col >= 0 && col < cols && visited[row * cols + col] == false  
                && grid[row][col] == 1) {  
  
            mark_neighbor_4(grid, rows, cols, row, col, visited);  
            return true;  
        }  
  
        return false;  
    }  
  
    // ���4��ͨ����,������ȱ���  
    // ʹ�ö��и���  
    private static void mark_neighbor_4(int[][] grid, int rows, int cols, int row, int col, boolean[] visited) {  
        if (row < 0 || row >= rows || col < 0 && col >= cols) {  
            return;  
        }  
        Queue<Integer> indexQueue = new ArrayDeque<Integer>();  
        indexQueue.offer(row);  
        indexQueue.offer(col);  
        int curRow;  
        int curCol;  
        while (!indexQueue.isEmpty()) {  
            curRow = indexQueue.poll();  
            curCol = indexQueue.poll();  
            if (curRow - 1 >= 0 && curRow < rows && curCol >= 0 && curCol < cols && grid[curRow - 1][curCol] == 1  
                    && visited[(curRow - 1) * cols + curCol] == false) {  
                visited[(curRow - 1) * cols + curCol] = true;  
                indexQueue.offer(curRow - 1);  
                indexQueue.offer(curCol);  
            }  
            if (curCol - 1 >= 0 && curRow >= 0 && curRow < rows && curCol < cols && grid[curRow][curCol - 1] == 1  
                    && visited[(curRow) * cols + curCol - 1] == false) {  
                visited[(curRow) * cols + curCol - 1] = true;  
                indexQueue.offer(curRow);  
                indexQueue.offer(curCol - 1);  
  
            }  
            if (curRow + 1 < rows && curRow >= 0 && curCol >= 0 && curCol < cols && grid[curRow + 1][curCol] == 1  
                    && visited[(curRow + 1) * cols + curCol] == false) {  
                visited[(curRow + 1) * cols + curCol] = true;  
                indexQueue.offer(curRow + 1);  
                indexQueue.offer(curCol);  
  
            }  
            if (curCol + 1 < cols && curRow >= 0 && curRow < rows && grid[curRow][curCol + 1] == 1  
                    && visited[(curRow) * cols + curCol + 1] == false) {  
                visited[(curRow) * cols + curCol + 1] = true;  
                indexQueue.offer(curRow);  
                indexQueue.offer(curCol + 1);  
            }  
  
        }  
        return;  
    }  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        int grid1[][] = new int[4][4];  
  
        System.out.println(grid1.length + "��" + grid1[0].length + "��");  
        for (int i = 0; i < grid1.length; i++) {  
            for (int j = 0; j < grid1[0].length; j++) {  
                grid1[i][j] = 1;  
            }  
        }  
        System.out.println(counthHomes(grid1));  
  
        int grid2[][] = new int[4][4];  
        System.out.println(grid2.length + "��" + grid2[0].length + "��");  
        for (int i = 0; i < grid2.length; i++) {  
            for (int j = 0; j < grid2[0].length; j++) {  
                if (i == j) {  
                    grid2[i][j] = 1;  
                }  
  
            }  
        }  
        System.out.println(counthHomes(grid2));  
  
        int grid3[][] = new int[5][5];  
        System.out.println(grid3.length + "��" + grid3[0].length + "��");  
        grid3[1][1] = 1;  
        grid3[1][2] = 1;  
        grid3[2][2] = 1;  
        grid3[2][3] = 1;  
        grid3[4][3] = 1;  
        System.out.println(counthHomes(grid3));  
    }  
  
}  