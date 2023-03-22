S=input()
lst=['c=','c-','dz=','d-','lj','nj','s=','z=']

# 위의 리스트에 있는 알파벳은 'dz='은 3글자, 나머지는 2글자씩
# 문자의 길이에서 'dz='의 개수의 2배, 나머지 개수의 1배를 빼주면 됨
# 'dz='은 'z='을 셀 때도 카운트되므로 리스트의 각 알파벳을 카운트한 뒤 전체 길이에서 제외
count=0
for l in lst:
    count+=S.count(l)

print(len(S)-count)