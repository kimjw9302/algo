from collections import deque

tc = int(input())
def bfs(x, y):
    queue, visited = deque(), []
    queue.append([x, y, 20])
    visited.append([x, y, 20])
    while queue:
        x1, y1, beer = queue.popleft()
        if x1 == end[0] and y1 == end[1]:
            print("happy")
            return
        for nx, ny in d:

            if [nx, ny, 20] not in visited:
                l1 = abs(nx - x1) + abs(ny - y1)
                if beer*50 >= l1:
                    queue.append([nx, ny, 20])
                    visited.append([nx, ny, 20])
    print("sad")
    return
for _ in range(tc):
    n = int(input())

    start = list(map(int, input().split()))
    d = []
    for _ in range(n):
        x, y = map(int, input().split())
        d.append([x, y])
    end = list(map(int, input().split()))
    d.append(end)
    bfs(start[0], start[1])
