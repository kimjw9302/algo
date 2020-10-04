package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미스_14500 {
	
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };
	static int[][] map;
	static boolean[][] used;
	static int answer;

	public static void main(String[] args) throws IOException {

		// 입력 및 변수 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, M;
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		used = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; st.hasMoreTokens(); j++) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				isGo(i, j, 0, 0);
				other(i, j);
			}
		}

		System.out.println(answer);

	}
	
	private static void other(int i, int j) {
		int wing = 4;
		int min = 99999;
		int sum  = map[i][j];
		for (int d = 0; d < 4; d++) {
			int nexti = i +di[d];
			int nextj = j+ dj[d];
			if (nexti < 0 || nexti >= used.length || nextj < 0 || nextj >= used[0].length) {
				wing--;
				continue;
			}
			min = map[nexti][nextj] < min ? map[nexti][nextj] : min;
			sum+=map[nexti][nextj];
		}
		if(wing == 4) {
			sum -=min;
			answer = (sum > answer) ? sum : answer;
		}else if(wing == 3){
			answer = (sum > answer) ? sum : answer;
		}else {
			return;
		}
	}

	public static void isGo(int ni, int nj, int cnt, int val) {
		if (cnt == 4) {
			answer = (val > answer) ? val : answer;
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nexti = ni + di[d];
			int nextj = nj + dj[d];
			if (nexti < 0 || nexti >= used.length || nextj < 0 || nextj >= used[0].length)
				continue;
			if (!used[nexti][nextj]) {
				used[ni][nj] = true;
				isGo(nexti, nextj, cnt + 1, val + map[nexti][nextj]);
				used[ni][nj] = false;
			}
		}
	}
}
