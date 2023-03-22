# 최소거리를 구하는 문제이므로 dfs보단 bfs가 효과적

import sys
from collections import deque as dq # 탐색 순서가 상관없으므로 굳이 큐를 사용 안해도 됐음

N,M=map(int,sys.stdin.readline().split())
Maze=[list(map(int,list(sys.stdin.readline().strip()))) for i in range(N)]
V=[[0]*M for i in range(N)]
V[0][0]=1 # 0,0에서 시작

Q1=dq([[0,0]])
Q2=dq([])
c=1 # 시작점과 Q1 안에 있는 칸의 최소 거리

end=0 # (N,M) 에 도착할 때가지
while 1:
    if end==1:
        break

    while Q1:
        # Q1의 원소는 시작점으로부터 같은 거리에 있는 칸
        # Q2의 원소는 Q1의 원소보다 한칸 더 멀리 있는 칸
        Q=Q1.popleft()
        x,y= Q[0], Q[1]

        if x==N-1 and y==M-1: # (N,M)에 도착
            end=1 # 바깥쪽 while문을 끝내기 위해
            break
        
        # 상하좌우 칸 중에 이동할 수 있고 방문한 적 없는 칸을 Q2에 입력
        if x<N-1 and Maze[x+1][y] and not V[x+1][y]:
            Q2.append([x+1,y])
            V[x+1][y]=1
        if y<M-1 and Maze[x][y+1] and not V[x][y+1]:
            Q2.append([x,y+1])
            V[x][y+1]=1
        if x>0 and Maze[x-1][y] and not V[x-1][y]:
            Q2.append([x-1,y])
            V[x-1][y]=1
        if y>0 and Maze[x][y-1] and not V[x][y-1]:
            Q2.append([x,y-1])
            V[x][y-1]=1

        # Q1을 모두 비웠으면 Q2를 Q1으로 바꾸고 다시 진행
        if not Q1:
            Q1=Q2
            Q2=dq([])
            c+=1

print(c)