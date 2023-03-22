import sys
from collections import deque

N,K=map(int,sys.stdin.readline().split())
P=deque(range(1,N+1))
Y=[0]*N

print("<", end="")

c=0
while P:
    P.rotate(-K+1) # K번째 카드가 맨 앞으로 올 때까지
    Y[c]=P.popleft() # 맨 앞으로 이동한 카드 제거
    c+=1
Y=list(map(str,Y))
print(",".join(Y), end="")

print(">")