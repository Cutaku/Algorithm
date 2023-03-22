import sys

N=int(sys.stdin.readline())

det=0

for i in range(1,N):
    s=str(i)
    l=len(s)
    num=i
    for j in range(l):
        num+=int(s[j])

    if num==N:
        print(i)
        det=1
        break

if not det:
    print(0)