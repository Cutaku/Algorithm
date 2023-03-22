import sys

n=int(sys.stdin.readline())
d=1000000007

# 행렬의 곱
def mat_mul(A,B):
    AB=[[0,0],[0,0]]
    for i in range(2):
        for j in range(2):
            for k in range(2):
                AB[i][j]=(AB[i][j]+A[i][k]*B[k][j])%d
    return AB

F,A=[[1,0],[0,0]], [[1,1],[1,0]]
n-=1

while n>0:
    if n%2==1:
        n-=1
        F=mat_mul(A,F)
    else:
        n=n//2
        A=mat_mul(A,A)

print(F[0][0])