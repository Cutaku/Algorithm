def prime(p):
    if p==1:
        return 0
    else:
        n=int((p+1)**(0.5))
        det=1

        for i in range(2,n+1):
            if p%i==0:
                det=0
                break
    return det

M,N=int(input()),int(input())
det=0
s=0
m=N

for i in range(N,M-1,-1):
    if prime(i):
        s+=i
        m=i
        det=1

if det:
    print(s)
    print(m)
else:
    print(-1)