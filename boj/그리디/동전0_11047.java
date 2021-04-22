package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 동전0_11047 {

	public static void main(String[] args) throws IOException {
		int N,K;
		int answer = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		
		ArrayList<Integer> coins = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			coins.add(stoi(br.readLine()));
		}

		
		for(int i = coins.size()-1; i>=0 ; i--) {
			int mok = K/coins.get(i);
			int namage = K%coins.get(i);
			if(mok>0) {
				answer+=mok;
				K = namage;
			}
		}
		System.out.println(answer);
	}
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
