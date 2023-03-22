import sys

N=int(sys.stdin.readline())

Rank=[1]*N
W=[0]*N
H=[0]*N

for i in range(N):
    w,h=map(int,sys.stdin.readline().split())
    W[i]=w
    H[i]=h

for i in range(N):
    for j in range(N):
        if i!=j:
            Rank[i]+=(W[i]<W[j])*(H[i]<H[j])

print(*Rank)