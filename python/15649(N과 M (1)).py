import sys

N,M=map(int, sys.stdin.readline().split())

def f(L):
    if len(L)==M: # 리스트의 길이가 M이되면 출력하고 함수를 리턴
        print(*L)
        return
    
    for i in range(1,N+1):
        if i not in L: # 중복 없이
            f(L+[i])

f([])