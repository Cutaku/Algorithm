import sys

N,M=map(int, sys.stdin.readline().split())
A=[list(map(int,sys.stdin.readline().split())) for i in range(N)]

M,K=map(int, sys.stdin.readline().split())
B=[list(map(int,sys.stdin.readline().split())) for i in range(M)]

AB=[[0]*K for i in range(N)]
for i in range(N):
    for j in range(K):
        for k in range(M):
            AB[i][j]+=A[i][k]*B[k][j]

for row in AB:
    print(*row)