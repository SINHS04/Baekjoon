import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1697_dp {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int K = Integer.parseInt(input[1]);
    int size = 100000;
    int[] dp = new int[size + 1];
    for (int i = 0; i <= size; ++i) {
      if (i <= N) {
        dp[i] = N - i;
      } else if (i % 2 == 0) {
        dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
      } else {
        dp[i] = Math.min(dp[i - 1], dp[Math.min(i + 1, size)]) + 1;
      }

      if (i != 0 && i * 2 <= size) {
        dp[i * 2] = dp[i] + 1;
      }
    }
    System.out.println(dp[K]);
  }
}
