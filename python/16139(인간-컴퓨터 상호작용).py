import sys
ip=sys.stdin.readline

S=ip().strip()
l=len(S)
L=[[0]*(l+1) for i in range(26)]
for i in range(97,123):
    for j in range(l):
        L[i-97][j+1]=L[i-97][j]+(S[j]==chr(i))

q=int(ip())

for i in range(q):
    Q=list(ip().split())
    a=Q[0]
    l,r=map(int,Q[1:])
    print(L[ord(a)-97][r+1]-L[ord(a)-97][l])