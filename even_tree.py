# a solution to https://www.hackerrank.com/challenges/even-tree on hackerrank
import sys 

def get_children(graph, u, parent = None):
    res = []
    for x in range(1, len(graph)):
        if graph[u][x] == True and x != parent:
            res.append(x)
    return res

def count_nodes(graph, r, parent, child_count_seq):
    child_list = get_children(graph, r, parent)
    children_count_list = [count_nodes(graph, c, r, child_count_seq) for c in child_list]
    child_count_seq[r] = 1 + sum(children_count_list)
#    print("h: " + str(r) + " " + str(child_count_seq[r]))
    return child_count_seq[r]
    
if __name__ == '__main__':
    line1 = sys.stdin.readline().strip().split()
    N = int(line1[0]) # N is number of vertices
    M = int(line1[1])# M is number of edges
    graph = [[False for j in range(N+1)] for i in range(N+1)]
    for e_i in range(M):
        edge_line = sys.stdin.readline().strip().split()
        u, v = int(edge_line[0]), int(edge_line[1])
        graph[u][v] = True
        graph[v][u] = True
    child_count_seq = [None for i in range(N + 1)]
    count_nodes(graph, 1, None, child_count_seq)
    res = 0
    #print(child_count_seq)
    #print('test1: ' + str(get_children(graph, 8, 6)))
    for i in range(len(child_count_seq)):
        x = child_count_seq[i]
        if x != None and i != 1 and x % 2 == 0:
            res += 1

    print(res)
