import sys

N,M=map(int,sys.stdin.readline().split())

def f(L):
    if len(L)==M:
        print(*L)
        return

    for i in range(1, N+1):
        if not L or L[-1]<=i:
            f(L+[i])

f([])