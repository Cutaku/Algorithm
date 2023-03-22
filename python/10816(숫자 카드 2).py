# 내 풀이 -> 시간초과, pypy3로 제출

import sys

N=int(sys.stdin.readline())
A=list(map(int,sys.stdin.readline().split()))
A.sort()

M=int(sys.stdin.readline())
B=list(map(int,sys.stdin.readline().split()))
ans=[0]*M

for m in range(M):

    # 시작 지점 찾기 -> 찾는 수 이상인 것 중 최소
    i,j=0,N-1
    while j>i:
        k=(i+j)//2
        if A[k]>=B[m]:
            j=k
        else:
            i=k+1
    s=i

    # 끝 지점 찾기 -> 찾는 수 이하인 것 중 최대
    i,j=0,N-1
    while j>i:
        k=(i+j+1)//2
        if A[k]>B[m]:
            j=k-1
        else:
            i=k
    e=i

    # 끝 지점 - 시작 지점 + 1 이 숫자의 개수
    # 찾는 수가 최대값보다 큰 경우, 최소값보다 작은 경우에는 시작 지점 = 끝 지점이 되므로 1이 나오기 때문에 보정
    ans[m]+=e-s+1-(A[0]>B[m] or A[N-1]<B[m])

print(*ans)



'''
# 딕셔너리를 이용한 풀이
import sys

N=int(sys.stdin.readline())
A=list(map(int,sys.stdin.readline().split()))

M=int(sys.stdin.readline())
B=list(map(int,sys.stdin.readline().split()))
ans=[0]*M

dic={}
for b in B:
    dic[b]=0

for a in A:
    if a in dic:
        dic[a]+=1

for i in range(M):
    ans[i]=dic[B[i]]

print(*ans)
'''