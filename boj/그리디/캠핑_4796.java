package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 캠핑_4796 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int tc = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = stoi(st.nextToken());
			int P = stoi(st.nextToken());
			int V = stoi(st.nextToken());
			if(L==0 && P==0 && V ==0) {
				System.out.println(sb.toString());
				break;
			}
			
			sb.append("Case ").append(tc++).append(": ");
			
			int answer = (V/P)*L;
			int namage = (V%P)>=L?L:(V%P);
			answer +=namage;
			sb.append(answer).append("\n");
			
			
		}
	}
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
