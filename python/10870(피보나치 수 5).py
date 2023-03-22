# 재귀 문제

n=int(input())

def p(n):
    if n==0:
        return 0
    
    if n==1:
        return 1

    return p(n-2)+p(n-1)

print(p(n))