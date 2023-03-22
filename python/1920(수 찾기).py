# 이분탐색 문제


# 내 풀이

import sys

N=int(sys.stdin.readline())
A=list(map(int,sys.stdin.readline().split()))
A.sort() # 이진탐색을 위해 정렬

M=int(sys.stdin.readline())
B=list(map(int,sys.stdin.readline().split()))


for b in B:
    i,j=0,N-1 # 처음과 마지막 값을 기준으로 탐색 시작

    while j>=i: 
        k=(j+i)//2 # 양 끝을 기준으로 가운데를 탐색

        if A[k]==b:
            break
        elif A[k]<b: 
            i=k+1
        else:
            j=k-1

    if A[k]==b:
        print(1)
    else:
        print(0)

'''


# 다른 풀이 -> 재귀함수를 활용한 풀이

import sys

N=int(sys.stdin.readline())
A=list(map(int,sys.stdin.readline().split()))
A.sort()

M=int(sys.stdin.readline())
B=list(map(int,sys.stdin.readline().split()))

def bin(b,s,t):
    if s>t:
        return 0
    
    m=(s+t)//2

    if A[m]==b:
        return 1
    elif b>A[m]:
        return bin(b,m+1,t)
    else:
        return bin(b,s,m-1)

for b in B:
    print(bin(b,0,N-1))

'''