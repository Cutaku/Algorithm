import sys
from collections import deque as dq

# 테스트 케이스 수
K=int(sys.stdin.readline())

for k in range(K):
	# 이분 그래프인지 확인
    det=1
	
    # vertex, edge의 수
    V,E=map(int,sys.stdin.readline().split())

	# 인접 리스트 구현
    A=[[] for i in range(V+1)]
    for e in range(E):
        u,v=map(int,sys.stdin.readline().split())
        A[u].append(v)
        A[v].append(u)

	# 색 변환을 위한 map
    c={"R":"B","B":"R"}
	
    # 각 점에 칠해진 색을 나타내는 리스트 -> 초기값 0
    C=[0]*(V+1)
	
    # q1 : 현재 단계의 vertices, q2 : 다음 단계의 vertices
    q1, q2=dq([]), dq([])

	# 정점 1부터 탐색
    for i in range(1,V+1):
 
 		# 정점이 칠해져있지 않으면 (즉, 앞의 정점들과 연결x -> 새로운 component)
        # q1에 추가하고 빨간색으로 색칠
        if not C[i]:
            q1.append(i)
            C[i]="R"
            color="B"	# 인접한 정점을 칠하기 위한 색
			
            # q1이 빌 때까지 -> 사실상 q1, q2가 모두 빌 때까지 -> 연결된 모든 정점 탐색
            while q1:
            
            	# q1에서 정점 하나 반환
                v=q1.popleft()

				# v와 연결된 정점 탐색
                for j in A[v]:
					
                    # 색이 칠해져 있지 않은 경우 color(v와 다른색)으로 칠하고 q1에 추가
                    if not C[j]:
                        q2.append(j)
                        C[j]=color
                        
					# color와 다른 색이 칠해여 있는 경우 coloring 실패 -> 이분 그래프x
                    if (C[j]==c[color]):
                        print("NO")
                        det=0
                        break
				
                # while문 탈출
                if not det: break
				
                # q1이 비었을 경우 q1, q2 교체
                # color를 q2의 정점들과 다른 색으로 변경
                if not q1:
                    color=c[color]
                    q1=q2
                    q2=dq([])
		
        # for문 탈출
        if not det: break

	# coloring이 성공했으므로 이분 그래프
    if det: print("YES") 