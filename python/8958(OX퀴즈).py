import sys

T=int(sys.stdin.readline())

for t in range(T):
    ans=sys.stdin.readline()
    s=1
    l=len(ans)
    score=0

    for i in range(l):
        if ans[i]=='O':
            score+=s
            s+=1
        else:
            s=1
    print(score)