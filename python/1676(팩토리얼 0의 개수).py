import sys

N=int(sys.stdin.readline())
 
 # 0의 개수 = 10의 거듭제곱 수 = 약수 중 2와 5의 개수 중 최소값
 # 자명하게 5의 개수가 더 적으므로 5의 개수만 구하면 된다

# 처음 5로 나눈 몫이 5의 배수의 개수
# 다음 5로 나눈 몫이 25의 배수의 개수
# 5의 거듭제곱의 배수의 개수를 모두 구함
ans=0
while N//5!=0: 
    N=N//5
    ans+=N

print(ans)