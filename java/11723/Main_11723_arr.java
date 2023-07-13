import java.io.*;
import java.util.*;

public class Main_11723_arr {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int M = Integer.parseInt(br.readLine());
    boolean[] set = new boolean[21];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; ++i) {
      String[] str = br.readLine().split(" ");
      if (str[0].equals("all") || str[0].equals("empty")) {
        switch (str[0]) {
          case "all":
            Arrays.fill(set, 0, 21, true);
            break;
          default:
            set = new boolean[21];
            break;
        }
      } else {
        int n = Integer.parseInt(str[1]);
        switch (str[0]) {
          case "add":
            set[n] = true;
            break;
          case "remove":
            set[n] = false;
            break;
          case "check":
            sb.append(set[n] ? 1 : 0).append('\n');
            break;
          case "toggle":
            set[n] = !set[n];
            break;
        }
      }
    }
    System.out.println(sb);
  }
}
