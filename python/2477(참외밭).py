import sys

K=int(sys.stdin.readline())
dir=[0,4,3,1,2] # 반시계 방향으로 회전할 때의 방향(북->서->남->동->북)
a,b=0,0 # 가로, 세로 최대 길이
D,L=[],[] # 방향/길이

for i in range(6):
    d,l=map(int,sys.stdin.readline().split())

    if i%2==0:
        a=max(a,l)
    else:
        b=max(b,l)

    D.append(d)
    L.append(l)

# 반시계 방향으로 회전할 때, 육각형의 오목한 부분에서만 진행 순서가 다름
for i in range(6):
    if D[i]!=dir[D[i-1]]:
        j=i

print((a*b-L[j]*L[j-1])*K) # 직사각형에서 오목한 부분만 빼면 육각형의 넓이