import sys
from collections import deque

T=int(sys.stdin.readline())
for t in range(T):
    N,M=map(int,sys.stdin.readline().split())
    I=deque(list(map(int,sys.stdin.readline().split()))) # 중요도
    S=deque(sorted(I, reverse=True)) # 중요도를 큰 순서대로 정렬
    P=deque(range(N)) # 초기 위치를 알려주는 큐
    c=0
    while M in P:
        if I[0]==S[0]: # 첫번째 수의 중요도가 가장 크면 인쇄
            I.popleft()
            S.popleft()
            P.popleft()
            c+=1
        else: # 아니면 뒤로 보내기
            I.rotate(-1)
            P.rotate(-1)
    print(c)