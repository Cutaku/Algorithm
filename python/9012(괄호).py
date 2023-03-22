import sys

T=int(sys.stdin.readline())

for t in range(T):
    s=sys.stdin.readline().strip()
    S=0
    
    for i in range(len(s)):
        if s[i]=="(":
            S+=1
        else:
            S-=1
        
        if S<0:
            break

    if S==0:
        print("YES")
    else:
        print("NO")