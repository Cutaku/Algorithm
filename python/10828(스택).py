import sys

N=int(sys.stdin.readline())
Stack=[]

for i in range(N):
    command=sys.stdin.readline().split()
    if command[0]=="push":
        Stack.append(command[1])
        continue
    elif command[0]=="pop":
        if Stack:  
            print(Stack.pop())
            continue
        else:
            print(-1)
            continue
    elif command[0]=="size":
        print(len(Stack))
        continue
    elif command[0]=="empty":
        print(int(Stack==[]))
        continue
    else:
        if Stack:
            print(Stack[-1])
        else:
            print(-1)