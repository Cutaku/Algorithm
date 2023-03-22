import sys

N,K=map(int,sys.stdin.readline().split())
C=[int(sys.stdin.readline()) for i in range(N)]
count=0

# 가장 액수가 큰 동전부터 계산
# 나눈 몫이 사용한 동전의 개수이고 나머지가 남은 금액
while K>0:
    coin=C.pop()
    count+=K//coin 
    K=K%coin

print(count)