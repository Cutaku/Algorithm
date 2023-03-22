K=int(input())

def H(n,a,c): # n개의 블록을 a에서 c로 이동
    b=6-a-c

    if n==1:
        print(a,c)
        return
    
    H(n-1,a,b) # 먼저 n-1개를 a에서 b로 이동시켜놓고
    print(a,c) # n번째 블록을 a에서 c로 이동
    H(n-1,b,c) # 마지막으로 b로 옮겨놓은 n-1개의 블록을 다시 c로 이동
    return

print(2**K-1)
H(K,1,3)