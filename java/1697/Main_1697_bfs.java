import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1697_bfs {

  static int N;
  static int K;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    K = Integer.parseInt(input[1]);
    visited = new boolean[Integer.max(K * 2, N + 1)];
    System.out.println(bfs(new Node(N, 0)));
  }

  public static int bfs(Node node) {
    visited[node.n] = true;
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      Node n = queue.poll();
      visited[n.n] = true;
      if (n.n == K) return n.level;
      if (n.n > 0 && !visited[n.n - 1]) queue.add(
        new Node(n.n - 1, n.level + 1)
      );
      if (n.n < K && !visited[n.n * 2]) queue.add(
        new Node(n.n * 2, n.level + 1)
      );
      if (n.n < K && !visited[n.n + 1]) queue.add(
        new Node(n.n + 1, n.level + 1)
      );
    }
    return 0;
  }

  public static class Node {

    public int n;
    public int level;

    public Node(int n, int level) {
      this.n = n;
      this.level = level;
    }
  }
}
