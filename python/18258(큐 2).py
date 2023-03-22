import sys
from collections import deque

N=int(sys.stdin.readline())
Q=deque()

for n in range(N):
    C=list(map(str,sys.stdin.readline().split()))
    if C[0]=="push":
        Q.append(C[1])
    elif C[0]=="pop":
        if Q:
            print(Q.popleft())
        else:
            print(-1)
    elif C[0]=="size":
        print(len(Q))
    elif C[0]=="empty":
        if Q:
            print(0)
        else:
            print(1)
    elif C[0]=="front":
        if Q:
            print(Q[0])
        else:
            print(-1)
    else:
        if Q:
            print(Q[-1])
        else:
            print(-1)