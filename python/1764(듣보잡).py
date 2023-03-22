import sys
ip=sys.stdin.readline

N,M=map(int,ip().split())

L=[] # 먼저 리스트로 받아서 정렬
for i in range(N):
    s=ip().strip()
    L.append(s)
L.sort()

D={} # 딕셔너리 자료형으로
for l in L:
    D[l]=0

for i in range(M): # 중복되는 것만 +1
    s=ip().strip()

    try:
        D[s]+=1
    except:
        pass

print(sum(D.values()))

for d in D:
    if D[d]:
        print(d)