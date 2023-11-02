import math

N = int(input())

square = [i**2 for i in range(1, int(math.sqrt(50_000)))]

# print(*square)


res = 0
glob_min = 1
for n in square:
    loc_min = 0
    res = n
    if res > N:
        break

    if res == N:
        loc_min = 1
        break

    for n in square:
        res += N
        if res > N:
            break

        if res == N:
            loc_min = 2
            break

        for n in square:
            res += N
            if res > N:
                break

            if res == N:
                loc_min = 3
                break

            for n in square:
                res += N
                if res > N:
                    break

                if res == N:
                    loc_min = 4
                    break

            glob_min = min(glob_min, loc_min)
        glob_min = min(glob_min, loc_min)
    glob_min = min(glob_min, loc_min)

print(glob_min)
