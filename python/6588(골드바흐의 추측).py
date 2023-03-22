# import sys
# ip=sys.stdin.readline

# c=[0]*1000001
# p=[0]*1000001

# def prime(n):
#     if n==1: return 0
#     if n==2: return 1
#     if n%2==0: return 0

#     for i in range(3, int(n**0.5)+1,2): 
#         if n%i==0: return 0

#     return 1

# while 1:
#     n=int(ip())
#     if n==0: break

#     det=1

#     for i in range(3,n//2+1,2):
#         if not c[i]:
#             c[i]=1
#             p[i]=prime(i)

#         if not c[n-i]:
#             c[n-i]=1
#             p[n-i]=prime(n-i)

#         if p[i] and p[n-i]:
#             print("%d = %d + %d" % (n,i,n-i))
#             det=0
#             break

#     if det: print("Goldbach's conjecture is wrong.")

import sys
ip=sys.stdin.readline

c=1000000
P=[1]*(c+1)	# 소수 판정 리스트

# 에라토스테네스의 체
for i in range(2,c+1):
    if P[i]:	# i가 소수이면
        for j in range(2,c//i+1):
            P[i*j]=0	# i의 배수들을 소수x

while 1:
    n=int(ip())
    
    # 입력값이 0이면 정지
    if n==0: break

	# 골드바흐의 추측이 틀렸을 경우
    det=1
	
    # n이 짝수이므로 n-2는 2보다 큰 짝수 -> 소수x -> 3부터 시작
    # 2보다 큰 짝수는 소수가 아니므로 홀수만 확인
    # i가 n/2보다 큰 경우 앞의 경우와 symmetric 하므로 n/2까지만 확인
    for i in range(3,n//2+1,2):
        if P[i]*P[n-i]:	# i와 n-i가 모두 소수이면 골드바흐의 추측이 옳은 경우
            print("%d = %d + %d" %(n,i,n-i))
            det=0
            break

    if det: print("Goldbach's conjecture is wrong.")