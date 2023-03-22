import sys

T=int(sys.stdin.readline())

for t in range(T):
    H,W,N=map(int,sys.stdin.readline().split())
    print(str(N%H+H*(N%H==0))+str(100+N//H+(N%H!=0))[1:])