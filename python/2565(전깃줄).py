# 두 전깃줄 (a1, b1), (a2, b2)가 겹치지 않기 위해서는 a1<a2 , b1<b2 이어야 함
# 따라서 전깃줄의 B 위치를 A위치 기준으로 정렬시킬 때 증가하는 부분 수열이 겹치지 않는 전깃줄의 개수
# LIS를 활용

import sys

n=int(sys.stdin.readline())
L=[[0,0]]+[list(map(int,sys.stdin.readline().split())) for i in range(n)]
L.sort()
C=[0]*(n+1)

for i in range(1,n+1):
    temp=[C[j]*(L[j][1]<L[i][1]) for j in range(i)]
    C[i]=max(temp)+1

print(n-max(C)) # 제거해야 하는 개수를 물었으므로 전체에서 LIS를 빼준 값