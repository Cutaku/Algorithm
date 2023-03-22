import sys

# 앞에 있을수록 합에 많이 포함되므로 시간이 적게 걸리는 순서대로 정렬하면 된다
N=int(sys.stdin.readline())
P=list(map(int,sys.stdin.readline().split()))
P.sort()

sum=0
for i in range(N):
    sum+=(N-i)*P[i]

print(sum)