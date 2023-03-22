from collections import deque as dq
import sys

N,M,V=map(int,sys.stdin.readline().split())
E=[[] for i in range(N+1)] # edges

for m in range(M): # 간선이 양방향이므로 양쪽에 모두 추가
    v1,v2=map(int,sys.stdin.readline().split())
    E[v1].append(v2)
    E[v2].append(v1)

for n in range(N+1):
    E[n].sort() # 번호가 낮은 순으로 방문하므로 오름차순 정렬


def dfs(V): # 깊이 우선 탐색
    visited[V]=True # 방문한 정점을 표시
    ans.append(V) # 방문한 정점을 순서대로 기록
    
    for i in E[V]: # 현재 위치한 정점에서 이동할 수 있는 점
        if not visited[i]:
            dfs(i)

def bfs(V): # 너비 우선 탐색
    Q=dq([V]) # 큐를 이용해 시작점에서 위치가 가까운 순서대로 방문
    visited[V]=True

    while Q: # (연결된) 모든 점을 방문할 때까지
        q=Q.popleft() # 먼저 입력된 순서(가까운 순서)대로 방문
        ans.append(q)
        for i in E[q]: # 현재 위치에서 이동할 수 있는 점
            if not visited[i]:
                Q.append(i)
                visited[i]=True


visited=[False]*(N+1)
ans=[]
dfs(V)
print(*ans)

visited=[False]*(N+1)
ans=[]
bfs(V)
print(*ans)