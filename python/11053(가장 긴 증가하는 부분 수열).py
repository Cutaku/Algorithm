import sys

N=int(sys.stdin.readline())
A=[0]+list(map(int,sys.stdin.readline().split()))
C=[0]*(N+1) # A[i]를 마지막 수로 하는 가장 긴 증가하는 부분수열의 길이

# A[i]가 마지막이어야하므로 A[i]보다 작은 수(를 마지막으로 하는 수열) 중 길이가 가장 긴 수열에 A[i]를 더함
for i in range(1,N+1):
    temp=[C[j]*(A[j]<A[i]) for j in range(i)]
    C[i]=max(temp)+1

print(max(C))