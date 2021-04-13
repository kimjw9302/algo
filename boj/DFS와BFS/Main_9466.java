package 백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9466 {
	static boolean[] isDone;
	static boolean[] visited;
	static int[] s;
	static int tc;
	static int ans ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			int num = parseInt(br.readLine()) + 1;
			s = new int[num];
			ans = 0;
			isDone = new boolean[num];
			visited = new boolean[num];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i < num; i++) {
				s[i] = parseInt(st.nextToken());
			}
			for (int i = 1; i < num; i++) {
				if (!isDone[i]) {
					go( i);
				}
			}
			System.out.println(num-1-ans);
		}

	}

	private static void go(int now) {
		//방문한적이있네?
		if (visited[now]) {
			isDone[now] = true;
			ans++;
		}else {
			visited[now] = true;
		}
		int next = s[now];
		if(!isDone[next]) {
			go(s[now]);
		}
		
		visited[now] =false;
		isDone[now] = true;
		
	}

	public static int parseInt(String str) {
		return Integer.parseInt(str);
	}
}
