n=int(input())
F=[1,1]

while len(F)<n:
    F.append(F[-1]+F[-2])

print(F[-1],n-2)