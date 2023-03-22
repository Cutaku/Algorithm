import sys

N=int(sys.stdin.readline())
seq=list(map(int,sys.stdin.readline().split()))
ans=[-1]*N # 기본 값을 -1로 두고 오큰수가 존재할 경우에 바꿔준다
stack=[] # 스택에는 수열의 인덱스를 저장한다

# 스택의 마지막 수를 j라고 할 때
# 1. seq[i]<seq[j]이면 i를 스택에 추가 (스택이 비어있을 때도)
# 2. seq[i]>seq[j]이면 스택에서 j를 제거하고 j번째 수의 오큰수가 seq[i]가 된다

for i in range(N):
    while stack and seq[stack[-1]]<seq[i]: # 스택이 비어있지 않고 2번의 경우
        ans[stack.pop()]=seq[i]
    stack.append(i) # 1번의 경우

print(*ans)