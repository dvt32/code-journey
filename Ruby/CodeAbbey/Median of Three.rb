# http://www.codeabbey.com/index/task_view/median-of-three

number_of_testcases = gets.to_i 

medians = []

for i in 0...number_of_testcases
  input = gets.chomp.split(' ').map(&:to_i)
  input.sort!
  medians.push(input[1])
end

medians.each {
	|median|
	print "#{median} "
}
