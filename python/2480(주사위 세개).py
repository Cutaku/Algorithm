a,b,c=map(int,input().split())

print((a==b==c)*(10000+a*1000)+(a==b!=c)*(1000+a*100)+(b==c!=a)*(1000+b*100)+(c==a!=b)*(1000+c*100)+(a!=b)*(b!=c)*(c!=a)*(max(a,b,c)*100))