import sys

N=int(sys.stdin.readline())

# 맨 앞에 0을 넣어 길이를 N+1로 하는 이유
# 1. 계단 숫자와 맞추기 위해
# 2. N이 1인 경우 인덱스 오류가 나지 않게 하기위해
score=[0]+[int(sys.stdin.readline()) for i in range(N)]
Max=[0]*(N+1)

# N-1번째 계단을 밟는 경우와 밟지 않는 경우 두가지로 나눠 생각
# 밟지 않는 경우 N-2까지 얻을 수 있는 점수의 최대값에 N번째 계단의 점수를 더함
# 밟는 경우 N-2번째 계단을 밟을 수 없고, N-3번째까지 얻을 수 있는 점수의 최대값에 N-1, N번째 계단의 점수를 더함
# i가 1,2인 경우 인덱스가 음수가 되는데 초기값을 0으로 설정했으므로 상관 없음
for i in range(1,N+1):
    Max[i]=score[i]+max(Max[i-2], score[i-1]+Max[i-3])

print(Max[N])