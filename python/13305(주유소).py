import sys

N=int(sys.stdin.readline())
dist=list(map(int,sys.stdin.readline().split()))
oil_price=list(map(int,sys.stdin.readline().split()))
p=10**9
cost=0

# 리터당 가격을 최소로 갱신하면서 합산
for i in range(N-1):
    p=min(oil_price[i],p)
    cost+=p*dist[i]

print(cost)