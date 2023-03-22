n=input()
m=n
c=0

while not c or m!=n:
    if len(m)==1:
        m=str(int(m*2))
    else:
        m=str(int(m[-1]+str(int(m[0])+int(m[1]))[-1]))
    c+=1

print(c)