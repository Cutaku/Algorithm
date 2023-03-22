import sys
ip=sys.stdin.readline

c=1000000
G=[0]*c # f(n)의 값을 저장할 리스트 

for i in range(1,1001):
    for j in range(1, int((c)/i)+1):
        if (i<=j): G[i*j-1]+=i	# 중복된 경우를 피하기 위해 i<=j인 경우만 계산 (i>j인 경우는 이미 계산됨)
        if (i<j): G[i*j-1]+=j	# i=j인 경우 제곱수이므로 i 한번만 더함

for i in range(1,c):	# f(n)을 차례로 더하면서 g(n)을 계산
    G[i]+=G[i-1]

T=int(ip())

for t in range(T):
    print(G[int(ip())-1])