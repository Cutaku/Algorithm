import sys
from math import gcd

N=int(sys.stdin.readline())
nums=[0]*N
for i in range(N):
    nums[i]=int(sys.stdin.readline())
nums.sort()

# A,B ㅌ nums 이고 A = M*a + r ,  B = M*b + r 라고할때
# A - B = M*(a-b) 이므로 M은 A-B의 약수
# 따라서 M은 모든 A-B들의 공약수여야 한다 -> 최대공약수의 약수

GCD=nums[1]-nums[0]
for i in range(2,N):
    GCD=gcd(GCD,nums[i]-nums[i-1]) # 모든 A-B는 nums[i]-nums[i-1]의 합으로 나타낼 수 있기 때문에 차례대로 최대공약수를 구하면 된다


# GDC의 약수를 구하는 과정
# GDC까지 모두 계산하면 시간초과되므로 루트를 씌워 계산을 줄임
r=int(GCD**(0.5)+1)
ans=[]

for i in range(2,r):
    if GCD%i==0:
        ans.append(i)
        ans.append(GCD//i)
    
ans=list(set(ans)) # 완전제곱수일 경우 중복되는 수가 있으므로 제거
ans.sort() 
ans.append(GCD)

print(*ans)