import sys

n=int(sys.stdin.readline())
nums=list(map(int,sys.stdin.readline().split()))
sum=0
max=-1000

# 왼쪽부터 차례대로 더하면서 최대값을 갱신
# 합이 음수가 되면 전부 버림
for num in nums:
    sum+=num
    if sum>max:
        max=sum
    
    if sum<0:
        sum=0

print(max)