package 백준.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 단어수학_1339 {
	static Map<Character,Integer> map = new HashMap<>();
	static int[] alpha_Score = new int['Z'-'A'+1];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		String[] alpha_Str = new String[n];
		for(int i = 0 ; i < n ; i++) {
			String alphabet = br.readLine();
			alpha_Str[i] = alphabet;
			calculate(alphabet);
		}
		List<Character> keySet = new ArrayList<>(map.keySet());
		keySet.sort(new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				// TODO Auto-generated method stub
				return map.get(o1).compareTo(map.get(o2))*-1;
			}
		});
		int num = 9;
		for(int i = 0 ; i < keySet.size();i++) {
			char ch = keySet.get(i);
			alpha_Score[ch-'A'] = num--;
		}
		long answer = 0 ;
		for(int i = 0 ; i < n ; i++) {
			String str = alpha_Str[i];
			StringBuffer sb =new StringBuffer();
			for(int j = 0 ; j < str.length();j++) {
				char ch = str.charAt(j);
				sb.append(alpha_Score[ch-'A']);
			}
			
			answer+=stoi(sb.toString().trim());
		}
		System.out.println(answer);
	}
	private static void calculate(String alphabet) {
		for(int i = alphabet.length()-1,idx = 0 ; i >= 0;i--,idx++) {
			char ch = alphabet.charAt(i);
			if(map.containsKey(ch)) {
				map.put(ch,map.get(ch) + (int) Math.pow(10, idx));
			}else {
				map.put(ch, (int) Math.pow(10, idx));
			}
			
		}
	}
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
