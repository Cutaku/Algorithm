import sys
ip=sys.stdin.readline

N,M=map(int,ip().split())
dic={}

for i in range(N):
    S=ip()
    dic[S]=1

s=0
for i in range(M):
    S=ip()
    if S in dic:
        s+=1

print(s)