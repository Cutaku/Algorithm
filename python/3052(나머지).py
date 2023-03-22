R=[0]*42

for i in range(10):
    n=int(input())
    R[n%42]=1

print(sum(R))