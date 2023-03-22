import sys
ip=sys.stdin.readline

# 배열을 시계방향으로 90도 회전
def r(S):
    A=[]
    for i in range(3):
       A.append(S[2][i]+S[1][i]+S[0][i]) 
    return A

# 윗면을 시계방향으로 90도 회전
def s():
    global U,D,F,B,R,L
    U=r(U)
    F[0],R[0],B[0],L[0]=R[0],B[0],L[0],F[0]

# x축 90도 회전
def x():
    global U,D,F,B,R,L
    F,D,B,U,R,L=D,r(r(B)),r(r(U)),F,r(R),r(r(r(L)))

# z축 90도 회전
def z():
    global U,D,F,B,R,L
    F,D,B,U,R,L=r(F),r(R),r(r(r(B))),r(L),r(U),r(D)

# 각 면을 시계방향으로 90도씩 n번 회전
def u(n):
    for i in range(n): s()

def d(n):
    x()
    x()
    for i in range(n): s()
    x()
    x()

def f(n):
    x()
    for i in range(n): s()
    x()
    x()
    x()

def b(n):
    x()
    x()
    x()
    for i in range(n): s()
    x()

def l(n):
    z()
    for i in range(n): s()
    z()
    z()
    z()

# 함수명 중복이라 rr로 표현
def rr(n):
    z()
    z()
    z()
    for i in range(n): s()
    z()

# 테스트 케이스 수
T=int(ip())

for t in range(T):
    n=int(ip())
    O=ip().split()

	# 큐브의 6개의 면
    U=["www","www","www"]
    D=["yyy","yyy","yyy"]
    F=["rrr","rrr","rrr"]
    B=["ooo","ooo","ooo"]
    L=["ggg","ggg","ggg"]
    R=["bbb","bbb","bbb"]

    for o in O:
        if o[1]=="+": m=1	# + 이면 시계 방향 90도
        else: m=3			# - 이면 반시계 방향 90도 = 시계 방향 270도(=90도x3)

        if o[0]=="U": u(m)
        elif o[0]=="D": d(m)
        elif o[0]=="F": f(m)
        elif o[0]=="B": b(m)
        elif o[0]=="L": l(m)
        else: rr(m)

    for a in U:
        print(a)