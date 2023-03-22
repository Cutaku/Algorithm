import sys
ip=sys.stdin.readline

n,m = map(int, ip().split())
B=[list(map(int,ip().split())) for _ in range(n)]

M=0
S=0
V=[[0]*7 for _ in range(7)]

D1, D2, D3=[[1,0],[0,1],[-1,0],[0,-1]], [[1,0],[-1,1],[-1,-1]], [[0,1],[-1,-1],[1,-1]]

def f(x,y,c,dx,dy):
    global S,M
    V[dx][dy]=1
    S+=B[x+dx][y+dy]

    if c==3:
        M=max(M,S)
        V[dx][dy]=0
        S-=B[x+dx][y+dy]
        return

    D=D1
    if dx==2: D=D2
    if dy==2: D=D3

    for d in D:
        ddx=dx+d[0]
        ddy=dy+d[1]
        if x+ddx>=0 and y+ddy>=0 and x+ddx<n and y+ddy<m and not V[ddx][ddy]:
            f(x,y,c+1,ddx,ddy)

    V[dx][dy]=0
    S-=B[x+dx][y+dy]

for i in range(n):
    for j in range(m):
        f(i,j,0,0,0)

print(M)


# import sys
# ip = sys.stdin.readline

# n,m=map(int,ip().split())
# B=[list(map(int,ip().split())) for _ in range(n)]

# Tets=[
#     [
#         [[0,0],[0,1],[1,0],[1,1]]
#         ],
#     [
#         [[0,0],[1,0],[2,0],[3,0]]
#         ],
#     [
#         [[0,0],[0,1],[0,2],[0,3]]
#         ],
#     [
#         [[0,0],[1,0],[2,0],[0,1]],
#         [[0,0],[1,0],[2,0],[1,1]],
#         [[0,0],[1,0],[2,0],[2,1]],
#         [[0,1],[1,1],[2,1],[0,0]],
#         [[0,1],[1,1],[2,1],[1,0]],
#         [[0,1],[1,1],[2,1],[2,0]],
#         [[0,0],[1,0],[1,1],[2,1]],
#         [[0,1],[1,1],[1,0],[2,0]]
#         ], 
#     [
#         [[0,0],[0,1],[0,2],[1,0]],
#         [[0,0],[0,1],[0,2],[1,1]],
#         [[0,0],[0,1],[0,2],[1,2]],
#         [[1,0],[1,1],[1,2],[0,0]],
#         [[1,0],[1,1],[1,2],[0,1]],
#         [[1,0],[1,1],[1,2],[0,2]],
#         [[0,0],[0,1],[1,1],[1,2]],
#         [[1,0],[1,1],[0,1],[0,2]]
#         ]   
#     ]

# S=[[1,1],[3,0],[0,3],[2,1],[1,2]]

# M=0

# for i in range(5):
#     for j in range(n-S[i][0]):
#         for k in range(m-S[i][1]):
#             for tets in Tets[i]:
#                 s=0
#                 for T in tets:
#                     s+=B[j+T[0]][k+T[1]]
#                 M=max(M,s)

# print(M)