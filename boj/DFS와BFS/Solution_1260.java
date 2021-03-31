package 백준; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_1260 {
	static int N; //정점개수
	static int M; //간선개수
	static int V; //시작점
	static boolean[][] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {

		// Input Value
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		N = parseInt(line[0]);
		M = parseInt(line[1]);
		V = parseInt(line[2]);
		
		graph = new boolean[N+1][N+1];
		
		
		for(int i = 0 ; i < M ;i++) {
			line = br.readLine().split(" ");
			graph[parseInt(line[0])][parseInt(line[1])] = true;
			graph[parseInt(line[1])][parseInt(line[0])] = true;
		}
		
		dfs();	
		bfs();
	}
	
	private static void bfs() {
		Queue<Integer> que = new LinkedList<>();
		visited = new boolean[N+1];
		StringBuilder sb = new StringBuilder();
		que.add(V);
		visited[V] = true;
		while(!que.isEmpty()) {
			int now = que.poll();
		
			sb.append(now).append(" ");
			for(int i = 1 ; i <= N ;i++) {
				if(graph[now][i] && !visited[i]) { //연결되어있고, 방문한적이 없다면
					que.add(i);
					visited[i] = true;
				}
			}
		}
		System.out.println(sb.toString().trim());
	}

	public static void dfs() {
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		visited = new boolean[N+1];
		stack.add(V);
		
		while(!stack.isEmpty()) {
			int now = stack.pop();
			if(visited[now]) continue;
			sb.append(now).append(" ");
			visited[now] = true;
			for(int i = N ; i >= 1 ;i--) {
				if(graph[now][i] && !visited[i]) { //연결되어있고, 방문한적이 없다면
					stack.add(i);
				}
			}
		}
		System.out.println(sb.toString().trim());
	}
	public static int parseInt(String target) {
		return Integer.parseInt(target);
	}
	
}
