# https://www.hackerrank.com/challenges/nested-list

N = int(input())

# Add each student's information to the list
nested_list = []
for _ in range(N):
    name_of_student = input()
    grade = float(input())
    nested_list.append([name_of_student, grade])

# Get the second lowest grade
all_grades = []
for i in range(N):
	current_grade = nested_list[i][1]
	all_grades.append(current_grade)
all_grades.sort(reverse=True)
min_grade = all_grades[-1]
while (all_grades[-1] == min_grade):
	all_grades.pop()
min_grade = all_grades[-1]
	
# Get name(s) of student(s) with second lowest grade
names = []
for i in range(N):
	current_name = nested_list[i][0]
	if nested_list[i][1] == min_grade:
		names.append(current_name)
names.sort()

# Print name(s) of student(s) with second lowest grade
for i in range(len(names)):
	print(names[i])
