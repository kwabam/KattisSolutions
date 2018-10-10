import math

winText= "GET A CRATE OF CHAMPAGNE FROM THE BASEMENT!"
lossText = "RECOUNT!"
uncertainText = "PATIENCE, EVERYONE!"

def bp(x, n):
    return 100 * math.factorial(n) / math.factorial(x) / math.factorial(n-x) * math.pow(.5, n)

for i in range(0,int(input())):
    s = input().split()
    n = int(s[0])
    v1 = int(s[1])
    v2 = int(s[2])
    winThreshold = int(s[3])
    m = n - v1 - v2

    if v2 * 2 >= n:
        print(lossText)
    elif v1 * 2 > n:
        print(winText)
    else:
        neededVotes = (v2 + m - v1)/2 + 1
        successChance = 0;
        for i in range(int(neededVotes), m+1):
            successChance += bp(i, m)
        if successChance > winThreshold:
            print(winText)
        else:
            print(uncertainText)