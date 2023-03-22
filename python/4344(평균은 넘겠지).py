import sys

T=int(sys.stdin.readline())

for t in range(T):
    L=list(map(int,sys.stdin.readline().split()))
    avg=sum(L[1:])/L[0]
    ans=0
    for score in L[1:]:
        ans+=(score>avg)
    ans*=100/L[0]
    print(f'{ans:0.3f}'+'%')