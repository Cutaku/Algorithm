import sys
ip=sys.stdin.readline

N, M=int(ip()), int(ip())
L=[[] for _ in range(N+1)]

for i in range(M):
    f,t,p = map(int,ip().split())
    L[f].append([t,p])

s,e = map(int,ip().split())

V=[0]*(N+1)
V[s]=1

lim=M*100000+1
M=[lim]*(N+1)
M[s]=0

for l in L[s]:
    M[l[0]]=l[1]

def f(M,V):
    i=0
    m=M[0]

    for j in range(1,len(M)):
        if not V[j] and m>M[j]:
            i=j
            m=M[j]

    return i

n=f(M,V)
V[n]=1

while M[n]<lim:
    print(M)
    for l in L[n]:
        M[l[0]]=min(M[l[0]], M[n]+l[1])

    n=f(M,V)
    V[n]=1

print(M)
print(M[e])