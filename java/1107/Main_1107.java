import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107 {

  static int N;
  static int num;
  static boolean[] button;
  static int curr;
  static int min;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    num = Integer.parseInt(br.readLine());
    curr = 100;
    min = Math.abs(N - curr);
    button = new boolean[10];
    if (num != 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      while (st.hasMoreTokens()) {
        button[Integer.parseInt(st.nextToken())] = true;
      }
    }
    if (N == curr) {
      min = 0;
    } else if (N < curr) {
      for (int i = 99; i >= 0; --i) {
        check(i);
      }
    } else {
      for (int i = 101; i < 999999; ++i) {
        check(i);
      }
    }
    System.out.println(min);
  }

  public static void check(int n) {
    String str = String.valueOf(n);
    boolean buttonPress = true;
    for (int j = 0; j < str.length(); ++j) {
      if (button[str.charAt(j) - '0']) {
        buttonPress = false;
        break;
      }
    }
    if (buttonPress) {
      min = Math.min(min, Math.abs(N - n) + str.length());
      return;
    }
  }
}
