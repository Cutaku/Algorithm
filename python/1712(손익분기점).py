A,B,C=map(int,input().split())
D=C-B

if D>0:
    print(A//D+1)
else:
    print(-1)