import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2606 {

  static int N;
  static int M;
  static ArrayList<ArrayList<Integer>> edge;
  static boolean[] visited;
  static int cnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    edge = new ArrayList<>();
    for (int i = 0; i < N; ++i) {
      edge.add(new ArrayList<>());
    }
    visited = new boolean[N];
    cnt = 0;
    for (int i = 0; i < M; ++i) {
      int[] arr = new int[2];
      int j = 0;
      for (String str : br.readLine().split(" ")) {
        arr[j++] = Integer.parseInt(str) - 1;
      }
      edge.get(arr[0]).add(arr[1]);
      edge.get(arr[1]).add(arr[0]);
    }
    dfs(0);
    System.out.println(cnt - 1);
  }

  public static void dfs(int n) {
    visited[n] = true;
    ++cnt;
    // System.out.println(n + 1);
    for (int v : edge.get(n)) {
      if (!visited[v]) dfs(v);
    }
  }
}
