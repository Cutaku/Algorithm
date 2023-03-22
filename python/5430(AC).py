import sys
from collections import deque

T=int(sys.stdin.readline())
for t in range(T):
    try: # 오류가 나는 경우(배열에 있는 수의 개수보다 함수 D의 개수가 더 많은 경우) error 출력
        p=sys.stdin.readline().strip()
        n=int(sys.stdin.readline())
        try: # 배열이 비어있는 경우 오류가 나기 때문에 따로 처리
            A=deque(map(int,sys.stdin.readline().strip()[1:-1].split(","))) # 앞 뒤의 "[", "]" 제거 후 "," 로 구분
        except:
            A=deque()
        r=1 # revese 함수를 쓸 경우 시간초과 발생하므로 r을 이용하여 정방향 역방향 설정

        for i in range(len(p)):
            if p[i]=="R":
                r*=-1
            else:
                if r==1: # 정방향일 경우 그대로 첫 번째 수를 버림
                    A.popleft()
                else: # 역방향일 경우 마지막 수를 버림
                    A.pop()
        
        if r==-1:
            A.reverse() # 역방향으로 끝났을 경우 배열을 뒤집어 주기

        print("[" + ",".join(map(str,A)) + "]")

    except:
        print('error')