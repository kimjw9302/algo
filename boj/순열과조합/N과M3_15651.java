package 백준.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M3_15651 {
	static StringBuffer answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		
		StringBuffer sb = new StringBuffer();
		answer = new StringBuffer();
		combination(N,M,0,sb);
		System.out.println(answer);
	}
	private static void combination(int n, int m,int depth,StringBuffer sb) {
		if(depth == m) {
			//출력
			answer.append(sb.toString()).append("\n");
		return;
		}
		
		for(int i = 1 ; i <= n ; i++) {
				sb.append(i).append(" ");
				combination(n, m, depth+1,sb);
				sb.delete(sb.toString().length()-2, sb.toString().length());

		}
		
	}
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
