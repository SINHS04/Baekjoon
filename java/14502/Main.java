import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static int M;
  static int[][] map;
  static int cnt;
  static Queue<Integer> queue;
  static int[] dx = { 0, 1, 0, -1 };
  static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    int max = Integer.MIN_VALUE;
    ArrayList<Integer> blank = new ArrayList<>();
    ArrayList<Integer> virus = new ArrayList<>();
    queue = new LinkedList<>();

    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 0) blank.add(i * M + j);
        if (map[i][j] == 2) virus.add(i * M + j);
      }
    }

    for (int i = 0; i < blank.size() - 2; ++i) {
      map[blank.get(i) / M][blank.get(i) % M] = 1;
      for (int j = i + 1; j < blank.size() - 1; ++j) {
        map[blank.get(j) / M][blank.get(j) % M] = 1;
        for (int k = j + 1; k < blank.size(); ++k) {
          map[blank.get(k) / M][blank.get(k) % M] = 1;
          cnt = blank.size() - 3;

          for (int t : virus) {
            dfs(t / M, t % M);
          }

          max = Integer.max(cnt, max);

          while (!queue.isEmpty()) {
            int tmp = queue.poll();
            map[tmp / M][tmp % M] = 0;
          }
          map[blank.get(k) / M][blank.get(k) % M] = 0;
        }
        map[blank.get(j) / M][blank.get(j) % M] = 0;
      }
      map[blank.get(i) / M][blank.get(i) % M] = 0;
    }

    System.out.println(max);
  }

  public static void dfs(int a, int b) {
    map[a][b] = 2;

    for (int i = 0; i < 4; ++i) {
      int x = dx[i] + a;
      int y = dy[i] + b;

      if (!(x < 0 || y < 0 || x >= N || y >= M) && map[x][y] == 0) {
        queue.add(x * M + y);
        --cnt;
        dfs(x, y);
      }
    }
  }
}
