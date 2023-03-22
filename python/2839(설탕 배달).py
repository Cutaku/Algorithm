N=int(input())
c=0

while N>0 and N%5!=0:
    c+=1
    N-=3

if N%5==0:
    print(c+N//5)
else:
    print(-1)