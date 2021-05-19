package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_14501 {
	static int[] T;
	static int[] P;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		T = new int[N + 1];
		P = new int[N + 1];
		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[n] = stoi(st.nextToken());
			P[n] = stoi(st.nextToken());
		}

		solve_dp();
		int answer = 0;
		for (int i = 1; i < P.length; i++) {
			answer = (answer<=P[i])?P[i]:answer;
		}
		System.out.println(answer);
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

	private static void solve_dp() {
		for (int n = N; n >= 1; n--) {
			//퇴사 이후에 일을 하면 억울하니깐 패스
			if (n + T[n] > N+1) {
				P[n] = 0;
				continue;
			}
			//현재의 비용 + (현재 일수 + 상담시간) 한 비용 (최대값을 가지고 다닐거야 아마도)
			
			P[n] += (findMax(n+T[n]));
			
		}

	}
	public static int findMax(int idx) {
		int max = Integer.MIN_VALUE;
		for(int i = idx ; i<=N ;i++) {
			max  = (max<=P[i])?P[i] : max;
		}
		return (max==Integer.MIN_VALUE)?0:max;
	}
}
