import sys

W,H,X,Y,P=map(int,sys.stdin.readline().split())
R=H/2
c=0

# x를 세 구간으로 나눠 확인
for _ in range(P):
    x,y=map(int,sys.stdin.readline().split())

    if X-R<=x<X:
        if (X-x)**2+(Y+R-y)**2<=R**2:
            c+=1
    elif X<=x<=X+W:
        if Y<=y<=Y+H:
            c+=1
    elif X+W<x<=X+W+R:
        if (x-X-W)**2+(Y+R-y)**2<=R**2:
            c+=1

print(c)