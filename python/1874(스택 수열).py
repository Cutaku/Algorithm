import sys

n=int(sys.stdin.readline())
nums=list(range(n,0,-1))
S=[0] # 0을 넣지 않으면 첫번째 시행에서 오류가 남 - S[-1] 부분
A=[]

for i in range(n):
    m=int(sys.stdin.readline())
    if m<S[-1]: # m이 이미 스택 안에 있지만 가장 위에 있지 않기 때문에 불가능하다
        print("NO")
        break

    # 남은 경우는 m이 아직 스택 안에 없거나 스택 가장 위에 있는 경우
    while m!=S[-1]: # 스택 가장 위에 없는 경우(= 아직 스택 안에 넣지 않았을 경우)
        S.append(nums.pop())
        A.append("+")
    S.pop()
    A.append("-")


if len(S)==1:
    for ans in A:
        print(ans)