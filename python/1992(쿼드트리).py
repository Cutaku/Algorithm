# 2630(색종이 만들기)문제와 동일

import sys

N=int(sys.stdin.readline())
A=[list(map(int, list(sys.stdin.readline().strip()))) for i in range(N)]

def f(x,y,n):
    s=sum([sum(A[i][x:x+n]) for i in range(y,y+n)])
    
    if s==n**2:
        print(1, end="")
        return

    if s==0:
        print(0, end="")
        return

    print("(", end="")
    n=n//2
    f(x,y,n)
    f(x+n,y,n)
    f(x,y+n,n)
    f(x+n,y+n,n)
    print(")",end="")

f(0,0,N)