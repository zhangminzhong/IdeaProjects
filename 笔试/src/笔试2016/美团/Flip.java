package 笔试2016.美团;

/**
 * Created by zhang_minzhong on 2017/3/13.
 */
public class Flip {
    public int[][] flipChess(int[][] A, int[][] f) {
        int row = 0;
        int col = 0;
        for(int i=0;i<f.length;i++){
            row = f[i][0]-1;
            col = f[i][1]-1;
            if (row-1>=0)
                if(A[row-1][col]==0)
                    A[row-1][col] = 1;
                else
                    A[row-1][col] = 0;
            if(row+1<A.length)
                if(A[row+1][col]==0)
                    A[row+1][col] = 1;
                else
                    A[row+1][col] = 0;
            if(col-1>=0)
                if(A[row][col-1]==0)
                    A[row][col-1] = 1;
                else
                    A[row][col-1] = 0;
            if(col+1<A.length)
                if(A[row][col+1]==0)
                    A[row][col+1] = 1;
                else
                    A[row][col+1] = 0;
        }
        return A;
    }
}
