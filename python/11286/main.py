import sys

n, m = map(int, input().split())

nameList = sys.stdin.read().splitlines()

hearset = set(nameList[:n])
seeset = set(nameList[n:])

res = list(hearset & seeset)
res.sort()

print(len(res))

for i in res:
    print(i)