# 가장 긴 증가하는 부분 수열 문제를 응용
import sys

# A[i]를 최대값으로 갖는  가장 긴 바이토닉 수열을 구함
# 앞에서부터 시작해 A[i]에서 끝나는 가장 긴 증가하는 부분수열과 뒤에서부터 시작해 A[i]에서 끝나는 가장 긴 증가하는 부분수열을 더함
N=int(sys.stdin.readline())
a=list(map(int,sys.stdin.readline().split()))
A=[0]+a
a.reverse()
A_r=[0]+a
C=[0]*(N+1)
C_r=[0]*(N+1)

for i in range(1,N+1):
    temp=[C[j]*(A[j]<A[i]) for j in range(i)]
    temp_r=[C_r[j]*(A_r[j]<A_r[i]) for j in range(i)]
    C[i]=max(temp)+1
    C_r[i]=max(temp_r)+1

S=[C[i]+C_r[-i]-1 for i in range(1,N+1)] # A[i]를 중복으로 포함하므로 -1
print(max(S))