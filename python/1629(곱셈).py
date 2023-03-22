# 분할정복을 통한 빠른 거듭제곱의 계산
import sys

A,B,C=map(int,sys.stdin.readline().split())
ans=1

while B>0:
    if B%2==1: # B가 홀수인 경우 한번 곱셈
        ans=(ans*A)%C
        B-=1
    else: # B가 짝수인 경우 A를 제곱해주면서 거듭제곱의 수를 줄임
        A=(A**2)%C
        B=B//2

print(ans)