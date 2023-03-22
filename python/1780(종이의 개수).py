# 쿼드트리와 동일

import sys

N=int(sys.stdin.readline())
P=[list(map(int,sys.stdin.readline().split())) for i in range(N)]
ans=[0,0,0]

def f(x,y,n):

    # 종이가 모두 같은 색인지 판별
    det=1
    for i in range(n):
        for j in range(n):
            if P[x][y]!=P[x+i][y+j]:
                det=0
                break
        if det==0:
            break

    if det==1:
        ans[P[x][y]]+=1
        return

    n=n//3
    for i in range(3):
        for j in range(3):
            f(x+i*n,y+j*n,n)

f(0,0,N)

print(ans[-1])
print(ans[0])
print(ans[1])