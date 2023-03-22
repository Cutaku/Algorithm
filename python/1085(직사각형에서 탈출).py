import sys

x,y,w,h=map(int,sys.stdin.readline().split())

# 4 변 중 가장 가까운 거리 확인
print(min(x,y,w-x,h-y))