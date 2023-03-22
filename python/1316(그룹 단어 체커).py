import sys

N=int(sys.stdin.readline())
c=0

for i in range(N):
    S=sys.stdin.readline()
    for j in range(1, len(S)):
        if S[j-1]!=S[j] and (S[j]in S[:j-1]): # 직전 문자와 다르고, 이미 나왔었던 문자이면 그룹단어x
            c+=1
            break

print(N-c) # 전체 단어 수에서 그룹 단어가 아닌 단어의 수를 빼기