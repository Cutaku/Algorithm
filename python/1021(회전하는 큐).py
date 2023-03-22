import sys
from collections import deque

N,M=map(int,sys.stdin.readline().split())
C=deque(map(int,sys.stdin.readline().split())) # 뽑아내야하는 수들의 위치
nums=deque(range(1,N+1)) # 숫자들의 처음 위치
ans=0

for i in range(M):
    c=0
    while nums[0]!=C[0]: # 뽑아내려는 수가 맨 앞에 올때까지 3번 연산 시행
        nums.rotate()
        c+=1
    c=min(c,N-i-c) # 3번 시행과 2번 시행 횟수 중 작은 값
    C.popleft()
    nums.popleft()
    ans+=c

print(ans)