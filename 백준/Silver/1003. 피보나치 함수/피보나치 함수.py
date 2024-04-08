# DP
# 피보나치 함수 값이 아닌 0과 1이 호출되는 횟수
# dp[0] = [1,0]
# dp[1] = [0,1]을 활용
res = []
tc = int(input())
for i in range(0, tc):
    n = int(input())
    # dp = list()
    # dp = [[0 for cols in range(2)]]
    dp = [[0 for cols in range(2)] for rows in range(n + 1)]

    if n == 0:
        res.append("1 0\n")
        # print("1 0", end="\n")
    elif n == 1:
        res.append("0 1\n")
        # print("0 1", end="")
    else:
        dp[0] = [1, 0]
        dp[1] = [0, 1]
        idx = 2
        while idx <= n:
            dp[idx] = [dp[idx - 2][a] + dp[idx - 1][a] for a in range(len(dp[0]))]
            # dp[idx] = [dp[idx - 1][k] + dp[idx - 2][k] for k in range(len(dp[idx - 1]))]
            idx += 1
        res.append(f"{dp[n][0]} {dp[n][1]}\n")
        # print(*dp[idx - 1], end="")
print(''.join(res), end="")
# 입출력 방법 바꿔야 함
