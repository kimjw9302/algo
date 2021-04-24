package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실배정_11000 {
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int N = stoi(br.readLine());
		for(int i = 0 ; i < N ;i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = stoi(st.nextToken());
			int end = stoi(st.nextToken());
			pq.add(new Pair(start,end));
		}
		
		PriorityQueue<Integer> endTime = new PriorityQueue<>();
		endTime.add(pq.poll().b);

		for(int i = 1 ; i < N ;i++) {
			Pair now = pq.poll();
			int end = endTime.peek();
			
			if(now.a>=end) {
				endTime.poll();
			}
			endTime.add(now.b);
		}
		System.out.println(endTime.size());
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
	
	static class Pair implements Comparable<Pair>{
		int a;
		int b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(Pair target) {
			if(this.a<target.a)return -1;
			else if(this.a == target.a && this.b < target.b) return -1;
			return 1;
		}
	}
}
