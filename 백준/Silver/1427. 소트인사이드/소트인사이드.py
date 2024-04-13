def insertion_sort(li):
    n = len(li)  # Get the length of the list
    if n <= 1:
        return
    for i in range(1, n):
        key = li[i]
        j = i - 1
        while j >= 0 and key > li[j]:
            li[j + 1] = li[j]
            j -= 1
        li[j + 1] = key


li = list(map(int, input()))
insertion_sort(li)

for i in li:
    print(i, end='')
