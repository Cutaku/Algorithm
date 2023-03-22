# 이항 계수 문제와 동일

import sys

T=int(sys.stdin.readline())

for t in range(T):
    N, M= map(int,sys.stdin.readline().split())
    N=min(N,M-N) 

    ans=1
    div=1
    for i in range(N):
        ans*=M-i
        div*=i+1

    ans=ans//div

    print(ans)