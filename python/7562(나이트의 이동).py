import sys
from collections import deque as dq

T=int(sys.stdin.readline())

move=([1,2],[2,1],[1,-2],[2,-1],[-1,2],[-2,1],[-1,-2],[-2,-1])

for t in range(T):
    l=int(sys.stdin.readline())
    V=[[0]*l for i in range(l)]
    s=list(map(int,sys.stdin.readline().split()))
    e=list(map(int,sys.stdin.readline().split()))
    V[s[0]][s[1]]=1
    c=0

    q1=dq([s])
    q2=dq([])
    
    end=0
    while 1:
        q=q1.popleft()

        if q==e:
            break

        for m in move:
            x=q[0]+m[0]
            y=q[1]+m[1]

            if 0<=x<l and 0<=y<l and not V[x][y]:
                q2.append([x,y])
                V[x][y]=1
        
        if not q1:
            q1=q2
            q2=dq([])
            c+=1

    print(c)