package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2573 {

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());

		map = new int[N][M];
		int maxYear = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; st.hasMoreTokens(); j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0; //2덩어리로 분리된 년을 나타냄.
		
		//빙산의 최고 크기만큼 반복시킴.
		while (!isGO()) {
			visited = new boolean[N][M];
			int count = 0; // 빙산덩어리의 개수를 나타냄.
			// 1] 빙산을 먼저 녹인다. 예외, 첫 해는 녹이지 않는다.
			if (answer != 0) {
				melting();
			}
			
			// 2] 녹인 빙산을 가지고 덩어리를 찾기 위해 dfs 시작.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > 0 && !visited[i][j]) {// 방문한적이 없다면
						count++;
						visited[i][j] = true;
						go(i, j);
					}
				}
			}
			// 최초 덩어리가 2개로 분리됨. ...->2개가 아니라 최초 분리되니깐 여러개일수도있음.
			if (count >= 2) {
				System.out.println(answer);
				System.exit(0);
			}
			
			answer++;
			
		}
		System.out.println(0);
	}

	private static boolean isGO() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] <= 0) {// 방문한적이 없다면
					cnt++;
				}
			}
		}
		return cnt==(M*N);
	}

	// 빙산을 녹이는 함수
	private static void melting() {
		int[][] minus = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) {// 방문한적이 없다면
					int cnt = 0;
					for(int d = 0 ; d < 4 ; d++) {
						int nexti = i +di[d];
						int nextj = j +dj[d];
						if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M &&map[nexti][nextj]<=0) {
							cnt++;
						}
					}
					minus[i][j] = cnt;
				}
			}
		}
		
		for(int i = 0 ;i < N ;i++) {
			for(int j = 0 ; j < M ;j++) {
				map[i][j]-=minus[i][j];
			}
		}
		
	}

	private static void go(int nowi, int nowj) {
		for (int d = 0; d < 4; d++) {
			int nexti = nowi + di[d];
			int nextj = nowj + dj[d];
			if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && !visited[nexti][nextj]&&map[nexti][nextj]>0) {
				visited[nexti][nextj] = true;
				go(nexti, nextj);
			}
		}

	}

	public static int parseInt(String str) {
		return Integer.parseInt(str);
	}
}
