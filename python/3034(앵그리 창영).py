import sys

N,W,H=map(int,sys.stdin.readline().split())
S=W**2+H**2

for _ in range(N):
    s=int(sys.stdin.readline())

    if s**2<=S:
        print("DA")
    else:
        print('NE')