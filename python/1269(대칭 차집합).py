import sys
ip=sys.stdin.readline

n,m=map(int,ip().split())
A,B=list(map(int,ip().split())), list(map(int,ip().split()))

N={}

for a in A:
    N[a]=1

for b in B:
    try:
        N[b]-=1
    except:
        N[b]=1

print(sum(N.values()))