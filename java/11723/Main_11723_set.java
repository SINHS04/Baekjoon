import java.io.*;
import java.util.*;

public class Main_11723_set {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int M = Integer.parseInt(br.readLine());
    Set<String> set = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; ++i) {
      String[] str = br.readLine().split(" ");
      switch (str[0]) {
        case "add":
          set.add(str[1]);
          break;
        case "remove":
          set.remove(str[1]);
          break;
        case "check":
          sb.append(set.contains(str[1]) ? 1 : 0).append('\n');
          break;
        case "toggle":
          if (set.contains(str[1])) {
            set.remove(str[1]);
          } else {
            set.add(str[1]);
          }
          break;
        case "all":
          for (int j = 1; j < 21; ++j) {
            set.add(String.valueOf(j));
          }
          break;
        default:
          set.clear();
          break;
      }
    }
    System.out.println(sb);
  }
}
