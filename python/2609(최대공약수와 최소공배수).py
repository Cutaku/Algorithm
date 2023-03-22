import sys

A,B=map(int,sys.stdin.readline().split())
AB=A*B

# 유클리드 호제법을 이용해 A와 B의 최대공약수를 먼저 구함

while A%B!=0:
    A,B=B,A%B

print(B)
print(AB//B) # 최소공배수 = A*B/최대공약수