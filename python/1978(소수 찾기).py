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

N=int(input())

print(sum(map(prime,map(int,input().split()))))