package 백준.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 이전순열_10973 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = stoi(br.readLine());

		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; st.hasMoreTokens(); i++) {
			arr[i] = stoi(st.nextToken());
		}

		ArrayList<Integer> tmp = new ArrayList<>();
		boolean isGo = false;
		int idx = 0;
		boolean[] visited = new boolean[N + 1];
		for (int i = N - 1; i >= 1; i--) {
			int now = arr[i];
			int prev = arr[i - 1];
			visited[now] = true;
			if (now < prev) {
				tmp.add(now);
				tmp.add(prev);
				// prev 다음 보다 작은값 찾아내!
				for (int j = prev - 1; j >= 0; j--) {
					if (visited[j]) {
						arr[i-1] = j;
						break;
					}
				}
				idx = i - 1;
				isGo = true;
				break;
			} else {
				tmp.add(now);
			}
		}

		if (isGo) {
			StringBuffer sb = new StringBuffer();
				Collections.sort(tmp, Collections.reverseOrder());
				for (int i = 0; i <= idx; i++) {
					sb.append(arr[i]).append(" ");
				}
				for (int i = 0; i < tmp.size(); i++) {
					if (arr[idx] != tmp.get(i)) {
						sb.append(tmp.get(i)).append(" ");
					}
				}

			System.out.println(sb.toString().trim());
		} else {
			System.out.println("-1");
		}
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
