import sys
d=10**9

N=int(sys.stdin.readline())

# S[i]: i로 끝나는 계단수의 수
# i=10은 계산의 편의를 위해 0으로 설정
# N=1인 경우
S=[0,1,1,1,1,1,1,1,1,1,0]

# 길이가 n이고 1<=i<=8로 끝나는 계단수의 수 = 길이가 n-1이고  i-1, i+1로 끝나는 계단수의 수의 합
# i가 0 또는 9인 경우는 각각 길이가 n-1이고 1, 8로 끝나는 계단수의 수 그대로
for i in range(N-1):
    temp=[0]*11
    for j in range(10):
        temp[j]=(S[j-1]+S[j+1])%d
    S=temp

print(sum(S)%d)