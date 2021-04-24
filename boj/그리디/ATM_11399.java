package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ATM_11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = stoi(br.readLine());
		
		String[] p = br.readLine().split(" ");
		int[] pi = new int[N];
		for(int i = 0 ; i < N; i++) {
			pi[i] = stoi(p[i]);
		}
		Arrays.sort(pi);
		int answer = 0;
		for(int i = 0 ; i < N; i++) {
			answer+=(pi[i]*(N-i));
		}
		System.out.println(answer);
	}
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
