## Title
### 2 x n 타일링
- Link : [Baekjoon 11726](https://www.acmicpc.net/problem/11726)

### Problem
2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.
![Alt text](image.png)

### Input
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

### Output
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

### Solution
- Fibonacci 수열
- F(x) = F(x-1) + F(x-2), (F(0) = 1, F(1) = 2)