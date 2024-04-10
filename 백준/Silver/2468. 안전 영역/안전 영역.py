# 방문배열 또 초기화 안해줌
# 파이썬 재귀 메모리 초과

import sys

sys.setrecursionlimit(10 ** 4)

n = int(input())
g = list()
mx = list()
# 인접행렬 만들기
for i in range(n):
    row = list(map(int, input().split()))
    mx.append(max(row))
    g.append(row)
# print(g)

# g = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
# mx = [max(row) for row in g]
# print(g)
# print(mx)
maxVal = max(mx)

# 노드 최댓값
# maxVal = max(mx)
# print(maxVal)

start = 1

length = len(g)


def dfs(x, y, start):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    visit[x][y] = True

    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]

        if nx < 0 or ny < 0 or nx >= n or ny >= n:
            continue

        if g[nx][ny] > start and visit[nx][ny] == False:
            dfs(nx, ny, start)


# 비에 따른 각 안전 구역 Count 저장 리스트
area = list()

for start in range(1, maxVal):
    count = 0
    visit = [[False for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if g[i][j] > start and visit[i][j] == False:
                dfs(i, j, start)
                count += 1
                # print(visit)
    area.append(count)

if len(area) == 0:
    print("1")
else:
    print(max(area))
