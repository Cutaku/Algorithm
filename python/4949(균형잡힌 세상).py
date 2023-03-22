import sys

while 1:
    s=sys.stdin.readline().strip()
    S=[]

    if s==".":
        break

    # 소괄호를 0, 대괄호를 1로 / 열릴 때 추가 닫힐 때 제거
    l=len(s)
    for i in range(l):
        if s[i]=="(":
            S.append(0)
        elif s[i]=="[":
            S.append(1)
        elif s[i]==")":
            if S==[] or S[-1]==1: # 괄호가 열려있지 않거나 마지막으로 열린 괄호가 대괄호인 경우
                S=True
                break
        elif s[i]=="]": 
            if S==[] or S[-1]==0: # 마찬가리로 열려있지 않거나 마지막으로 열린 괄호가 소괄호인 경우
                S=True
                break
        
    if S: # 괄호가 열려있지 않은 상태에서 닫은 경우(S=True) 혹은 닫히지 않은 괄호가 남아있는 경우(S!=[])
        print("no")
    else:
        print("yes")