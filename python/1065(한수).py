def han(n):
    if n<100:
        return 1
    L=list(str(n))
    l=len(L)
    det=1
    dif=int(L[1])-int(L[0])

    for i in range(1,l-1):
        det*=(int(L[i+1])-int(L[i])==dif)
    
    return det
    
n=int(input())
ans=0

for i in range(1,n+1):
    ans+=han(i)

print(ans)