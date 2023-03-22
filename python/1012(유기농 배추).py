# 2667(단지번호붙이기) 문제와 데이터 입력 방식만 다르고 완전하게 동일한 문제

import sys
sys.setrecursionlimit(10**6)

T=int(sys.stdin.readline())

def dfs(i,j):
    V[i][j]=1

    if i<M-1 and C[i+1][j] and not V[i+1][j]:
        dfs(i+1,j)
    if j<N-1 and C[i][j+1] and not V[i][j+1]:
        dfs(i,j+1)
    if 0<i and C[i-1][j] and not V[i-1][j]:
        dfs(i-1,j)
    if 0<j and C[i][j-1] and not V[i][j-1]:
        dfs(i,j-1)

for t in range(T):
    M,N,K=map(int,sys.stdin.readline().split())
    C=[[0]*N for i in range(M)]
    V=[[0]*N for i in range(M)]
    c=0
    
    for k in range(K):
        x,y=map(int,sys.stdin.readline().split())
        C[x][y]=1

    for i in range(M):
        for j in range(N):
            if C[i][j] and not V[i][j]:
                c+=1
                dfs(i,j)

    print(c)