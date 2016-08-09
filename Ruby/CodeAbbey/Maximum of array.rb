# http://www.codeabbey.com/index/task_view/maximum-of-array

input = gets.chomp.split(' ').map(&:to_i)

max = input[0]
min = input[0]

for i in 1...300
	max = input[i] if input[i] > max
	min = input[i] if input[i] < min
end

print max.to_s + ' ' + min.to_s
