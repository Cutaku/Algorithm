import sys

N,B=map(int,sys.stdin.readline().split())
A=[list(map(int,sys.stdin.readline().split())) for i in range(N)]

# 행렬의 곱셈
def mat_mul(A,B):
    global N
    AB=[[0]*N for i in range(N)]

    for i in range(N):
        for j in range(N):
            for k in range(N):
                AB[i][j]=(AB[i][j]+A[i][k]*B[k][j])%1000
     
    return AB

# 수의 거듭제곱을 구하는 방법과 동일
ans=[[0]*i+[1]+[0]*(N-i-1) for i in range(N)] # 단위행렬
while B>0:
    if B%2==1:
        B-=1
        ans=mat_mul(A,ans)

    else:
        B=B//2
        A=mat_mul(A,A)

for row in ans:
    print(*row)