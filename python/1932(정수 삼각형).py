import sys

n=int(sys.stdin.readline())
m=[0,0]
# 바깥쪽에 0들을 추가해서 경우를 따로 구분하지 않아도 되도록 함
for i in range(n):
    nums=list(map(int,sys.stdin.readline().split()))
    temp=[0]*(i+3)
    for j in range(1,i+2):
        temp[j]=nums[j-1]+max(m[j-1:j+1])
    m=temp

print(max(m))