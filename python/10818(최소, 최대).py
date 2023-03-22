import sys

N=int(sys.stdin.readline())
nums=list(map(int,sys.stdin.readline().split()))
M,m=-1000000,1000000

for num in nums:
    m=min(m,num)
    M=max(M,num)

print(m,M)