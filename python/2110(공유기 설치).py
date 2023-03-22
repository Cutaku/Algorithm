import sys

N,C=map(int,sys.stdin.readline().split())
H=[int(sys.stdin.readline()) for i in range(N)]
H.sort()

# 공유기 사이의 최소거리를 정하고 조건에 맞게 설치할 수 있는지 확인

# 이분 탐색
def bin(i,j): # i는 조건을 만족, j는 만족하지 않음
    if j-i==1: # 따라서 j-i=1일 때 i가 조건을 만족하는 최대값
        return i
    
    k=(i+j)//2
    count=1 # 최소거리를 유지하면서 설치할 수 있는 공유기 수
    last=H[0] # 첫번째 집에 공유기 설치
    for h in H:
        if h-last>=k: # 마지막으로 설치한 집으로부터 최소거리 이상 떨어진 집에 공유기 설치
            last=h
            count+=1
        
    if count>=C: 
        return bin(k,j)
    else:
        return bin(i,k)

if C==2: # C가 2일 경우는 자명하게 양쪽 끝 집에 설치
    print(H[-1]-H[0])
else: # C가 2보다 큰 경우 H[-1]-H[0]은 항상 조건을 만족하지 못함(자명하게 1은 만족함)
    print(bin(1,H[-1]-H[0]))