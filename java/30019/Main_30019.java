import java.io.*;
import java.util.*;

public class Main_30019 {

  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String[] str = br.readLine().split(" ");
    N = Integer.parseInt(str[0]);
    M = Integer.parseInt(str[1]);
    int[] last = new int[N];

    for (int i = 0; i < M; ++i) {
      str = br.readLine().split(" ");
      int k = Integer.parseInt(str[0]) - 1;
      int s = Integer.parseInt(str[1]);
      int e = Integer.parseInt(str[2]);
      if (last[k] <= s) {
        sb.append("YES");
        last[k] = e;
      } else {
        sb.append("NO");
      }
      sb.append('\n');
    }
    System.out.println(sb);
  }
}
