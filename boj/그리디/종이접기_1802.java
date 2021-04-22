package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 종이접기_1802 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = stoi(br.readLine());
		for(int t = 0 ; t < tc; t++) {
			
			String line = br.readLine();
			
			if(check(line)) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
				
		}
	}
	public static boolean check(String str) {
		if(str.length()==1) {
			return true;
		}
		int mid = str.length()/2;
		
		for(int i = 0 ; i < mid ; i++) {
			if(str.charAt(i) == str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		return check(str.substring(0,mid))&&check(str.substring(mid+1,str.length()));
		
	}
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
