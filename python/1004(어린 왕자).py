# 어린왕자와 장미가 같은 행성계에 있는 경우 그 행성계의 경계는 지나지 않음
# 어린왕자와 장미가 모두 어떤 행성계 밖에 있는 경우 그 행성계의 경계는 지나지 않음
# 어린와자나 장미 둘 중 하나만 어떤 행성계 안에 있는 경우 그 행성계의 경계를 지남

import sys

T=int(sys.stdin.readline())

for t in range(T):
    x1,y1,x2,y2=map(int,sys.stdin.readline().split())
    c=0
    n=int(sys.stdin.readline())

    for i in range(n):
        c1,c2,r=map(int,sys.stdin.readline().split())
        S1=((x1-c1)**2+(y1-c2)**2<r**2) # 어린왕자가 행성계에 포함되어 있는지
        S2=((x2-c1)**2+(y2-c2)**2<r**2) # 장미가 행성계에 포함되어 있는지
        
        if S1!=S2: # 둘 중 하나만 포함되어있는 경우
            c+=1

    print(c)