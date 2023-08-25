## Title
### IOIOI
- Link : [Baekjoon 5525](https://www.acmicpc.net/problem/5525)

### Problem
N+1개의 I와 N개의 O로 이루어져 있으면, I와 O이 교대로 나오는 문자열을 PN이라고 한다.

P1 IOI
P2 IOIOI
P3 IOIOIOI
PN IOIOI...OI (O가 N개)
I와 O로만 이루어진 문자열 S와 정수 N이 주어졌을 때, S안에 PN이 몇 군데 포함되어 있는지 구하는 프로그램을 작성하시오.

### Input
첫째 줄에 N이 주어진다. 둘째 줄에는 S의 길이 M이 주어지며, 셋째 줄에 S가 주어진다.

### Output
- S에 PN이 몇 군데 포함되어 있는지 출력한다.
 - 1 ≤ N ≤ 1,000,000
 - 2N+1 ≤ M ≤ 1,000,000
 - S는 I와 O로만 이루어져 있다.

### Solution
- 모든 경우의 수 탐색
- 순차적으로 나아가며 연속된 IOI를 찾고, 특정 길이를 넘어가게 되면 정답 1 증가