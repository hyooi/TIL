package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Programmers {

	public static void test() {
		Map<Integer, Integer> map = new HashMap<>();
		int[] arrs = new int[]{1,3,2,5,3,1};
		for(int i : arrs) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}

		Integer[] result = map.keySet()
				.stream()
				.filter(k -> map.get(k) == 1)
				.toArray(Integer[]::new);

		System.out.println(Arrays.toString(result));
	}

	public void test2() {
		int[][] office = new int[][]{{5,-1,4}, {6,3,-1}, {2,-1,1}};
		int r = 1;
		int c = 0;
		String[] move = new String[]{"go","go","right","go","right","go","left","go"};

		int result = office[r][c];
		int direction = 0; //0:북 1:동 2:남 3:서

		for(String m : move) {
			switch (m) {
			case "go":
				if(direction == 0) {
					r = r-1 < office.length && r-1 >= 0? r= r-1 : r;
				}


				if(direction == 1) {
					c = c+1 < office.length && c+1 >= 0? c= c+1 : c;
				}

				if(direction == 2) {
					r = r+1 < office.length && r+1 >= 0? r= r+1 : r;
				}

				if(direction == 3) {
					c = c-1 < office.length && c-1 >= 0? c= c-1 : c;
				}

				result += (office[r][c] > 0? office[r][c] : 0);
				office[r][c] = 0;

				break;
			case "right":
				if(direction == 3) {
					direction = 0;
					break;
				}

				direction +=1;
				break;
			case "left":
				if(direction == 0) {
					direction = 3;
					break;
				}

				direction -=1;
				break;
			}
		}

		System.out.println(result);
	}

	public void test3() {
		String compressed = "2(3(hi)co)";
		String[] splitted = compressed.split("\\(|\\)");

		Stack<String> stack = new Stack<>();
		String temp = "";
		for(String s : splitted) {
			if(isDigit(s)) {
				stack.push(s);
				continue;
			}

			String val = stack.pop();
			temp += getString(s, Integer.valueOf(val));
		}

		System.out.println(temp);
	}

	private boolean isDigit(String s) {
		try {
			Integer.valueOf(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private String getString(String s, Integer cnt) {
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<cnt; i++){
			builder.append(s);
		}

		return builder.toString();
	}
}
