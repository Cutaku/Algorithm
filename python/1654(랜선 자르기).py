import sys

K,N=map(int,sys.stdin.readline().split())
LAN=[int(sys.stdin.readline()) for i in range(K)]

i,j=1,max(LAN)

count=0
for l in LAN:
    count+=l//j

if count>=N: # 아무 것도 자르지 않았을 때 조건을 만족하는지
    print(j)
else: # i는 조건을 만족하는 길이, j는 조건을 만족하지 않는 길이
    while j-i>1: # j가 i보다 1 클 때 i가 조건을 만족하는 최대 길이
        count=0
        k=(i+j)//2
        for l in LAN:
            count+=l//k
        
        if count>=N: 
            i=k
        else:
            j=k

    print(i)