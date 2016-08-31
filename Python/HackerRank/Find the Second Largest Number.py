# https://www.hackerrank.com/challenges/find-second-maximum-number-in-a-list

N = int(input())
line_of_numbers = input().split(' ')

# Extract numbers from input line and add them to list
A = []
for i in range(N):
    A.append(int(line_of_numbers[i]))
    
# Sort list and get largest value from it
A.sort()
max_number = A[-1]

# Remove all instances of the largest value from the list
while (A[-1] == max_number):
    A.pop()

# Print the list's last element, which is now the 2nd largest value    
print(A[-1])
