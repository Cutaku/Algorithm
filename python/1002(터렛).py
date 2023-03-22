import sys

T=int(sys.stdin.readline())

for t in range(T):
    x1,y1,r1,x2,y2,r2=map(int,sys.stdin.readline().split())
    dist=(x2-x1)**2+(y2-y1)**2

# 동심원인 경우 반지름이 같으면 무한개, 반지름이 다르면 0개
    if dist==0:
        if r1==r2:
            print(-1)
        else:
            print(0)

# 동심원이 아닐 경우 3가지 경우(세세히 구분하면 5가지)
    else:
        if (r1+r2)**2<dist or (r1-r2)**2>dist:
            print(0)
        elif (r1+r2)**2==dist or (r2-r1)**2==dist:
            print(1)
        else:
            print(2)