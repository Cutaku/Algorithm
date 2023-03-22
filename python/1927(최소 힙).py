# 모듈 없이 풀이
# 11279(최대 힙) 풀이와 동일

import sys

N=int(sys.stdin.readline())
H=[0]

for n in range(N):
    num=int(sys.stdin.readline())

    if num==0:
        if len(H)==1:
            print(0)
        else:
            print(H[1])
            H[1]=H[-1]
            h=H.pop()
            p,q=1,2

            while len(H)>q:
                if len(H)>q+1 and H[q]>H[q+1]:
                    q+=1
                
                if H[p]<=H[q]:
                    break
                else:
                    H[p]=H[q]
                    H[q]=h
                    p=q
                    q*=2
    
    else:
        H.append(num)
        p=len(H)-1

        while p>1 and H[p]<H[p//2]:
            H[p]=H[p//2]
            H[p//2]=num
            p=p//2

'''

import sys
import heapq

N=int(sys.stdin.readline())
H=[]

for n in range(N):
    num=int(sys.stdin.readline())

    if num==0:
        try:
            print(heapq.heappop(H))
        except:
            print(0)

    else:
        heapq.heappush(H,num)

'''