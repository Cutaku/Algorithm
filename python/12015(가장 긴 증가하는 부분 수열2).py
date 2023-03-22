# 이분 탐색을 활용한 풀이

import sys
N=int(sys.stdin.readline())
A=list(map(int,sys.stdin.readline().split()))

def bin(a,s,e): # a 이상인 수 중에 가장 작은 수(의 index)를 찾는 이분탐색
    if e-s==1: 
        return e

    m=(s+e)//2
    if LCS[m]>=a:
        return bin(a,s,m)
    else:
        return bin(a,m,e)


LCS=[0] # LCS의 길이를 구하기 위한 배열 -> 이 배열이 LCS가 되는 것은 아님
for a in A:
    if LCS[-1]<a:
        LCS.append(a) # a가 마지막 수보다 더 크면 입력
    else:
        LCS[bin(a,0,len(LCS)-1)]=a  # 아니면 a 이상인 수 중에 가장 작은 수를 대체
                                    # 0은 자명하게 a보다 작고 LCS[-1]은 가정에 의해 a 이상
print(len(LCS)-1)