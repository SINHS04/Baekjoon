import java.io.*;
import java.util.*;

public class Main_1260 {

  static int N;
  static int M;
  static int V;
  static ArrayList<ArrayList<Integer>> edge;
  static boolean[] visited;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());
    edge = new ArrayList<>();
    visited = new boolean[N];
    sb = new StringBuilder();
    for (int i = 0; i < N; ++i) {
      edge.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      edge.get(a).add(b);
      edge.get(b).add(a);
    }
    for (int i = 0; i < N; ++i) {
      Collections.sort(edge.get(i));
    }
    dfs(V - 1);
    sb.append('\n');

    visited = new boolean[N];
    bfs(V - 1);
    System.out.println(sb);
  }

  public static void dfs(int num) {
    visited[num] = true;
    sb.append(num + 1).append(' ');
    for (int n : edge.get(num)) {
      if (!visited[n]) dfs(n);
    }
  }

  public static void bfs(int num) {
    visited[num] = true;
    sb.append(num + 1).append(' ');
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(num);
    while (!queue.isEmpty()) {
      int u = queue.poll();
      for (int n : edge.get(u)) {
        if (!visited[n]) {
          visited[n] = true;
          sb.append(n + 1).append(' ');
          queue.add(n);
        }
      }
    }
  }
}
