import sys
sys.setrecursionlimit(100000)
# BFS와 DFS를 활용
# 1) DFS 활용
# 가로 , 세로
tc = int(input())

di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]

def dfs(nowI, nowJ):
    graph[nowI][nowJ] = 0
    for d in range(4):
        nextI = nowI + di[d]
        nextJ = nowJ + dj[d]
        if nextI < 0 or nextI >= n or nextJ < 0 or nextJ >= m:
            continue
        if graph[nextI][nextJ] == 1:
            graph[nextI][nextJ] = 0
            dfs(nextI, nextJ)


for t in range(tc):
    m, n, k = map(int, input().split()) # 가로 : j , n : 세로
    graph = [[0] * m for _ in range(n)]

    answer = 0
    for i in range(k):
        y, x = map(int, input().split()) # x : m 가로, y : n 세로
        graph[x][y] = 1
    for nn in range(n):
        for mm in range(m):
            if(graph[nn][mm] == 1):
                dfs(nn, mm)
                answer += 1
    print(answer)
