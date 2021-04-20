package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 로프_2217 {
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = stoi(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < N ; i++) {
			int input = stoi(br.readLine());
			arr.add(input);
		}
		Collections.sort(arr);
		for(int i = 0 ; i < arr.size();i++) {
			int now = arr.get(i);
			max = (max<=now*(N-i))?now*(N-i):max;
		}
		System.out.println(max);
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
