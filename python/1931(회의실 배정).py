import sys

N=int(sys.stdin.readline())
M=[list(map(int,sys.stdin.readline().split())) for i in range(N)]
M=sorted(M, key=lambda x : (x[1],x[0])) # 끝나는 시간을 기준으로 정렬

count=0
e=0 # end time

# 끝나는 시간을 기준으로 정렬했기 때문에 뒤에 있는 회의가 앞의 결과에 영향을 주지 않는다
for m in M:
    if e<=m[0]:
        e=m[1]
        count+=1

print(count)