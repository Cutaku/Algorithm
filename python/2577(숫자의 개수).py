n=int(input())
n*=int(input())
n*=int(input())
n=str(n)

l=len(n)
L=[0]*10

for i in range(l):
    L[int(n[i])]+=1

for i in L:
    print(i)