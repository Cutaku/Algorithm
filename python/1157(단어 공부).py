S=input().upper()
L=[0]*26

for i in range(len(S)):
    L[ord(S[i])-65]+=1

det=0
index=0
m=0

for i in range(26):
    if m==L[i]:
        det=1
    elif m<L[i]:
        det=0
        index=i
        m=L[i]

if det:
    print('?')
else:
    print(chr(index+65))