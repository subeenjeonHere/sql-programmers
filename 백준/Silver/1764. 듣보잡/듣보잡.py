# 듣 n 보 m
# 리스트 생성 n+m
# 듣도 못 한 사람 입력받기
# 듣도 못 한사람 Find 한다면 res 리스트에 추가
# 리스트 길이와 오름차순 정렬
import collections

res = []
n, m = map(int, input().split(" "))

li1 = list()
li2 = list()

for i in range(0, n + m):
    s = input()
    if i < n:
        li1.append(s)
    else:
        li2.append(s)
set1 = set(li1)
set2 = set(li2)
intersected_set = set1.intersection(set2)
intersected_list = list(intersected_set)

intersected_list.sort()
print(len(intersected_list))
for i in range(len(intersected_list)):
    print(intersected_list[i])
