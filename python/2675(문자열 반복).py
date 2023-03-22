import sys

T=int(sys.stdin.readline())

for t in range(T):
    R,S=sys.stdin.readline().split()
    R=int(R)

    ans=''
    for i in range(len(S)):
        ans+=S[i]*R
    
    print(ans)