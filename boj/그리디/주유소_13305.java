package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 주유소_13305 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = stoi(br.readLine());
		String[] len = br.readLine().split(" ");
		String[] val = br.readLine().split(" ");
		
		long min = stoi(val[0]);
		long answer = min*(stoi(len[0]));
		
		for(int i =1 ;i < val.length-1;i++) {
			long now = stoi(val[i]);
			min = (now>=min)?min:now;
			answer += (min*stoi(len[i]));
		}
		System.out.println(answer);
	}
	public static long stoi(String str) {
		return Long.parseLong(str);
	}
}
