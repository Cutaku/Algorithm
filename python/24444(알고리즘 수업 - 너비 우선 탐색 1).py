# bfs 문제

import sys
from collections import deque as dq

N,M,R=map(int,sys.stdin.readline().split())
E=[[] for _ in range(N+1)] # 각 vertex에서 방문 가능한 vertex set

for _ in range(M):
    v1,v2=map(int,sys.stdin.readline().split())
    E[v1].append(v2) # 무방향 그래프이므로 양쪽 vertex에 추가
    E[v2].append(v1)

for i in range(1,N+1):
    E[i].sort(reverse=True) # 오름차순 방문이므로 (오른쪽부터) 오름차순이 되게 정렬

V=[0]*(N+1) # 방문 여부 및 방문 순서를 기록
V[R]=1
c=1 # 방문 순서

Q=dq([R]) # 큐를 이용해 방문 순서대로 처리

while Q:
    v=Q.popleft()
    while E[v]:
        w=E[v].pop()
        if not V[w]:
            c+=1
            V[w]=c
            Q.append(w)

for i in range(1,N+1):
    print(V[i])