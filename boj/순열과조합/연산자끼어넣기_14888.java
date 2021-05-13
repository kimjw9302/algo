package 백준.순열;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연산자끼어넣기_14888 {
	static int N;
	static ArrayList<Integer> arr;
	static int[] op; // + - * /
	static int max, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new ArrayList<>();
		op = new int[4];
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (;st.hasMoreTokens();)
			arr.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		for (int i = 0; st.hasMoreTokens();i++)
			op[i] = Integer.parseInt(st.nextToken());
		max = -1000000000;
		min = Integer.MAX_VALUE;
		permutation(N, 0);
		System.out.println(max);
		System.out.println(min);

	}

	private static void permutation(int tot, int idx) {
		if (idx == tot-1) {
//			System.out.println(arr);
			max = Math.max(max, arr.get(0));
			min = Math.min(min, arr.get(0));
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (op[i] != 0) {
				op[i]--;
				int tempA = arr.remove(0);
				int tempB= arr.remove(0);
//				System.out.println(tempA+ " , " +tempB + " , " +i);
				cal(tempA, tempB, i);
				permutation(tot, idx+1);
				arr.remove(0);
				arr.add(0,tempA);
				arr.add(1,tempB);
				op[i]++;
			}
		}
	}


	private static void cal(int a, int b, int oper) {
		int result = 0;
		switch (oper) {
		case 0: //+
			result = a+b;
			arr.add(0,result);
			break;
		case 1://-
			result = a-b;
			arr.add(0,result);
			break;
		case 2: //*
			result = a*b;
			arr.add(0,result);
			break;
		case 3:// /
			boolean flag = (a<0)?true:false;
			if(b==0) {
				arr.add(0,0);
				break;
			}
			if(flag) {
				result=(-1*a)/b;
				result*=-1;
			}else {
				result=a/b;
			}
			arr.add(0,result);
			break;
		}
	}
}
