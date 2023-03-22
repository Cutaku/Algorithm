def f(n):
    sum=n
    for i in range(len(str(n))):
        sum+=int(str(n)[i])
    return sum

L=[1]*10001
for i in range(10001):
    if f(i)<=10000:
        L[f(i)]=0

for i in range(10001):
    if L[i]:
        print(i)