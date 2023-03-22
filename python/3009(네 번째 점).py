import sys

V=[0]*1001 
H=[0]*1001
X,Y=0,0

# 3개 중에 중복되는 것 빼고 나머지 하나
for _ in range(3):
    x,y=map(int,sys.stdin.readline().split())
    if V[x]:
        X-=x
    else:
        V[x]=1
        X+=x

    if H[y]:
        Y-=y
    else:
        H[y]=1
        Y+=y

print(X,Y)