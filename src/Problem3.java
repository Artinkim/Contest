import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem3 {
	public static void main(String[] args) throws IOException {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Beatrice", 0);
		map.put("Belinda", 1);
		map.put("Bella", 2);
		map.put("Bessie", 3);
		map.put("Betsy", 4);
		map.put("Blue", 5);
		map.put("Buttercup", 6);
		map.put("Sue", 7);
		HashMap<Integer, String> map2 = new HashMap<Integer, String>();
		map2.put(0, "Beatrice");
		map2.put(1, "Belinda");
		map2.put(2, "Bella");
		map2.put(3, "Bessie");
		map2.put(4, "Betsy");
		map2.put(5, "Blue");
		map2.put(6, "Buttercup");
		map2.put(7, "Sue");
		BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] arr = new ArrayList[8];
		String[] strings = { "0", "1", "2", "3", "4", "5", "6", "7" };
		for (int i = 0; i < 8; i++)
			arr[i] = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int temp1 = map.get(st.nextToken());
			st.nextToken();
			st.nextToken();
			st.nextToken();
			st.nextToken();
			int temp2 = map.get(st.nextToken());
			if (temp1 < temp2) {
				arr[temp1].add(temp2);
			} else {
				arr[temp2].add(temp1);
			}
		}

		for (int i = 0; i < 8; i++) {
			System.out.println(strings[i]);
			if (strings[i].equals("")) {
				for (int j = i - 1; j > -1; j--) {
					if (strings[j].equals(""))
						continue;
					for (int n = 0; n < strings[j].length(); n++) {
						if (arr[i].size() > 0) {
							if (strings[j].substring(n, n + 1).equals(arr[i].get(0) + "")) {
								if (strings[arr[i].get(0)].equals("")) {
									for (int j2 = i - 1; j2 > -1; j2--) {
										for (int n2 = 0; n2 < strings[i].length(); n2++) {
											if (strings[i].substring(n2, n2 + 1).equals(strings[arr[i].get(0)] + "")) {
												strings[i] = strings[j]
														+ strings[j2].substring(strings[j2].length() - 1)
														+ strings[j2].substring(0, strings[j2].length() - 1);
												strings[j] = "";
												strings[j2] = "";
											}
										}
									}
								} else {
									if (n == 0) {
										strings[j] = arr[i].get(0) + strings[j];
									} else {
										strings[j] += arr[i].get(0) + "";
									}
									strings[arr[i].get(0)] = "";
								}
							}
						}
					}
				}
			} else if (strings[arr[i].get(0)].equals("")) {
				for (int j = i - 1; j > -1; j--) {
					if (strings[j].equals(""))
						continue;
					for (int n = 0; n < strings[j].length(); n++) {
						if (arr[i].size() > 0) {
							if (strings[j].substring(n, n + 1).equals(i + "")) {

								if (n == 0) {
									strings[j] = i + strings[j];
								} else {
									strings[j] += i + "";
								}
								strings[i] = "";
							}
						}
					}
				}
			} else {

				if (arr[i].size() == 1) {
					strings[i] += arr[i].get(0) + "";
					strings[arr[i].get(0)] = "";
				} else if (arr[i].size() == 2) {
					if (arr[i].get(0) > arr[i].get(1)) {
						strings[i] = arr[i].get(1) + strings[i] + arr[i].get(0) + "";
					} else {
						strings[i] = arr[i].get(0) + strings[i] + "" + arr[i].get(1);
					}
					strings[arr[i].get(0)] = "";
					strings[arr[i].get(1)] = "";
				}
			}
		}
		Arrays.sort(strings);

		String answer = "";
		for (int i = 0; i < 8; i++) {
			answer += strings[i];
			System.out.println(strings[i]);
		}
		System.out.println(answer);
		for (int i = 0; i < 8; i++) {
			pw.println(map2.get(Integer.parseInt(answer.substring(i, i + 1))));
		}
		pw.close();
	}
}