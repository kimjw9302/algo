package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼더하기_9095 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] n = new int[11];
		int tc = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		n[1] = 1;
		n[2] = 2;
		n[3] = 4;
		
		for(int  i = 4; i <= 10; i++) {
			n[i] = n[i-1]+n[i-2]+n[i-3];
		}
		
		for(int i = 0 ; i < tc ;i++) {
			int input = stoi(br.readLine());
			sb.append(n[input]).append("\n");
		}
		System.out.println(sb.toString());
	}	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
