import sys

T=int(sys.stdin.readline())

A=[[0]*15 for i in range(15)]
A[0]=list(range(15))
for i in range(1,15):
    for j in range(1,15):
        A[i][j]=A[i][j-1]+A[i-1][j]

for t in range(T):
    k,n=int(sys.stdin.readline()),int(sys.stdin.readline())
    print(A[k][n])