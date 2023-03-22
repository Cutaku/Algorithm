import sys
ip=sys.stdin.readline

N,M=map(int,ip().split())
nums=list(map(int,ip().split()))
sums=[0]
for i in range(N):
    sums.append(sums[-1]+nums[i])

for k in range(M):
    i,j=map(int,ip().split())
    print(sums[j]-sums[i-1])