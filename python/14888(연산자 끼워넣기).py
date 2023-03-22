import sys

N=int(sys.stdin.readline())
A=list(map(int,sys.stdin.readline().split()))
A.reverse() # 끝에서부터 꺼내쓰기위해
A_u=[] # A에서 사용된 수를 저장
O=list(map(int,sys.stdin.readline().split())) # operation
result=[]

def operation(i,a,b):
    if i==0:
        return a+b
    elif i==1:
        return a-b
    elif i==2:
        return a*b
    else:
        if a<0:
            return -(-a//b)
        else:
            return a//b

ans=A.pop()
count=1 # 사용된 수의 개수

def f():
    global ans , count
    if count==N:
        result.append(ans)
        return
    
    for i in range(4):
        if O[i]>0:
            temp=ans
            A_u.append(A.pop())
            ans=operation(i,ans,A_u[-1])
            count+=1
            O[i]-=1
            f()
            ans=temp
            A.append(A_u.pop())
            O[i]+=1
            count-=1

f()

print(max(result))
print(min(result))