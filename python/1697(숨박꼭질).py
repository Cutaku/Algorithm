import sys
from collections import deque as dq # 탐색 순서가 상관없으므로 굳이 큐 사용 안해도 됐음

N,K=map(int,sys.stdin.readline().split())

V=[0]*max(2*K-1,N+1) # 수빈이가 방문한 적 있는 지점 
V[N]=1               # N>K인 경우 N+1 이상으로 이동할 필요가 없고 N<K인 경우 2K-1 이상으로 이동할 필요가 없으므로

q1=dq([N]) # 각 시각에 위치할 수 있는 지점
q2=dq([])  # 다음 시각에 위치할 수 있는 지점
c=0 # 시각

while 1:
    q=q1.popleft()
    if q==K: # K에 도달하면 정지
        break

    # c초 후에 위치가 q일 때 c+1초에 위치할 수 있는 지점 탐색
    # q<K인 경우 q-1, q+1, 2q 모두 탐색 (q=0인 경우 제외하고)
    # q>K인 경우 q-1만 탐색

    if q>0 and not V[q-1]:
        q2.append(q-1)
        V[q-1]=1

    if q<K and not V[q+1]:
        q2.append(q+1)
        V[q+1]=1

    if q<K and not V[2*q]:
        q2.append(2*q)
        V[2*q]=1

    # q1이 비었으면 c초 에서 가능한 모든 경우를 확인했으므로 q2를 q1으로 바꿔주고 반복
    if not q1:
        q1=q2
        q2=dq([])
        c+=1

print(c)