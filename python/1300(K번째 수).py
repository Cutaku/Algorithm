import sys

N,K=int(sys.stdin.readline()), int(sys.stdin.readline())


# 배열 내에 s보다 작은 수가 K개 미만인 s 중 최대값을 구함
# n을 K번째 수라고 할 때, 배열 내에 n 보다 작은 수의 개수 < K (K-1이 아닐 수도 있음)
# 배열 내에 n+1보다 작은 수의 개수 >=K
# 따라서 s=n

def bin(s,e): # s는 조건을 만족, e는 조건 만족x
    if e-s==1: # s가 조건을 만족하는 최대값
        return s

    m=(s+e)//2
    sum=0
    for i in range(1,N+1):
        sum+=min(N,(m-1)//i) # 각 행에서 m보다 작은 수의 개수를 더하기
        if sum>=K: # m보다 작은 수가 K개 이상
            break
    
    if sum>=K:
        return bin(s,m)
    else:
        return bin(m,e)


# 자명하게 1은 조건을 만족하고 N**2+1은 조건을 만족하지 않음
print(bin(1,N**2+1))