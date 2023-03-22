# 7576(토마토) 문제에서 차원만 3차원으로 바꾼 문제
# 큐를 이용해 bfs 

import sys
from collections import deque as dq

M,N,H=map(int,sys.stdin.readline().split())
Tomato=[[list(map(int,sys.stdin.readline().split())) for n in range(N)] for h in range(H)]
# Tomato에 토마토가 익은 날짜를 입력(처음부터 익어있는 토마토가 1이므로 n일 후에는 n+1 입력)

Q=dq([]) # 익은 토마토의 위치와 익은 날짜를 입력
c1=0 # 익은 토마토의 수
c2=0 # 비어있는 칸 수

for h in range(H):
    for n in range(N):
        for m in range(M):
            if Tomato[h][n][m]==1:
                Q.append([h,n,m])
                c1+=1
            elif Tomato[h][n][m]==-1:
                c2+=1

move=[[1,0,0],[-1,0,0],[0,1,0],[0,-1,0],[0,0,1],[0,0,-1]]
ans=1

while Q:
    q=Q.popleft() # 익은 토마토
    v=Tomato[q[0]][q[1]][q[2]] # 토마토가 익은 날짜
    ans=max(ans,v) # 전부 익는데 며칠이 걸렸는지 구해야 하므로 가장 마지막에 익은 날짜를 구함

    for m in move:
        x=q[0]+m[0]
        y=q[1]+m[1]
        z=q[2]+m[2]

        if 0<=x<H and 0<=y<N and 0<=z<M and not Tomato[x][y][z]: # q와 인접하고 아직 익지 않은 토마토
            Tomato[x][y][z]=v+1 # q 다음날 익음
            c1+=1
            Q.append([x,y,z])
    

if c1==H*N*M-c2:
    print(ans-1)
else:
    print(-1)