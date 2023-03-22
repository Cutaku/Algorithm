A,B=map(int,input().split())
B+=int(input())
T=list(range(24))*2

A+=B//60
B=B%60

print(T[A],B)