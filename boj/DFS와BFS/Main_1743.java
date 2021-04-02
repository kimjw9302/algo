	package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1743 {
	static int N;
	static int M;
	static int K;
	
	static boolean[][] map;
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] lines = br.readLine().split(" ");
		
		N = parseInt(lines[0]);
		M = parseInt(lines[1]);
		K = parseInt(lines[2]);
		map = new boolean[N+1][M+1];
	
		ArrayList<Pair> cmds = new ArrayList<>();
		
		for(int k = 0 ; k < K ; k++) {
			lines = br.readLine().split(" ");
			int r = parseInt(lines[0]);
			int c = parseInt(lines[1]);
			cmds.add(new Pair(r,c));
			map[r][c] = true;
			
		}
		
		int answer = 0;
		for (Pair pair : cmds) {
			int result = go(pair.r,pair.c);
			answer = (answer>=result)? answer:result;
			
			
		}
		//DFS
		System.out.println(answer);
	
		
	}
	
	private static int go(int r, int c) {
		int cnt = 1;
		map[r][c] = false;
		for(int d = 0 ; d < 4 ; d++) {
			int nexti = r + di[d];
			int nextj = c + dj[d];
			if(nexti>=1&&nexti<=N&&nextj>=1&&nextj<=M&&map[nexti][nextj]) {
				
				cnt+=go(nexti,nextj);
			}
		}
		
		return cnt;
	}

	public static int parseInt(String s) {
		return Integer.parseInt(s);
	}
	
	static class Pair{
		int r;
		int c;
		public Pair(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
}
