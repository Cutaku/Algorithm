import sys


# dfs를 통해 인접해있는 집들을 모두 구함
def dfs(i,j): # i,j 위치에 있는 집에서부터 시작
    global c
    c+=1
    V[i][j]=1


    # 상하좌우 인접해 있는 집들을 확인
    # for문으로 돌리는게 나을 것 같음

    try: # i=N인 경우 인덱스 오류가 발생
        if M[i+1][j] and not V[i+1][j]:
            dfs(i+1,j)
    except:
        pass
    try:
        if M[i][j+1] and not V[i][j+1]:
            dfs(i,j+1)
    except:
        pass
    if i!=0 and M[i-1][j] and not V[i-1][j]:
        dfs(i-1,j)
    if j!=0 and M[i][j-1] and not V[i][j-1]:
        dfs(i,j-1)

N=int(sys.stdin.readline())
M=[list(map(int, list(sys.stdin.readline().strip()))) for i in range(N)]

V=[[0]*N for i in range(N)] # 방문 여부
c_danji=0 # 단지의 개수
v_danji=[] # 각 단지에 속하는 집의 수

for i in range(N):
    for j in range(N):
        if M[i][j] and not V[i][j]:
            c_danji+=1
            c=0
            dfs(i,j)
            v_danji.append(c)

v_danji.sort() # 오름차순으로 정렬

print(c_danji)
for v in v_danji:
    print(v)