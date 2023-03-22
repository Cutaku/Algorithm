# 마자막 수를 포함해야된다는 조건만 제거한 2579(계단 오르기)문제와 동일함

import sys

n=int(sys.stdin.readline())

W=[0]+[int(sys.stdin.readline()) for i in range(n)]
Q=[0]*(n+1)

# 계단 오르기 문제에서 마지막 수를 포함하지 않는 경우만 추가
# -> n-1까지 얻을 수 있는 최대값
for i in range(1,n+1):
    Q[i]=max(W[i]+Q[i-2], W[i]+W[i-1]+Q[i-3], Q[i-1])

print(Q[n])