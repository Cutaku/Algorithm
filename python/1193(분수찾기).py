X=int(input())

n=1

while X>n:
    X-=n
    n+=1

if n%2==0:
    print('%d/%d'%(X,n-X+1))
else:
    print('%d/%d'%(n-X+1,X))