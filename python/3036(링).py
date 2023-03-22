import sys
from math import gcd

N=int(sys.stdin.readline())
nums=list(map(int,sys.stdin.readline().split()))

# 돌아가는 바퀴 수는 원의 반지름에 반비례한다
# 최대공약수로 나눠 기약분수 형태로 나타냄

for i in range(1,N):
    g=gcd(nums[0],nums[i])
    A, B = nums[0]//g, nums[i]//g
    print("%d/%d" %(A,B))