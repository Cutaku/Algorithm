import sys

N,K=map(int,sys.stdin.readline().split())
K=min(K,N-K)
d=1000000007 # 소수
a,b=1,1

for i in range(K):
    a=a*(N-i)%d # 분자
    b=b*(i+1)%d # 분모

# 페르마의 소정리를 이용해 분모 계산
# d가 소수이므로 (1/b)**(d-1)=1 (mod d) -> 1=b**(d-2) (mod d)
c=d-2
while c>0:
    if c%2==1:
        c-=1
        a=(b*a)%d
    else:
        c=c//2
        b=(b**2)%d


print(a)