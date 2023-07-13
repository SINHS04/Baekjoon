import java.io.*;
import java.util.*;

public class Main_11724 {

  static int N;
  static int M;
  static ArrayList<ArrayList<Integer>> edge;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    edge = new ArrayList<>();
    for (int i = 0; i < N; ++i) {
      edge.add(new ArrayList<>());
    }
    visited = new boolean[N];
    int cnt = 0;

    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      edge.get(a).add(b);
      edge.get(b).add(a);
    }
    for (int i = 0; i < N; ++i) {
      if (!visited[i]) {
        visited[i] = true;
        dfs(i);
        ++cnt;
      }
    }
    System.out.println(cnt);
  }

  public static void dfs(int n) {
    for (int v : edge.get(n)) {
      if (!visited[v]) {
        visited[v] = true;
        dfs(v);
      }
    }
  }
}
