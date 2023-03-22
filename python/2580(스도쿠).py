# Python3로 제출하면 시간초과 나와서 Pypy3로 제출

import sys

S=[list(map(int,sys.stdin.readline().split())) for i in range(9)]
S_t=[[0]*9 for i in range(9)] # S transpose -> 열에 같은 수가 있는지 판단하는데 사용
T=[[[] for i in range(3)] for j in range(3)] # 3x3 영역에 같은 수가 있는지 판단하는데 사용
for i in range(9):
    for j in range(9):
        S_t[i][j]=S[j][i]
        if S[i][j]!=0:
            T[i//3][j//3].append(S[i][j])

sum=sum([sum(S[i]) for i in range(9)])
det=0

def f():
    global det, sum
    if det==1: # 하나만 출력하기 위해
        return
    
    if sum==405: # 스도쿠가 모두 채워지면 숫자 합니 405가 됨
        for i in range(9):
            print(*S[i])
        det=1
        return

    for i in range(9):
        for j in range(9):
            if S[i][j]==0:
                I=i//3
                J=j//3

                for k in range(1,10):

                    # 같은 행, 열, 3x3 영역에 k가 없는 경우
                    if not (k in S[i] or k in S_t[j] or k in T[I][J]): 
                        S[i][j]=k
                        S_t[j][i]=k
                        T[I][J].append(k)
                        sum+=k
                        f()
                        S[i][j]=0
                        S_t[j][i]=0
                        T[I][J].pop()
                        sum-=k
                return

f()



'''

import sys

Sudoku=[list(map(int,sys.stdin.readline().split())) for i in range(9)]

R=[[0]*10 for i in range(9)]
C=[[0]*10 for i in range(9)]
S=[[[0]*10 for i in range(3)] for j in range(3)]
c=0
det=0

for i in range(9):
    for j in range(9):
        if Sudoku[i][j]:
            n=Sudoku[i][j]
            R[i][n]=1
            C[j][n]=1
            S[i//3][j//3][n]=1
            c+=1

def f():
    global c, det

    if det:
        return

    if c==81:
        det=1
        for i in range(9):
            print(*Sudoku[i])
        return

    for i in range(9):
        for j in range(9):
            if not Sudoku[i][j]:
                I=i//3
                J=j//3
                for k in range(1,10):
                    if not R[i][k] and not C[j][k] and not S[I][J][k]:
                        Sudoku[i][j]=k
                        R[i][k]=1
                        C[j][k]=1
                        S[I][J][k]=1
                        c+=1
                        f()
                        Sudoku[i][j]=0
                        R[i][k]=0
                        C[j][k]=0
                        S[I][J][k]=0
                        c-=1
                return

f()

'''