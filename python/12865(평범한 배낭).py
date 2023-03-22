import sys

N,K=map(int,sys.stdin.readline().split())
B=[0]*(K+1)

# 가방에 들어갈 수 있는 무게(j)를 늘려가며 가치합의 최대값을 저장
# 물품을 하나씩 추가하며 갱신 
for i in range(N):
    W,V=map(int,sys.stdin.readline().split())
    temp=B[:]
    for j in range(W,K+1): # 추가된 물품의 무게보다 작은 경우에는 변동이 없음
        temp[j]=max(B[j], B[j-W]+V) # 추가된 물품을 포함하는 경우는 j-W에서 최대합을 갖는 경우에 추가된 물품을 더한 경우
    B=temp                          # 포함하지 않는 경우는 그대로
    
print(B[-1])