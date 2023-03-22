import sys

T=int(sys.stdin.readline())
P=[0,1,1,1,2,2] # 초기값만 설정


# N번째 삼각형의 한 변의 길이는 N-1번째 삼각형과 N-5번째 삼각형의 한 변의 길이의 합과 같다
for t in range(T):
    N=int(sys.stdin.readline())
    while len(P)<N+1:
        P.append(P[-1]+P[-5])
    print(P[N])