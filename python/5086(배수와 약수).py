import sys

while 1:
    A,B=map(int,sys.stdin.readline().split())
    
    if A==0 and B==0:
        break

    if B%A==0: # 1
        print("factor")
    elif A%B==0: # 2
        print("multiple")
    else: # 3
        print("neither")