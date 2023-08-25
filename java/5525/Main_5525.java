import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_5525 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    StringBuilder S = new StringBuilder(br.readLine());
    char[] str = { 'I', 'O', 'I' };
    int answer = 0;
    int count = 0;
    char[] arr = new char[3];
    for (int i = 0; i < M - 2; ++i) {
      S.getChars(i, i + 3, arr, 0);
      if (Arrays.equals(str, arr)) {
        ++i;
        ++count;
        if (count == N) {
          ++answer;
          --count;
        }
      } else {
        count = 0;
      }
    }
    System.out.println(answer);
  }
}
