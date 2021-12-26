from collections import deque

tc = int(input()) # 테케


di = [-2, -1, 1, 2, 2, 1, -1, -2]
dj = [1, 2, 2, 1, -1, -2, -2, -1]

for _ in range(tc):
    n = int(input())
    visited = [[0] * n for _ in range(n)]
    answer = 0
    nowI, nowJ = map(int, input().split()) # 목표
    targetI, targetJ = map(int, input().split()) # 목표
    queue = deque()
    queue.append((nowI, nowJ))
    while queue:
        i, j = queue.popleft()
        if i == targetI and j == targetJ:
            break
        for d in range(8):
            nextI = i + di[d]
            nextJ = j + dj[d]
            if nextI < 0 or nextI >= n or nextJ < 0 or nextJ >= n:
                continue
            if visited[nextI][nextJ] == 0:
                queue.append((nextI, nextJ))
                visited[nextI][nextJ] = visited[i][j] + 1
    print(visited[targetI][targetJ])
