# 24479 문제와 동일
# 방문 순서만 반대이므로 정렬시 반대로 정렬

import sys

N,M,R=map(int,sys.stdin.readline().split())
E=[[] for _ in range(N+1)]

for _ in range(M):
    v1,v2=map(int,sys.stdin.readline().split())
    E[v1].append(v2)
    E[v2].append(v1)

for i in range(1,N+1):
    E[i].sort()

V=[0]*(N+1)
V[R]=1
c=1
stack=[R]

while stack:
    v=stack[-1]
    
    if E[v]:
        v2=E[v].pop()
        if not V[v2]:
            c+=1
            stack.append(v2)
            V[v2]=c
    else:
        stack.pop()

for i in range(1,N+1):
    print(V[i])