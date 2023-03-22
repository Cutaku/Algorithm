'''
N번째 수가 1인 경우의 수는 N-1까지 2진 수열 개수와 같다
N번째 수가 0 인 경우 N-1 역시 0이어야 하므로 경우의 수는 N-2까지의 2진 수열 개수와 같다
따라서 피보나치 수열이 된다
'''

import sys

N=int(sys.stdin.readline())

T=[0]*1000001
T[1],T[2]=1,2
for i in range(3,N+1):
    T[i]=(T[i-2]+T[i-1])%15746

print(T[N])