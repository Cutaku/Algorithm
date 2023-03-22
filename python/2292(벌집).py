N=int(input())
n=1
c=0

while N>0:
    N-=n
    c+=1
    n=6*c

print(c)