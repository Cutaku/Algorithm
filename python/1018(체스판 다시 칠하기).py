import sys

N,M=map(int,sys.stdin.readline().split())
Board=[list(sys.stdin.readline().strip()) for i in range(N)]
ans=N*M
WB=["W","B"]

for i in range(N):
    for j in range(M):
        Board[i][j]=(Board[i][j]==WB[(i+j)%2])

for i in range(N-7):
    for j in range(M-7):
        m=sum([sum(Board[k][j:j+8]) for k in range(i,i+8)])
        m=min(m,64-m)
        ans=min(ans,m)

print(ans)