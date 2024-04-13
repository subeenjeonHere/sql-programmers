def selectionSort(li):
    for i in range(0, len(li)):
        min_idx = i
        for j in range(i + 1, len(li)):
            if li[j] > li[min_idx]:
                min_idx = j
        li[i], li[min_idx] = li[min_idx], li[i]


li = list(map(int, input()))
selectionSort(li)

# print a list without brackets

for i in li:
    print(i, end='')
