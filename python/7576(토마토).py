import sys

M,N=map(int,sys.stdin.readline().split())
Tomato=[list(map(int,sys.stdin.readline().split())) for i in range(N)]
V=[[0]*M for i in range(N)] # 이미 익은 토마토 -> 굳이 따로 만들지 않고 Tomato 리스트를 바꾸면서 해도 괜찮았을듯
c1=0 # 익은 토마토의 수
c2=0 # 비어있는 칸 수
c3=0 # 날짜


q1=[] # 각 날짜에 익은 토마토
q2=[] # 다음 날짜에 익을 토마토
for i in range(N):
    for j in range(M):
        if Tomato[i][j]==1:
            q1.append([i,j])
            V[i][j]=1
            c1+=1
        elif Tomato[i][j]==-1:
            V[i][j]=1
            c2+=1

move=[[1,0],[0,1],[-1,0],[0,-1]] # 상하좌우 인접한 칸
while q1: # 마지막 날 익은 토마토와 인접한 익지 않은 토마토가 없으므로 익을 수 있는 토마토가 모두 익은 상태
    q=q1.pop()

    for m in move:
        x=q[0]+m[0]
        y=q[1]+m[1]

        if 0<=x<N and 0<=y<M and Tomato[x][y]==0 and not V[x][y]: # 갓 익은 토마토와 인접해있고 아직 익지 않은 토마토
            q2.append([x,y])
            V[x][y]=1
            c1+=1

    # not q1 -> 각 날짜에 익은 토마토와 인접한 익지 않은 토마토를 모두 Q2에 입력한 상태
    # q2 -> 다음날 익을 토마토가 존재
    if q2 and not q1:
        q1=q2
        q2=[]
        c3+=1

if c1==N*M-c2: # 비어있는 칸을 제외하고 모두 익었을 경우
    print(c3)
else: # 마지막까지 익지 않은 토마토가 존재할 경우
    print(-1)