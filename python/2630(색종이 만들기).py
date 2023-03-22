import sys

N=int(sys.stdin.readline())
P=[list(map(int,sys.stdin.readline().split())) for i in range(N)]
c1=0 # 하얀색 종이
c2=0 # 파란색 종이

def f(x,y,n): # 시작지점과 한 변의 길이
    global c1, c2
    s=sum([sum(P[i][x:x+n]) for i in range(y,y+n)]) # 지정된 구역의 숫자합
    if s==0: # 합이 0이면 전부 0이므로 하얀색 종이
        c1+=1
        return
    
    if s==n**2: # 합이 n**2이면 전부 1이므로 파란색 종이
        c2+=1
        return

    n=n//2 # 길이를 반으로
    f(x,y,n)
    f(x+n,y,n)
    f(x,y+n,n)
    f(x+n,y+n,n)

f(0,0,N)

print(c1)
print(c2)