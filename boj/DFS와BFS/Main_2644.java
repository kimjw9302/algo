package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2644 {
	static boolean[][] fam; //가족 정보
	static boolean[] visited; // 방문정보
	static int N; // 
	static int S,E; //start,end
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = parseInt(st.nextToken())-1;
		E = parseInt(st.nextToken())-1;
		
		fam = new boolean[N][N];
		visited = new boolean[N];
		int tc = parseInt(br.readLine());
		for(int m = 0 ; m < tc ;m++) {
			st = new StringTokenizer(br.readLine());
			int a = parseInt(st.nextToken())-1;
			int b = parseInt(st.nextToken())-1;
			fam[a][b] = true;
			fam[b][a] = true;
		}
		
		int answer = bfs();
		System.out.println(answer);
	}
	private static int bfs() {
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(S,0));
		visited[S] = true;
		int answer = 0;
		while(!que.isEmpty()) {
			Node now = que.poll();
			if(now.idx == E) {
				return now.depth;
			}
			//다음으로 써치할 곳
			for(int i = 0 ; i < N;i++) {
				if(fam[now.idx][i]&&!visited[i]) {
					que.add(new Node(i,now.depth+1));
					visited[i] = true;
				}
			}
		}
		return -1;
	}
	public static int parseInt(String str) {
		return Integer.parseInt(str);
	}
	static class Node{
		int idx;
		int depth;
		
		Node(int idx, int depth){
			this.idx = idx;
			this.depth =depth;
		}
	}
}
