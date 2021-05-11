package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합_1182 {
	public static boolean[] used;
	public static String[] strArr;
	public static void main(String[] args) throws IOException {

		//1개를 뽑았을때부터 ~ N개 까지 뽑았을 경우를 다 찾아야함.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = stoi(st.nextToken());
		int S = stoi(st.nextToken());
		
		strArr = br.readLine().split(" ");
		
		int answer = 0;
		for(int i = 1; i <= N ;i++) {
			used = new boolean[N];
			answer+=go(i,0,S,0,0);
		}
		System.out.println(answer);
		
	}
	public static int go(int n, int depth, int s,int sum,int idx) {
		if(n==depth){
			if(sum == s) {
				return 1;
			}
			return 0;
		}
		int cnt = 0;
		for(int i = idx+1;i <= strArr.length ;i++) {
			if(!used[i-1]) {
				used[i-1] = true;
				cnt+=go(n,depth+1,s,sum+stoi(strArr[i-1]),i);
				used[i-1] = false;
			}
		}
		
		return cnt;
	}
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
