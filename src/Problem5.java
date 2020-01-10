import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem5 {
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
		Queue<String> queue = new LinkedList<String>();
		boolean[] used = new boolean[8];
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
		for(int a = 0;a<8;a++) {
			used[a] = true;
			for(int b = 0;b<8;b++) {
				if(used[b]) {
					continue;
				} else {
					used[b] = true;
				}	
				for(int c = 0;c<8;c++) {
					if(used[c]) {
						continue;
					} else {
						used[c] = true;
					}
					for(int d = 0;d<8;d++) {
						if(used[d]) {
							continue;
						} else {
							used[d] = true;
						}
						for(int e = 0;e<8;e++) {
							if(used[e]) {
								continue;
							} else {
								used[e] = true;
							}
							for(int f = 0;f<8;f++) {
								if(used[f]) {
									continue;
								} else {
									used[f] = true;
								}
								for(int g = 0;g<8;g++) {
									if(used[g]) {
										continue;
									} else {
										used[g] = true;
									}
									queue.add(a+b+c+d+e+f+g+h);
									}
								}
							}
						}
					}
					
				}
			}
		}
	}
}
