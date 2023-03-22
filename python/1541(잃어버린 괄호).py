import sys

# 첫번째 '-'가 나오기 전에 숫자들은 모두 더하고 이후 숫자들은 모두 뺀다
S=list(sys.stdin.readline().split("-"))
s=sum(list(map(int,S[0].split("+"))))

for i in range(1,len(S)):
    s-=sum(list(map(int,S[i].split("+"))))

print(s)