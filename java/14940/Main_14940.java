import java.io.*;
import java.util.*;

public class Main_14940 {

  static int n, m;
  static int[][] map;
  static int[] dx = { 1, 0, -1, 0 };
  static int[] dy = { 0, 1, 0, -1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    int x = 0, y = 0;
    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 2) {
          x = i;
          y = j;
          map[i][j] = 0;
        }
      }
    }
    bfs(new Node(x, y));

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (map[i][j] == 1) map[i][j] = -1;
      }
    }

    for (int i = 0; i < 4; ++i) {
      int a = x + dx[i];
      int b = y + dy[i];
      if (!(a < 0 || b < 0 || a >= n || b >= m) && map[a][b] != 0) {
        map[a][b] = 1;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        sb.append(map[i][j]).append(' ');
      }
      sb.append('\n');
    }
    System.out.println(sb);
  }

  public static void bfs(Node node) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      Node currNode = queue.poll();

      for (int i = 0; i < 4; ++i) {
        int x = currNode.x + dx[i];
        int y = currNode.y + dy[i];
        if (!(x < 0 || y < 0 || x >= n || y >= m) && map[x][y] == 1) {
          queue.add(new Node(x, y));
          map[x][y] = map[currNode.x][currNode.y] + 1;
        }
      }
    }
  }

  public static class Node {

    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
