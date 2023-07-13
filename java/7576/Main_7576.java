import java.io.*;
import java.util.*;

public class Main_7576 {

  static int M;
  static int N;
  static int[][] tomato;
  static int cnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    cnt = 0;
    tomato = new int[N + 2][M + 2];
    Queue<Node> queue = new LinkedList<>();
    for (int i = 0; i < N + 2; ++i) {
      for (int j = 0; j < M + 2; ++j) {
        tomato[i][j] = -1;
      }
    } 
    for (int i = 1; i < N + 1; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < M + 1; ++j) {
        tomato[i][j] = Integer.parseInt(st.nextToken());
        if (tomato[i][j] == 1) {
          queue.add(new Node(i, j, 0));
        } else if (tomato[i][j] == 0) {
          ++cnt;
        }
      }
    }
    System.out.println(bfs(queue));
  }

  public static int bfs(Queue<Node> queue) {
    int ret = 0;
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, -1, 0, 1 };
    while (!queue.isEmpty()) {
      Node n = queue.poll();
      ret = Integer.max(ret, n.level);
      for (int i = 0; i < 4; ++i) {
        int x = n.x + dx[i];
        int y = n.y + dy[i];
        if (tomato[x][y] == 0) {
          queue.add(new Node(x, y, n.level + 1));
          tomato[x][y] = 1;
          --cnt;
        }
      }
    }
    if (cnt == 0) {
      return ret;
    } else {
      return -1;
    }
  }

  public static class Node {

    int x;
    int y;
    int level;

    public Node(int x, int y, int level) {
      this.x = x;
      this.y = y;
      this.level = level;
    }
  }
}
