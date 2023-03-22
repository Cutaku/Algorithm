import sys

N,M=map(int,sys.stdin.readline().split())
nums=list(map(int,sys.stdin.readline().split()))

ans=0

for i in range(N-2):
    for j in range(i+1,N-1):
        for k in range(j+1,N):
            sum=nums[i]+nums[j]+nums[k]
            if sum<=M:
                ans=max(ans,sum)

print(ans)