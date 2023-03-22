import sys

N=int(sys.stdin.readline())

# N번째 집이 빨강, 초록 파랑일 때 드는 비용의 최소값
cost=list(map(int,sys.stdin.readline().split()))

# N번째 집이 빨강일 경우 N-1번째 집은 초록 또는 파랑이어야 함
# 따라서 N-1번 째 집이 초록 파랑일 때의 최소값에 빨강칠을 하는 비용을 더함
# 초록, 파랑일 때도 마찬가지
for i in range(N-1):
    R,G,B=map(int,sys.stdin.readline().split())
    cost[0],cost[1],cost[2]=R+min(cost[1],cost[2]), G+min(cost[2],cost[0]), B+min(cost[0],cost[1])

print(min(cost))