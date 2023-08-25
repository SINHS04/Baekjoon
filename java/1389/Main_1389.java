import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1389 {

  static boolean[] visited;
  static ArrayList<ArrayList<Integer>> node;
  static int N;
  static int M;
  static int min;
  static int tmp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    node = new ArrayList<>();
    min = Integer.MAX_VALUE;
    int res = 0;
    for (int i = 0; i < N; ++i) {
      node.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      node.get(a).add(b);
      node.get(b).add(a);
    }
    for (int i = 0; i < N; ++i) {
      visited = new boolean[N];
      tmp = 0;
      dfs(i);
      if (tmp < min) {
        min = tmp;
        res = i;
      }
      System.out.println("");
    }
    System.out.println(min);
  }

  public static void dfs(int n) {
    visited[n] = true;
    System.out.println(n);
    for (int i : node.get(n)) {
      if (!visited[i]) {
        ++tmp;
        dfs(i);
      }
    }
  }
}
