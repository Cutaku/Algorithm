# 처음에는 재귀함수로 풀려 했으나 재귀함수 깊이 한도 오류가 나고 
# 어차피 i 번째를 계산하기 위해서는 i-1번째 값이 필요하므로 1부터 차례대로 계산하는 것이 더 빠름
import sys

N=int(sys.stdin.readline())
One=[0]*(N+1)

# 메모이제이션을 이용하여 2부터(1은 어차피 0이므로) 계산
for i in range(2,N+1):
    a=One[i-1]
    b=One[i//2]+(i%2!=0)*a # i가 2로 나누어 떨어지지 않으면 a를 더해 최소값이 되지 않도록
    c=One[i//3]+(i%3!=0)*a # 마찬가지
    One[i]=min(a,b,c)+1

print(One[N])  