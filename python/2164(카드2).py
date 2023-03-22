import sys
from collections import deque

N=int(sys.stdin.readline())
C=deque(range(1,N+1))

while len(C)>1:
    C.popleft() #맨 위에 있는 카드 제거
    C.rotate(-1) # 맨 위에 있는 카드 아래로 옮기기

print(C[0])