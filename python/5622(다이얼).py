alphabet="   ABC DEF GHI JKL MNO PQRS TUV WXYZ"
S=input()
c=0

for i in range(len(S)):
    for j in range(len(alphabet)):
        if alphabet[j]==S[i]:
            break
        elif alphabet[j]==' ':
            c+=1
            
print(c)


alphabet="   ABC DEF GHI JKL MNO PQRS TUV WXYZ"
S=input()
T=0

for i in range(len(S)):
    T+=alphabet[:alphabet.find(S[i])].count(" ")

print(T)