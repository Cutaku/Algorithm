S=input()
D={}
l=len(S)

for i in range(l):
    for j in range(i+1,l+1):
        D[S[i:j]]=1

print(len(D))