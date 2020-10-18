package 나머지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NHN_pretest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];
		boolean[][] used = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; st.hasMoreTokens(); j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<Integer> answers = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !used[i][j]) {
					answers.add(find(i, j, map, used));
				}
			}
		}

		Collections.sort(answers);
		System.out.println(answers.size());
		for (int i = 0; i < answers.size(); i++) {
			System.out.print(answers.get(i) + " ");
		}
	}

	public static int find(int i, int j, int[][] map, boolean[][] used) {
		int cnt = 1;
		int[] di = {0,1,0,-1};
		int[] dj = {1,0,-1,0};
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(i,j));
		used[i][j]= true;
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			for(int d = 0; d < 4 ; d++) {
				int nexti = now.i+di[d];
				int nextj = now.j+dj[d];
				
				if(nexti>=0&nexti<map.length&nextj>=0&nextj<map[0].length) {
					if(map[nexti][nextj] == 1 && 
							!used[nexti][nextj]) {
						cnt++;
						que.add(new Node(nexti,nextj));
						used[nexti][nextj] = true;
					}
				}
			}
		}
		
		return cnt;
	}

	static class Node {
		int i, j;

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
