import sys

N,M=map(int,sys.stdin.readline().split())

def f(L):
    if len(L)==M: # 리스트의 길이가 M이되면 출력하고 함수를 리턴
        print(*L)
        return

    for i in range(1, N+1):
        if not L or L[-1]<i: # L이 비어있거나 i가 L의 마지막 수보다 크면
            f(L+[i])

f([])