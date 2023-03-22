# 24444 문제와 동일
# 방문 순서만 반대이므로 정렬을 반대로

import sys
from collections import deque as dq

N,M,R=map(int,sys.stdin.readline().split())
E=[[] for _ in range(N+1)]

for _ in range(M):
    v1,v2=map(int,sys.stdin.readline().split())
    E[v1].append(v2)
    E[v2].append(v1)

for i in range(1,N+1):
    E[i].sort(reverse=True)

V=[0]*(N+1)
V[R]=1
c=1

Q=dq([R])

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