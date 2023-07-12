import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_2667 {

  static boolean[][] house;
  static ArrayList<Integer> res;
  static int cnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    house = new boolean[N + 2][N + 2];
    res = new ArrayList<>();
    for (int i = 1; i < N + 1; ++i) {
      int j = 1;
      for (char c : br.readLine().toCharArray()) {
        house[i][j++] = c == '1';
      }
    }
    for (int i = 1; i < N + 1; ++i) {
      for (int j = 1; j < N + 1; ++j) {
        cnt = 0;
        if (house[i][j]) {
          dfs(i, j);
          res.add(cnt);
        }
      }
    }
    Collections.sort(res);
    StringBuilder sb = new StringBuilder();
    sb.append(res.size());
    for (int a : res) {
      sb.append('\n').append(a);
    }
    System.out.println(sb);
  }

  public static void dfs(int x, int y) {
    house[x][y] = false;
    ++cnt;
    if (house[x - 1][y]) dfs(x - 1, y);
    if (house[x][y - 1]) dfs(x, y - 1);
    if (house[x + 1][y]) dfs(x + 1, y);
    if (house[x][y + 1]) dfs(x, y + 1);
  }
}
