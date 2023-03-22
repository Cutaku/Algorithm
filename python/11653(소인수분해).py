N=int(input())
n=2

while N>=n:
    if N%n==0:
        N=N//n
        print(n)
    else:
        n+=1