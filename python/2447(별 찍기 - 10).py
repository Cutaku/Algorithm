N=int(input())

def f(n):
    if n==1:
        return ['*']

    temp=[0]*n
    m=n//3
    F=f(m)

    for i in range(m):
        temp[i]=F[i]*3

    for i in range(m):
        temp[i+m]=F[i]+' '*m+F[i]

    for i in range(m):
        temp[i+2*m]=F[i]*3

    return temp

for l in f(N):
    print(l)