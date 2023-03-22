# dfs 문제
# 처음엔 재귀함수로 구현했으나 recursionerror 발생 -> 스택을 이용해 구현

import sys

N,M,R=map(int,sys.stdin.readline().split())
E=[[] for _ in range(N+1)] # 각 vertex에서 이동할 수 있는 vertex들

for _ in range(M):
    v1,v2=map(int,sys.stdin.readline().split())
    E[v1].append(v2) # 양방향 이동 가능이므로 두 vertex에 모두 추가
    E[v2].append(v1)

for i in range(1,N+1):
    E[i].sort(reverse=True) # 오름차순으로 방문해야하므로 낮은 수를 먼저 꺼내기 위해 역순으로 정렬

V=[0]*(N+1) # 방문 여부 및 방문 순서를 기록
V[R]=1
c=1
stack=[R] # 방문경로

while stack:
    v=stack[-1] # 스택의 마지막 수 = 현재 위치
    
    if E[v]: # 방문할 수 있는 vertex 존재
        v2=E[v].pop()
        if not V[v2]: # 그 vertex가 방문한 적 없는 경우
            c+=1
            stack.append(v2)
            V[v2]=c
    else: # 방문할 수 있는 vertex가 존재 x
        stack.pop()

for i in range(1,N+1):
    print(V[i])