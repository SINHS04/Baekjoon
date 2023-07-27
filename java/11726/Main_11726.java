import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11726 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int a = 1;
    int b = 2;
    int c = 3;
    switch (n) {
      case 1:
        c = a;
        break;
      case 2:
        c = b;
        break;
      case 3:
        break;
      default:
        for (int i = 4; i <= n; ++i) {
          a = b;
          b = c;
          c = (a + b) % 10007;
        }
        break;
    }
    System.out.println(c);
  }
}
