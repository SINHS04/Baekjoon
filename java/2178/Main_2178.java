import java.io.*;
import java.util.*;

public class Main_2178 {

  static int N;
  static int M;
  static char[][] arr;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new char[N + 2][M + 2];
    visited = new boolean[N + 2][M + 2];
    for (int i = 0; i < M + 2; ++i) {
      arr[0][i] = '0';
      arr[N + 1][i] = '0';
      visited[0][i] = true;
      visited[N + 1][i] = true;
    }
    for (int i = 1; i < N + 1; ++i) {
      int j = 0;
      visited[i][j] = true;
      arr[i][j++] = '0';
      for (char c : br.readLine().toCharArray()) {
        arr[i][j] = c;
        if (arr[i][j] == '0') visited[i][j] = true;
        j++;
      }
      arr[i][j] = '0';
      visited[i][j] = true;
    }
    System.out.println(bfs(new Node(1, 1, 1)));
  }

  public static int bfs(Node node) {
    visited[node.x][node.y] = true;
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(node);
    while (!queue.isEmpty()) {
      Node n = queue.poll();
      if (!visited[n.x - 1][n.y]) {
        queue.add(new Node(n.x - 1, n.y, n.level + 1));
        visited[n.x - 1][n.y] = true;
      }
      if (!visited[n.x][n.y - 1]) {
        queue.add(new Node(n.x, n.y - 1, n.level + 1));
        visited[n.x][n.y - 1] = true;
      }
      if (!visited[n.x + 1][n.y]) {
        queue.add(new Node(n.x + 1, n.y, n.level + 1));
        visited[n.x + 1][n.y] = true;
      }
      if (!visited[n.x][n.y + 1]) {
        queue.add(new Node(n.x, n.y + 1, n.level + 1));
        visited[n.x][n.y + 1] = true;
      }
      if (n.x == N && n.y == M) return n.level;
    }
    return 0;
  }

  public static class Node {

    public int x;
    public int y;
    public int level;

    public Node(int x, int y, int level) {
      this.x = x;
      this.y = y;
      this.level = level;
    }
  }
}
