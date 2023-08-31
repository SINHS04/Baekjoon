import java.io.*;
import java.util.*;

public class Main_1389 {

  static ArrayList<Integer>[] graph;
  static int N;
  static int M;
  static int min;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    graph = new ArrayList[N];
    min = Integer.MAX_VALUE;
    int res = 0;

    for (int i = 0; i < N; ++i) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      graph[a].add(b);
      graph[b].add(a);
    }
    // int tmp = dijkstra(1);
    for (int i = 0; i < N; ++i) {
      int dij = dijkstra(i);
      if (dij < min) {
        min = dij;
        res = i;
      }
    }
    System.out.println(res + 1);
  }

  public static int dijkstra(int n) {
    int res = 0;
    int[] weight = new int[N];
    boolean[] visited = new boolean[N];
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < N; ++i) {
      weight[i] = Integer.MAX_VALUE;
    }

    queue.add(n);
    weight[n] = 0;
    while (!queue.isEmpty()) {
      int tmp = queue.poll();
      if (!visited[tmp]) {
        visited[tmp] = true;
        for (int i : graph[tmp]) {
          if (!visited[i] && weight[tmp] + 1 < weight[i]) {
            weight[i] = weight[tmp] + 1;
          }
          queue.add(i);
        }
      }
    }

    for (int i = 0; i < N; ++i) {
      // System.out.println(weight[i]);
      res += weight[i];
    }
    return res;
  }
}
