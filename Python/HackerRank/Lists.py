# https://www.hackerrank.com/challenges/python-lists

L = []

ARRAY_NAME = "L"

N = int(input())

for i in range(0, N):
    line = input().split(' ')
    operation_name = line[0]
    if operation_name == "print":
    	expression = "print(" + ARRAY_NAME + ")"
    	eval(expression)
    elif len(line) == 1:
        expression = ARRAY_NAME + "." + operation_name + "()"
        eval(expression)
    elif len(line) == 2:
        argument = line[1]
        expression = ARRAY_NAME + "." + operation_name + "(" + argument + ")"
        eval(expression)
    elif len(line) == 3:
        first_argument = line[1]
        second_argument = line[2]
        expression = ARRAY_NAME + "." + operation_name + "(" + first_argument + ", " + second_argument + ")"
        eval(expression)
