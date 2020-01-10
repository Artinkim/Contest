import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Problem2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		int found = 0;
		int count = 9999999;
		boolean[] arr = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				found = 0;
				String temp = str.substring(i, j);
				for (int k = 0; k < N - temp.length()+1; k++) {
					if (str.substring(k, k + temp.length()).equals(temp)) {
						found++;
						if (found > 1)  {
							arr[temp.length()] = true;
							break;
						}
					}
				}
			}
		}
		for(int i = 1;i<N;i++) {
			if(!arr[i]) {
				pw.println(i);
				break;
			}
		}
		pw.close();
	}
}