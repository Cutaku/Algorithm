# Python3로 제출하면 시간초과 나와서 Pypy3로 제출

import sys

N=int(sys.stdin.readline())

Board=[[0]*N for i in range(N)]
P=[] # position -> 각 행에서의 퀸의 위치
# 체스판에서 대각 위치에 있다는 것은 행, 열의 합 또는 차가 같다는 것
D1=[0]*(2*N-1) # / : 합
D2=[0]*(2*N-1) # \ : 차
count=0

def f():
    global count
    if len(P)==N:
        count+=1
        return

    i=len(P) # i번째 행까지 퀸을 놓고 i+1번쨰 행의 퀸의 위치를 구함
    for j in range(N):
        if j not in P and D1[i+j]==0 and D2[i-j]==0: # 1. 같은 열에 퀸이 없고, 2. 대각 위치에 퀸이 없는 경우
            P.append(j)
            D1[i+j]=1
            D2[i-j]=1
            f()
            P.pop()
            D1[i+j]=0
            D2[i-j]=0

f()

print(count)