import sys

N,K= map(int,sys.stdin.readline().split())
K=min(K,N-K) # 값이 같으므로 계산을 더 적게하기 위해

ans=1
div=1
for i in range(K):
    ans*=N-i
    div*=i+1

ans=ans//div

print(ans)