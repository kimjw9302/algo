package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일링_11726 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dp = new int[1001];
		
		dp[1] = 1;
		dp[2] = 2;
		
		int idx = stoi(br.readLine());
		for(int i = 3 ; i <=idx;i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		
		System.out.println(dp[idx]);
		
	}
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
