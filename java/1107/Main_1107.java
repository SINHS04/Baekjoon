import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107 {

  static int N;
  static int num;
  static int[] button;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    num = Integer.parseInt(br.readLine());
    if (num != 0) {
      button = new int[num];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < num; ++i) {
        button[i] = Integer.parseInt(st.nextToken());
      }
    }
  }
}
