import sys

while 1:
    a,b,c=map(int,sys.stdin.readline().split())
    if not a*b*c:
        break
    A,B,C=a**2,b**2,c**2
    if A==B+C or B==C+A or C==A+B:
        print('right')
    else:
        print('wrong')