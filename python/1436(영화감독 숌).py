N=int(input())
Q=[0,1,19,280,3700,10000]

c=1
while N>Q[c]:
    c+=1

nums=[]
for a in range(c):
    b=c-a-1
    for j in range(int(10**(a-1)),10**a):
        for k in range(10**b,2*(10**b)):
            nums.append(int(str(j)+"666"+str(k)[1:]))       

nums=list(set(nums))
nums.sort()
print(nums[N-Q[c-1]-1])