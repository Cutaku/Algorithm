import sys

n,m=map(int,sys.stdin.readline().split())

# n!에서 약수 d의 개수를 구하는 함수
def count(n,d):
    c=0
    while n//d!=0:
        n=n//d
        c+=n
    return c

# 0의 개수 = 10의 거듭제곱 수 = 약수 중 2와 5의 개수 중 최소값
# nCm = n! / (m! * (n-m)!) 
c2=count(n,2)-count(m,2)-count(n-m,2)
c5=count(n,5)-count(m,5)-count(n-m,5)

print(min(c2,c5))