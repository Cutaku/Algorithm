import sys

T=int(sys.stdin.readline())

for t in range(T):
    n=int(sys.stdin.readline())
    T=[] # type
    Q=[] # quantity
    for i in range(n):
        name, type= sys.stdin.readline().split()
        if type in T: # 앞에 나왔던 종류일 경우 개수 추가
            Q[T.index(type)]+=1
        else: # 처음 나왔을 경우 종류에 추가하고 개수 1개 입력
            T.append(type)
            Q.append(1)
    
    # q 개의 의상이 있을 때 경우의수는 q+1 (입지 않는 경우를 포함해서)
    ans=1
    for q in Q:
        ans*=q+1
    print(ans-1) # 모든 종류의 의상 입지 않는 경우 제거