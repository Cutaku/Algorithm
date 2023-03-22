
import sys
ip = sys.stdin.readline

n,m=int(ip()), int(ip())

# 고장나지 않은 버튼
Ub = [1]*10
if m!=0: 
    B=list(map(int,ip().split()))
    for b in B: Ub[b]=0

# 숫자 버튼은 사용하지 않고 이동할 때의 횟수
ans=abs(n-100)

# 재귀함수를 정의하여 반복적으로 탐색
def f(s):
    global ans

    if len(s)>0:
        num=int(s)

        # num의 자리수가 n의 자리수보다 하나 작을 때부터 계산 (그 이하일 땐 눌러야 하는 버튼 수가 더 많기 때문)
        if len(str(num))>len(str(n))-2: ans = min(ans, len(str(num))+abs(num-n))

        # s의 길이가 n의 자리수보다 길어지거나(0만 반복해서 붙는 경우 처리하기 하기위해)
        # num이 n보다 커지는 경우 종료 (더 커지면 눌러야하는 버튼 수 증가)
        if len(s)>len(str(n)) or num>n: return
    
    for i in range(10):
        if Ub[i]: f(s+str(i))

f("")

print(ans)




# 목표 채널로부터 하나씩 채널을 이동하며 이동할 수 있는 채널인지 확인하는 방법

import sys
ip = sys.stdin.readline

n,m=int(ip()), int(ip())

# 고장난 버튼
B = [0]*10
if m!=0: 
    BB=list(map(int,ip().split()))
    for b in BB: B[b]=1

# 숫자 버튼을 사용하지 않을 때 눌러야하는 횟수
ans=abs(n-100)


# i가 ans 이상인 경우는 버튼을 눌러야하는 횟수가 ans개 이상이므로 최소가 될 수 없다 -> ans까지만 탐색
for i in range(ans):

    # 먼저 n-i를 탐색하고 n+i를 탐색 -> 자리수가 바뀌는 경우가 있기 때문에(n-i의 자리수 <= n+i의 자리수)
    if n>=i:    # 음수가 되는 경우 방지
        s= str(n-i)
        det=1 # 고장나지 않은 버튼으로 이동할 수 이는 채널인지 확인용
        for j in range(len(s)):
            if B[int(s[j])]: # 하나라도 고장난 버튼이 필요하면
                det=0 # 패스
                break
        if det: # 고장나지 않은 버튼으로 이동할 수 있는 채널이면
            ans=min(ans,i+len(s)) # 기존 ans값과 비교 후 최소값 갱신
            break # for문이 진행될 수록 눌러야하는 횟수가 커지므로 하나라도 발견시 더이상 for문을 진행할 이유가 없음

    # 동일하게 n+i도 탐색
    s=str(n+i)
    det=1
    for j in range(len(s)):
        if B[int(s[j])]:
            det=0
            break
    if det:
        ans=min(ans,i+len(s))
        break

print(ans)