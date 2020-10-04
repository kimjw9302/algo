/*
*	url :  https://programmers.co.kr/learn/courses/30/lessons/62048
*/
import java.lang.Math;

class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        double tan = (double)h/w;
        // 0 1 2 3 4 5 ,,, w-1
        for(int x = 1 ; x < w ; x++){
            double temp = x*tan;
            int ceilVal = (int)Math.ceil(temp);
            answer += h - ceilVal;
        }     
        answer=answer*2;
        return answer;
    }
}