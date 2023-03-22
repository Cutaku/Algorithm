import sys
import heapq

# 양수와 음수를 다른 힙에 저장해 구분

N=int(sys.stdin.readline())
pH=[] # 양수 힙
mH=[] # 음수 힙

for n in range(N):
    num=int(sys.stdin.readline())

    if num>0:
        heapq.heappush(pH,num)
    elif num<0:
        heapq.heappush(mH,-num)
    
    else:
        if not(pH or mH): # 둘다 비어있을 경우
            print(0)
        elif pH and not mH: # 음수 힙만 비어있을 경우
            print(heapq.heappop(pH))
        elif mH and not pH: # 양수 힙만 비어있을 경우
            print(-heapq.heappop(mH))
        else: # 둘 다 비어있지 않은 경우
            if mH[0]<=pH[0]: # 절대값이 더 작은 수를 출력, 같은 경우 더 작은 음수를 출력
                print(-heapq.heappop(mH))
            else:
                print(heapq.heappop(pH))
'''

# 튜플을 이용한 힙 모듈 사용

import sys
import heapq

N=int(sys.stdin.readline())
H=[]

for n in range(N):
    num=int(sys.stdin.readline())

    if num==0:
        try:
            print(heapq.heappop(H)[1])
        except:
            print(0)

    else:
        heapq.heappush(H,(abs(num),num))
'''