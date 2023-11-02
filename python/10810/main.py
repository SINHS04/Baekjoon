import sys

N, M = map(int, sys.stdin.readline().split())
lines = [list(map(int, sys.stdin.readline().split())) for _ in range(M)]

res = [0] * N

for line in lines:
    for i in range(line[0] - 1, line[1]):
        res[i] = line[2]

print(*res)
