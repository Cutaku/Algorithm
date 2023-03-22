import sys

nums=[0]*20000001 # -10000000 ~ 10000000
N=int(sys.stdin.readline())
S=list(map(int,sys.stdin.readline().split()))
for s in S:
    nums[s]=1

M=int(sys.stdin.readline())
T=list(map(int,sys.stdin.readline().split()))

for i in range(M):
    T[i]=nums[T[i]]

print(*T)