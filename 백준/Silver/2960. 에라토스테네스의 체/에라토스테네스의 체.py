# N보다 작거나 같은 모든 소수를 찾느낟
# 2부터 N까지 모든 정수를 적는다
# 지우지 않은 가장 작은 수 찾는다
# P = 소수
# P를 지우고, P의 배수를 순서대로 지운다
# 즉 2부터 시작하되 2 4 6 8 .. N 까지 지움
# 3이 가장 작은 수, 3 9  ...N 까지 지움
# 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
# 1 3 5 7 9 11 13 15
# 1 2 3 5 9 11 13 15만 남게 된다
n, k = map(int, input().split(" "))
li = list()

# 2부터 배열 생성
for i in range(2, n + 1):
    li.append(i)
# print(li)

cnt = 0
le = 0
for i in range(len(li)):
    if li[i] == 0:
        continue
    p = li[i]
    for j in range(i, len(li)):
        # if j == le:
        #     continue
        # if li[j] % p == 0:
        #     print("Li[j]", li[j])
        #     cnt += 1
        #     if cnt == k:
        #         print(li[j])
        #
        #     li.remove(li[j])
        #     le = len(li)
        ele = li[j]
        if li[j] % p == 0 and li[j] != 0:
            cnt += 1
            if cnt == k:
                print(li[j])
            li[j] = 0

# for loop 내에서 List 길이 줄어드므로 index 에러 발생함
