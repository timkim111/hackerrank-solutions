# a solution to https://www.hackerrank.com/challenges/gem-stones on hackerrank
import sys

if  __name__ == "__main__":
    T = int(sys.stdin.readline())
    gems = set()
    for i in range(T):
        s = sys.stdin.readline().strip()
        if i == 0:
            gems = set(list(s))
        else:
            list_gems = list(gems)
            for gem in list_gems:
                if gem not in s:
                    gems.remove(gem)
    print(len(gems))
            
