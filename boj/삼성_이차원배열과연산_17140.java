package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이차원배열과연산_17140 {

	public static void main(String[] args) throws IOException {
		
		int[][] board = new int[101][101];
		boolean[] checked = new boolean[101];
		int[] counted = new int[101];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int r,c,k;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ;i < 3 ;i++) {
			st = new StringTokenizer(br.readLine());
			board[i][0] = Integer.parseInt(st.nextToken());
			board[i][1] = Integer.parseInt(st.nextToken());
			board[i][2] = Integer.parseInt(st.nextToken());			
		}
		int time = 0;
		int row,col;
		row = col =3;
		while(board[r-1][c-1] != k && time <= 100) {
			int tempRow = row;
			int tempCol = col;
			if(row>=col) {
				col=0;
				for(int i = 0 ; i < row; i++) {
					//카운트 하기
					checked = new boolean[101];
					counted = new int[101];
					int[]  ttt = new int[101];
					for(int j = 0 ; j < tempCol ;j++) {
						counted[board[i][j]]+=1;
					}
					//행의 크기 구하기, checked 배열 초기화
					for(int j = 1 ; j <= 100 ;j++) {
						if(counted[j] == 0) {
							continue;
						}else {
							checked[counted[j]] = true;
						}
					}
					int colcol = 0;
					for(int j = 1; j<100 ; j++) {
						if(checked[j]) {
							for(int m = 1 ; m<=100; m++) {
								if(j == counted[m]) {
									ttt[colcol++] = m;
									ttt[colcol++] = counted[m];
								}else {
								}
							}
						}
					}
					col = Math.max(col, colcol);
					for(int j = 0 ; j<100;j++) {
						board[i][j] = ttt[j];
					}
				}
			}else {
				row=0;
				for(int i = 0 ; i < col; i++) {
					//카운트 하기
					checked = new boolean[101];
					counted = new int[101];
					int[] ttt = new int[101];
					for(int j = 0 ; j < tempRow ;j++) {
						counted[board[j][i]]+=1;
					}
					//행의 크기 구하기, checked 배열 초기화
					for(int j = 1 ; j < 101 ;j++) {
						if(counted[j] == 0) {
							continue;
						}else {
							checked[counted[j]] = true;
						}
					}
					int rowrow = 0;
					for(int j = 1; j<101 ; j++) {
						if(checked[j]) {
							for(int m = 1 ; m<101; m++) {
								if(j == counted[m]) {
									ttt[rowrow++] = m;
									ttt[rowrow++] = counted[m];
								}else {
								//	board[m][i]=0;
								}
							}
						}
					}
					row = Math.max(row, rowrow);
					for(int j = 0 ; j<100;j++) {
						board[j][i] = ttt[j];
					}
				}
			}
			time++;
		}
		time = (time==101)?-1:time;
		System.out.println(time);
	}

}
