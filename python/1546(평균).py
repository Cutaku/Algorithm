N=int(input())
score=list(map(int,input().split()))

print(100*sum(score)/max(score)/N)