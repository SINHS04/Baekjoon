import java.io.*;
import java.util.*;

public class Main_7569 {

  static int M;
  static int N;
  static int H;
  static int[][][] tomato;
  static int cnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    cnt = 0;
    tomato = new int[N + 2][M + 2][H + 2];
    Queue<Node> queue = new LinkedList<>();
    for (int i = 0; i < N + 2; ++i) {
      for (int j = 0; j < M + 2; ++j) {
        for (int k = 0; k < H + 2; ++k) {
          tomato[i][j][k] = -1;
        }
      }
    }
    for (int k = 1; k < H + 1; ++k) {
      for (int i = 1; i < N + 1; ++i) {
        st = new StringTokenizer(br.readLine());
        for (int j = 1; j < M + 1; ++j) {
          tomato[i][j][k] = Integer.parseInt(st.nextToken());
          if (tomato[i][j][k] == 1) {
            queue.add(new Node(i, j, k, 0));
          } else if (tomato[i][j][k] == 0) {
            ++cnt;
          }
        }
      }
    }
    System.out.println(bfs(queue));
  }

  public static int bfs(Queue<Node> queue) {
    int ret = 0;
    int[] dx = { -1, 0, 1, 0, 0, 0 };
    int[] dy = { 0, -1, 0, 1, 0, 0 };
    int[] dz = { 0, 0, 0, 0, -1, 1 };
    while (!queue.isEmpty()) {
      Node n = queue.poll();
      ret = Integer.max(ret, n.level);
      for (int i = 0; i < 6; ++i) {
        int x = n.x + dx[i];
        int y = n.y + dy[i];
        int z = n.z + dz[i];
        if (tomato[x][y][z] == 0) {
          queue.add(new Node(x, y, z, n.level + 1));
          tomato[x][y][z] = 1;
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
    int z;
    int level;

    public Node(int x, int y, int z, int level) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.level = level;
    }
  }
}
