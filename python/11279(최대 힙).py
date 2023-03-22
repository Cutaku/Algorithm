# 모듈 없이 풀이

import sys

N=int(sys.stdin.readline())
A=[0] # 인덱스를 1부터 사용하기 위해

for n in range(N):
    num=int(sys.stdin.readline())
    
    if num!=0: # 입력된 수가 0이 아닌경우 힙에 수를 추가
        A.append(num) # 우선 가장 마지막 노드에 이어서 추가
        p= len(A)-1 # 추가된 수의 현재 위치

        while p>1 and A[p]>A[p//2]: # p=1인 경우 루트 노드이므로 정지
                                    # 자식 노드의 수가 부모 노드의 수보다 큰 경우 위치를 교환
            A[p]=A[p//2]
            A[p//2]=num
            p=p//2 # 이동한 수의 위치를 갱신

    else: # 입력된 수가 0인 경우 힙의 최대값을 출력
        if len(A)==1: # 힙이 비어있는 경우(인덱스 0은 고려x) 0을 출력
            print(0)
        else:
            print(A[1]) # 최대값(루트 노드의 값)을 출력
            A[1]=A[-1] #마지막 노드의 수를 루트 노드로 이동
            a=A.pop()
            p,q=1,2 # 이동한 수의 위치와 그 자식 노드
            
            while len(A)>q: # 자식 노드가 하나 이상 존재할 경우
                if len(A)>q+1 and A[q]<A[q+1]: # 자식 노드가 두개 있는 경우 더 큰 값을 선택
                    q+=1

                if A[p]>=A[q]: # 부모 노드가 크거나 같은 경우 정지
                    break
                else: # 자식 노드가 더 큰 경우 위치를 교환
                    A[p]=A[q]
                    A[q]=a
                    p=q # 이동한 수의 위치를 갱신
                    q*=2 # 이동한 위치에서 자식 노드 선택

'''

# heapq 모듈을 사용한 풀이

import sys
import heapq # 최소 힙 자료구조를 제공

N=int(sys.stdin.readline())
A=[]

for n in range(N):
    num=-int(sys.stdin.readline()) # 최대 힙을 만들어야하므로 입력한 수의 부호를 바꿈
    if num==0:
        try:
            print(-heapq.heappop(A)) # 입력할 때 부호를 바꿨으므로 출력할 때 다시 부호를 바꿈
        except: # 힙이 비어있는 경우
            print(0)

    else:
        heapq.heappush(A,num)
'''