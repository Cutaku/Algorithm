# bfs 문제

import sys

N,M=map(int,sys.stdin.readline().split())
S=[0]*101 # 사다리, 스네이크

for _ in range(N+M): # 뱀과 사다리 모두 x에서 y로 이동
    x,y=map(int,sys.stdin.readline().split())
    S[x]=y

V=[0]*101 # 방문 여부
V[1]=1

Q1=[1] # 현재 위치
Q2=[] # 다음 위치
c=0 # 주사위 횟수

while Q1:
    q=Q1.pop()
    if q==100:
        break

    p=min(6,100-q) # 100이 넘지 않도록

    for i in range(1,p+1): # 최소 횟수를 구하므로 100을 넘어가는 경우는 고려하지 않음
        if not V[q+i]:
            V[q+i]=1
            if S[q+i]: # 뱀, 사다리가 있는 경우
                if not V[S[q+i]]:
                    V[S[q+i]]=1
                    Q2.append(S[q+i])
            else:
                Q2.append(q+i)
    
    if not Q1:
        c+=1
        Q1=Q2
        Q2=[]

print(c)