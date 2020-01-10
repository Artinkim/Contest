import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Problem1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		boolean[][] arr2 = new boolean[N][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken()) - 1;
		}
		int count = 0;
		for (int j = 0; j < N; j++) {
			for (int n = j + 1; n < N; n++) {
				arr2[arr[0][j]][arr[0][n]] = true;
			}
		}
		for (int i = 1; i < K; i++) {
			for (int j = 0; j < N; j++) {
				for (int n = j + 1; n < N; n++) {
					if (arr2[arr[i][j]][arr[i][n]] == false) {
						arr2[arr[i][n]][arr[i][j]] = false;
					}
				}
			}
		}
		for (int j = 0; j < N; j++) {
			for (int n = 0; n < N; n++) {
				if (arr2[j][n] == true) {
					count++;
				}
			}
		}
		pw.println(count);
		pw.close();
	}
}
