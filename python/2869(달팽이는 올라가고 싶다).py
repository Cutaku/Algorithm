A,B,V=map(int,input().split())
d=A-B

print((V-A)//d+((V-A)%d!=0)+1)