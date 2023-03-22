import sys

N,K=map(int,sys.stdin.readline().split())
K=min(K,N-K) # 값이 같으므로 계산을 더 적게하기 위해


# 앞의 방법으로는 수가 커지면 계산이 많아 시간초과
# 파스칼의 삼각형을 이용해 풀이

P=[[1]*(N-K+1) for i in range(K+1)]

for i in range(1,K+1):
    for j in range(1,N-K+1):
        P[i][j]=(P[i-1][j]+P[i][j-1])%10007

print(P[-1][-1])