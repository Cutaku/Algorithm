import sys
import heapq

# 두 개의 힙을 이용해 풀이

N=int(sys.stdin.readline())
H=[] # 최대 힙 -> 중앙값 까지의 수를 저장
h=[] # 최소 힙 -> 나머지를 저장

# 두 힙의 크기가 같거나 최대 힙의 크기가 1 더 크도록 유지
# 최대 힙의 첫번째 값이 중앙값

for n in range(N):
    num=int(sys.stdin.readline())

    if not n: # 처음에 최대 힙에 값을 입력
        heapq.heappush(H,-num)

    else:
        if len(H)>len(h): # 최대 힙의 크기가 (1) 더 큰 경우
            if num>=-H[0]: # 입력하는 수가 최대 힙의 첫번째 값 이상이면 최소 힙에 입력
                heapq.heappush(h,num)
            else: # 첫번째 값보다 작으면 첫번째 값을 최소 힙으로 이동하고 최대 힙에 입력
                heapq.heappush(h,-heapq.heappop(H))
                heapq.heappush(H,-num)
         
        else: # 두 힙의 크기가 같은 경우
            if num<=h[0]: # 입력하는 수가 최소 힙의 첫번째 값 이하면 최대 힙에 입력
                heapq.heappush(H,-num)
            else: # 첫번째 값보다 크면 첫번 째 값을 최대 힙으로 이동하고 최소 힙에 입력
                heapq.heappush(H,-heapq.heappop(h))
                heapq.heappush(h,num)

    print(-H[0])