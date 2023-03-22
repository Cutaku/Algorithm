import sys

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

T=int(sys.stdin.readline())

for t in range(T):
    n=int(sys.stdin.readline())
    m=n//2
    
    for i in range(m):
        if prime(m-i) and prime(m+i):
            print(m-i,m+i)
            break