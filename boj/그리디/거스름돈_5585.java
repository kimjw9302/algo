package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈_5585 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int pay = Integer.parseInt(br.readLine()); // 지불한돈
		int money = 1000 - pay; // 거스름돈
		int cnt = 0;
		while (money != 0) {

			if (money >= 500) {
				cnt +=( money / 500);
				money = money % 500;
			} else if (money >= 100) {
				cnt += (money / 100);
				money = money % 100;
			} else if (money >= 50) {
				cnt += (money / 50);
				money = money % 50;
			} else if (money >= 10) {
				cnt += (money / 10);
				money = money % 10;
			} else if (money >= 5) {
				cnt += (money / 5);
				money = money % 5;
			} else {
				cnt += (money / 1);
				money = money % 1;
			}
		}
		System.out.println(cnt);
	}
}
