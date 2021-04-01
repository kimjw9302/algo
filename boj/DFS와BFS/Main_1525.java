package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1525 {
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	static HashSet<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Simulation> que = new LinkedList<>();
		
		int[][] graph = new int[3][3];
		int si  = 0;
		int sj = 0;
		for(int i = 0 ; i < 3;i++) {
			String[] lines = br.readLine().split(" ");
			for(int j = 0 ; j < 3 ;j++) {
				if(lines[j].equals("0")) {
					si = i ; 
					sj = j;
				}
				graph[i][j] = parseInt(lines[j]);
			}
		}
		if(checkGraph(graph)) {
			System.out.println("0");
			System.exit(0);
		}
		que.add(new Simulation(0,si, sj,graph));
		while(!que.isEmpty()) {
			Simulation now = que.poll();
			for(int d = 0 ; d < 4 ; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];
				if(nexti>=0&&nexti<3&&nextj>=0&&nextj<3) {
					int tmp = now.graph[nexti][nextj];
					now.graph[nexti][nextj] = now.graph[now.i][now.j];
					now.graph[now.i][now.j] = tmp; 
					if(checkGraph(now.graph)) {
						System.out.println(now.num+1);
						System.exit(0);
					}
					if(set.add(arrayToString(now.graph))) {
						que.add(new Simulation(now.num+1, nexti, nextj, now.graph));
					}
					tmp = now.graph[nexti][nextj];
					now.graph[nexti][nextj] = now.graph[now.i][now.j];
					now.graph[now.i][now.j] = tmp; 
				}
			}
		}
		System.out.println(-1);
		
	}
	
	private static String arrayToString(int[][] graph) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < 3;i++) {
			for(int j = 0 ; j <3 ; j++) {
				sb.append(graph[i][j]);
			}
		}
		return sb.toString();
	}

	private static boolean checkGraph(int[][] graph) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < 3;i++) {
			for(int j = 0 ; j <3 ; j++) {
				sb.append(graph[i][j]);
			}
		}
		return sb.toString().equals("123456780");
	}

	private static int parseInt(String string) {
		return Integer.parseInt(string);
	}

	static class Simulation{
		int num;
		int i;
		int j;
		int[][] graph;
		public Simulation(int num,int i , int j, int[][] graph) {
			this.num = num;
			this.i = i ;
			this.j = j;
			this.graph = new int[3][3];
			for(int k = 0 ; k< 3;  k++) {
				for(int m = 0 ; m < 3 ;m++) 
				this.graph[k][m] = graph[k][m];
				
			}
		}
		public void print() {
			for(int i = 0 ; i < 3; i++) {
				for(int j = 0 ; j < 3 ; j++) {
					System.out.print(this.graph[i][j]);
				}
				System.out.println();
			}
		}
	}
}
