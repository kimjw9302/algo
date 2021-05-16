package 나머지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팰린드롬_10942 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//수열의 크기
		int N = stoi(br.readLine());
		//칠판에 적은 수
		String[] num = br.readLine().split(" ");
		//질문의 개수
		int M = stoi(br.readLine());
		
		//질문에 대한 답을 처리하기 전에, 각 자리에서 팰린드롬인 경우를 찾는다.
		
		//팰린드롬의 여부 저장 테이블 boolean[i][j] = i는 개수이며, j는 시작위치 이다.
		boolean[][] isPalindrome = new boolean[num.length+1][num.length];
		
		for(int i = 1 ; i < isPalindrome.length;i++) {
			for(int j = 0 ; j < isPalindrome[i].length-i+1;j++) {
				if(i == 1 ) { //1자리는 무조건 팰린드롬
					isPalindrome[i][j] = true;
				}else if(i==2) {//2자리는 처음과 마지막이 동일할 경우 팰린드롬
					int first = stoi(num[j]);
					int last = stoi(num[j+i-1]);
					if(first==last) isPalindrome[i][j] = true;
				}else {//3자리이 이상은, 처음과 마지막이 같고, 그 사이값이 팰린드롬인 경우에만 팰린드롬이다.
					int first = stoi(num[j]);
					int last = stoi(num[j+i-1]);
					if(first==last) {
						if(isPalindrome[i-2][j+1]) {
							isPalindrome[i][j] = true;
						}
					}
				}
			}
		}
		
		//질문 M개에 대한 처리. isPanlidrome 테이블 탐색
		StringBuffer sb = new StringBuffer();
		for(int m = 0 ; m < M ; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = stoi(st.nextToken());
			int end = stoi(st.nextToken());
			int cnt = end-start;
			if(isPalindrome[cnt+1][start-1]) sb.append("1").append("\n");
			else sb.append("0").append("\n");
		}
		
		System.out.println(sb.toString());
	}
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
