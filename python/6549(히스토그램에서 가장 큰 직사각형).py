# 스택을 이용한 풀이

import sys

while 1:
    H=list(map(int,sys.stdin.readline().split()))+[0] # 마지에 스택을 모두 비우기 위해 0을 추가
    if H[0]==0:
        break

    n=H[0]
    H[0]=0
    stack=[0]
    R=0


    # 인덱스를 차례대로 스택에 입력
    # 입력하려는 인덱스의 직사각형 높이가 스택 가장 위에 있는 인덱스의 직사각형 높이보다 큰 경우에는 그냥 입력
    # 작은 경우 스택 가장 위에 있는 인덱스를 제거 -> 직사각형의 넓이 계산하면서 최대값 갱신
    
    # 직사각형의 넓이
    # 스택이 [....., a, b] 입력하려는 인덱스가 c (H[b]>H[c])
    # 인덱스 a+1 부터 c-1까지의 직사각형의 높이는 H[b] 이상, H[a],H[c]는  H[b] 미만
    # 따라서 직사각형의 넓이 = (c-a-1)*H[b]

    for i in range(1,n+2):
        while H[stack[-1]]>H[i]:
            j=stack.pop()
            R=max(R,H[j]*(i-stack[-1]-1))
        stack.append(i)

    # 처음과 마지막에 0을 추가했으므로 스택에 직사각형 높이가 0보다 큰 인덱스는 모두 제거됨

    print(R)