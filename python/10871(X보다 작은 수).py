import sys

N,X=map(int,sys.stdin.readline().split())
L=list(map(int,sys.stdin.readline().split()))
ans=[]
for l in L:
    if l<X:
        ans.append(l)
print(*ans)