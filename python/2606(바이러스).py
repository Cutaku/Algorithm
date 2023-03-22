# bfs를 이용한 풀이 -> 1260(DFS와 BFS) 문제와 동일한 로직

from collections import deque as dq
import sys

N=int(sys.stdin.readline())
M=int(sys.stdin.readline())
E=[[] for i in range(N+1)]

for m in range(M):
    v1, v2=map(int,sys.stdin.readline().split())
    E[v1].append(v2)
    E[v2].append(v1)

visited=[0]*(N+1)
Q=dq([1])
visited[1]=1
count=0

while Q:
    q=Q.popleft()
    for i in E[q]:
        if not visited[i]:
            Q.append(i)
            visited[i]=1
            count+=1

print(count)