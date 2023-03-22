import sys

N=int(sys.stdin.readline())
S=[list(map(int,sys.stdin.readline().split())) for i in range(N)]

def stat(L): # 팀의 능력치 총합을 구하는 함수
    sum=0
    for i in L:
        for j in L:
            sum+=S[i][j]
    return sum

start=[0] # 팀은 symmetic이므로 0번 선수가 있는 팀을 기준으로 함
diff=[]

def f():
    if len(start)==N//2:
        link=[] 
        for i in range(N):
            if i not in start:
                link.append(i)
        diff.append(abs(stat(start)-stat(link)))
        return
    
    for i in range(start[-1]+1, N): # 오름차순으로 쌓이게해서 중복되어 계산되지 않도록 함
        start.append(i)
        f()
        start.pop()

f()

print(min(diff))