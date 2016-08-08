 # http://www.codeabbey.com/index/task_view/sum-in-loop

sum = 0

total_numbers = gets.to_i	# actually not necessary
numbers_string = gets.chomp

numbers = numbers_string.split(' ')

numbers.each {
	|number|
	sum += number.to_i
}

puts sum
