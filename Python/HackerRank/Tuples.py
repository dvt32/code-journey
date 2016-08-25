# https://www.hackerrank.com/challenges/python-tuples

n = int(input())

my_tuple = input().split(' ')
my_tuple = tuple(map(int, my_tuple))

if len(my_tuple) != n:
    print("Error")
else:
    print(hash(my_tuple))
    
