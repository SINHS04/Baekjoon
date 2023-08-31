import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_17219 {

  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String[] str = br.readLine().split(" ");
    N = Integer.parseInt(str[0]);
    M = Integer.parseInt(str[1]);
    HashMap<String, String> map = new HashMap<>(N / 7 * 10);

    for (int i = 0; i < N; ++i) {
      str = br.readLine().split(" ");
      map.put(str[0], str[1]);
    }

    for (int i = 0; i < M; ++i) {
      sb.append(map.get(br.readLine())).append('\n');
    }
    System.out.println(sb);
  }
}
