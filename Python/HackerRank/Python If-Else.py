# https://www.hackerrank.com/challenges/py-if-else

#!/bin/python3

import sys

N = int(input().strip())

if N % 2 == 1:
    print("Weird")
elif N in range(2, 6):
	print("Not Weird")
elif N in range(6, 21):
	print("Weird")
else:
	print("Not Weird")
