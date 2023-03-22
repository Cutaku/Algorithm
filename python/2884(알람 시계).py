H,M=map(int,input().split())
T=list(range(24))

if M>=45:
    print(H,M-45)
else:
    print(T[H-1],M+15)