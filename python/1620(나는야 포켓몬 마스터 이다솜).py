import sys
ip=sys.stdin.readline

N,M=map(int,ip().split())
D1=[0]*(N+1)
D2={}

for i in range(1,N+1):
    p=ip().strip()
    D1[i]=p
    D2[p]=i

for i in range(M):
    q=ip().strip()
    try:
        print(D2[q])
    except:
        print(D1[int(q)])