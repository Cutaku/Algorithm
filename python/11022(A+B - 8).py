import sys

T=int(sys.stdin.readline())

for t in range(T):
    a,b=map(int,sys.stdin.readline().split())
    print('Case #%d: %d + %d = %d'%(t+1,a,b,a+b))