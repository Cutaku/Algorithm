import sys

m=0
index=-1

for i in range(9):
    num=int(sys.stdin.readline())
    if num>m:
        m=num
        index=i+1

print(m)
print(index)