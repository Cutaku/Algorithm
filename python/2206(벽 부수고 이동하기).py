# bfs를 이용한 최단거리 탐색

import sys
from collections import deque as dq # 굳이 큐 사용 안해도 됐음

N,M=map(int,sys.stdin.readline().split())
map=[list(map(int,list(sys.stdin.readline().strip()))) for i in range(N)]
# 지나간 적 있는 칸을 V에 표시
# 지나간 적 없는 칸 = 2, 벽을 부수고 지나간 적 있는 칸 = 1, 벽을 부수지 않고 지나간 적 있는 칸 = 0
# 벽을 부수지 않고 지나간 적 있는 칸은 다시 지나갈 필요가 없지만 벽을 부수고 지나간 적 있는 칸은 벽을 부수지 않은 상태로 다시 지나갈 수 있음
# (앞으로 갈 수 있는 경로의 경우의 수가 많아지므로)
V=[[2]*M for i in range(N)]
V[0][0]=0
move=[[1,0],[0,1],[-1,0],[0,-1]] # 상하좌우로 이동
det=0 # (N,M)에 도달할 수 있는지를 판별
c=1 # 지나간 칸의 수

# 각 칸은 [세로, 가로, 벽을 부쉈는지 여부] 형태로 저장
q1=dq([[0,0,0]]) # 현재 시각에 위치할 수 있는 칸
q2=dq([])        # 다음 시각에 위치할 수 있는 칸

while q1:
    q=q1.popleft()
    if q[0]==N-1 and q[1]==M-1: # 목표점에 도달하면 정지
        det=1
        break

    for m in move:
        x=q[0]+m[0]
        y=q[1]+m[1]

        if 0<=x<N and 0<=y<M:                   
            if map[x][y]==0 and V[x][y]-q[2]>0: # map[x][y]=0인 경우(벽이 없는 경우)
                q2.append([x,y,q[2]])               # V[x][y]=2인 경우 -> q[2] 값에 상관 없이 이동 가능
                V[x][y]=q[2]                        # V[x][y]=1인 경우 -> q[2]=0 인경우(벽을 부순 적이 없는 경우)만 이동 가능
            elif map[x][y]==1 and q[2]==0:      # map[x][y]=1인 경우(벽이 있는 경우)
                q2.append([x,y,1])                  # 벽을 부순 적이 없는 경우만 이동 가능
                V[x][y]=0
    
    if not q1: # 현재 위치할 수 있는 칸에서 이동할 수 있는 칸을 모두 확인
        q1=q2  # q2를 q1으로 바꾸고 반복
        q2=dq([])
        c+=1

if det:
    print(c)
else:
    print(-1)