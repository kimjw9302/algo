package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1303 {

	static int N;
	static int M;
	static final char WHITE = 'W';
	static final char BLUE = 'B';
	static boolean[][] visited;
	static char[][] map;
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] lines = br.readLine().split(" ");
		
		M = parseInt(lines[0]); //가로
		N = parseInt(lines[1]); //세로
		
		map = new char[N][M];
		visited = new boolean[N][M];
		for(int n = 0 ; n < N;n++) {
			String line = br.readLine();
			map[n] = line.toCharArray();
		}
		int wSum = 0;
		int bSum = 0;
		for(int i = 0 ; i < N ;i++) {
//			System.out.println("!!!!");
//			print();
			for(int j = 0; j < M ;j++) {
//				System.out.println(i + " , " +j + " // "+map[i][j]);
				if(!visited[i][j]) {
					if(map[i][j]==WHITE) {
						int tmp = go(i,j,WHITE);
//						System.out.println("W "+ tmp);
						wSum += (tmp*tmp);
					}else {
						int tmp = go(i,j,BLUE);
//						System.out.println("B "+tmp);
						bSum += (tmp*tmp);
					}
				}
			}
		}
		System.out.println(wSum + " "+bSum);
		
	}
	private static void print() {
		for(int i = 0 ; i < N ;i++) {
			for(int j = 0; j < M ;j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}
	}
	
	private static int go(int i, int j, char color) {
		int cnt = 1;
		visited[i][j] = true;
		for(int d = 0 ; d < 4; d++) {
			int nexti = i + di[d];
			int nextj = j + dj[d];
			if(nexti>=0&&nexti<N &&nextj>=0&&nextj<M&&!visited[nexti][nextj]) {
				if(map[nexti][nextj] == color) {
					cnt += go(nexti,nextj,color);
				}
//				visited[nexti][nextj] = true;
			}
		}
		return cnt;
	}

	public static int parseInt(String str) {
		return Integer.parseInt(str);
	}
}
