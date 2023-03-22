import sys

while 1:
    try:
        a,b=map(int,sys.stdin.readline().split())
        print(a+b)
    except:
        break