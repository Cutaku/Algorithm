S=input()
L=[0]*26
for i in range(97,123):
    L[i-97]=S.find(chr(i))

print(*L)