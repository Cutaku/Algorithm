import sys

K=int(sys.stdin.readline())
S=[]

for k in range(K):
    n=int(sys.stdin.readline())
    if n==0: # 0일 경우 가장 최근에 입력한 수 제거
        S.pop()
    else: # 아닐 경우 해당 수를 입력
        S.append(n)

print(sum(S))