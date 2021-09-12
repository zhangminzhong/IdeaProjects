package 笔试2017.阿里校招;

/**
 * Created by zhang_minzhong on 2017/8/15.
 */

import java.util.*;

public class Main {
    static int N = 0;
    static int score[];
    static Map<Integer,Integer> map = new HashMap<Integer, Integer>();
    private static int dp(int state){

        if(state == 0)return 0;
        if(map.containsKey(state))return map.get(state);
        int max = 0;
        for(int i=0;i<N;i++){
            if(score[i]==0||score[i]==-1)continue;
            int temp = state-(1<<i);
            int tempScore = score[i];
            score[i] = -1;
            int r = tempScore*calcute(i)+dp(temp);
            if(r>max)max = r;
            score[i] = tempScore;
        }
        map.put(state, max);
        return max;
    }

    private static int calcute(int index) {
        int left = 1;
        int right = 1;
        int indexTemp = index;
        while(index-1>=0){
            if(score[index-1]==-1)index--;
            else if(score[index-1]==0)break;
            else {
                left = score[index-1];
                break;
            }
        }
        index = indexTemp;
        while(index+1<N){
            if(score[index+1]==-1)index++;
            else if(score[index+1]==0)break;
            else {
                right = score[index+1];
                break;
            }
        }
        return left*right;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res = 0;

        int _score_size = 0;
        _score_size = Integer.parseInt(in.nextLine().trim());
        int[] _score = new int[_score_size];
        int _score_item;
        Random r = new Random();
        for (int _score_i = 0; _score_i < _score_size; _score_i++) {
            _score_item = Integer.parseInt(in.nextLine().trim());
            _score[_score_i] = _score_item;
        }

        score = _score;
        int pre = 0;
        int i=0;
        for(i=0;i<_score.length;i++){
            if(_score[i]==0){
                if(pre==i)continue;
                N = i-pre;
                score = Arrays.copyOfRange(_score,pre,i);
                map.clear();
                res += dp((1<<N)-1);
                pre = i+1;
            }
        }
        if(i==_score.length){
            map.clear();
            N = i-pre;
            score = Arrays.copyOfRange(_score,pre,i);
            res += dp((1<<N)-1);
        }
        System.out.println(res);
    }
}
