import sys

n=int(sys.stdin.readline())
divs=list(map(int,sys.stdin.readline().split()))

print(min(divs)*max(divs)) #  N = 가장 작은 진짜 약수 * 가장 큰 진짜 약수