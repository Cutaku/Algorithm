import sys

A,B= list(sys.stdin.readline().strip()), list(sys.stdin.readline().strip())
a,b= len(A),len(B)
C=[0]*(a+1)

# C: A[:j], B[:i] 의 LCS의 길이
for i in range(b):
    temp=[0]*(a+1)
    for j in range(a):
        if A[j]==B[i]: # A[j]와 B[i]가 같은 경우 A[:j-1],B[:i-1]의 LCS에 하나 추가
            temp[j+1]=C[j]+1
        else: # 같지 않은 경우 A[:j-1],B[:i] 와  A[:j],B[:i-1] 의 LCS 중 더 긴 것 선택
            temp[j+1]=max(temp[j],C[j+1])
    C=temp

print(C[-1])