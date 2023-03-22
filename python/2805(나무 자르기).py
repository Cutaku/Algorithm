# 1654와 동일하게 풀이

import sys

N,M=map(int,sys.stdin.readline().split())
Tree=list(map(int,sys.stdin.readline().split()))
    
i,j=0,max(Tree)

while j-i>1:
    k=(i+j)//2
    sum=0
    for tree in Tree:
        if tree>k:
            sum+=tree-k
        if sum>=M:
            break
    
    if sum>=M:
        i=k
    else:
        j=k

print(i)

'''
# 동일한 로직, 재귀함수를 이용한 풀이 -> 속도 더 빠름
def bin(i,j):
    if j-i==1:
        return i

    k=(i+j)//2
    sum=0
    for tree in Tree:
        if tree>k:
            sum+=tree-k
        if sum>=M:
            break

    if sum>=M:
        return bin(k,j)
    else:
        return bin(i,k)

print(bin(0,max(Tree)))
'''