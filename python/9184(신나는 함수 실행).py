import sys

# 동일한 계산을 반복하지 않도록 이전에 계산한 값을  W에 저장함 -> 메모이제이션(memoization)
# 처음엔 초기값을 0으로 설정했었는데 실제 함수값이 0일 경우 다시 계산해야하는 경우가 있을것 같아서 'x'로 변경함
W=[[['x']*21 for i in range(21)] for j in range(21)]

for i in range(21):
    for j in range(21):
        for k in range(21):
            if i*j*k==0: 
                W[i][j][k]=1

def w(a,b,c):
    if a<=0 or b<=0 or c<=0:
        return 1
    elif a>20 or b>20 or c>20:
        return w(20,20,20)
    else:
        
        # W[a][b][c]가 이미 계산되어 W에 저장되어있을 경우 그대로 출력함
        if W[a][b][c]!='x': # 마찬가지로 처음엔 if W[a][b][c]: 로 했으나 변경함
            return W[a][b][c]
        
        # 계산되어 있지 않은 경우 재귀함수를 이용해 계산
        else:
            if a<b<c:
                W[a][b][c]=w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c)
            else:
                W[a][b][c]=w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1)
            return W[a][b][c]

while 1:
    a,b,c=map(int,sys.stdin.readline().split())
    if a==-1 and b==-1 and c==-1:
        break

    print("w(%d, %d, %d) = %d" %(a,b,c,w(a,b,c)))