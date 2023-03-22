import sys
ip=sys.stdin.readline

N,K=map(int,ip().split())
T=list(map(int,ip().split()))
S=sum(T[:K])
M=S

for i in range(N-K):
    S+=T[i+K]-T[i]
    M=max(M,S)

print(M)