# 재귀함수로 풀이

N=int(input())

def fact(n):
    if not n:
        return 1
    
    return n*fact(n-1)

print(fact(N))