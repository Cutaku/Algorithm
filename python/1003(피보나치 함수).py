import sys

F=[1,0]
T=int(sys.stdin.readline())

'''
fibonacci(n)은 fibonacci(n-1)과 fibonacci(n-2)를 각각 한번 호출함
따라서 fibonacci(n)이 0과 1을 출력하는 횟수는 fibonacci(n-1)과 fibonacci(n-2)가 0과 1을 출력한는 횟수의 합이므로
출력하는 횟수 자체도 피보나치 수열이 됨
'''

for t in range(T):
    print(F)
    N=int(sys.stdin.readline())
    while len(F)<N+2: # 0과 1을 각각 F[N], F[N+1]번 출력하므로 F가 N+2까지의 원소를 가져야한다
        F.append(F[-1]+F[-2])
    print(F[N], F[N+1])