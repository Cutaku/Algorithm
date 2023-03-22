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

P=list(map(prime,range(123456*2+1)))

while 1:
    n=int(input())
    if n==0:
        break

    print(sum(P[n+1:2*n+1]))