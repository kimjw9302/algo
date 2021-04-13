package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606 {
	static boolean[][] network; //네트워크 정보를 가지고 있으면서
	static boolean[] visited; // 방문정보
	static int N; // 컴푸터 개수
	static int M; //컴퓨터 쌍의 개수
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = parseInt(br.readLine());
		M = parseInt(br.readLine());
		
		network = new boolean[N][N];
		visited = new boolean[N];
		for(int m = 0 ; m < M ;m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = parseInt(st.nextToken())-1;
			int b = parseInt(st.nextToken())-1;
			network[a][b] = true;
			network[b][a] = true;
		}
		
		int answer = bfs();
		System.out.println(answer);
	}
	private static int bfs() {
		Queue<Integer> que = new LinkedList<>();
		//바이러스는 무조건 1번 부터.
		que.add(0);
		visited[0] = true;
		int answer = 0;
		while(!que.isEmpty()) {
			int now = que.poll();
			//다음으로 써치할 곳
			for(int i = 0 ; i < N;i++) {
				if(network[now][i]&&!visited[i]) {
					que.add(i);
					answer++;
					visited[i] = true;
				}
			}
		}
		return answer;
	}
	public static int parseInt(String str) {
		return Integer.parseInt(str);
	}
}
