# http://www.codeabbey.com/index/task_view/rounding

number_of_testcases = gets.to_i

output = Array.new

for i in 0...number_of_testcases
  pair = gets.chomp.split(' ').map { |e| e.to_f }
  result = (pair[0] / pair[1]).round
  output.push(result)
end

output.each {
	|number|
	print number.to_s + " "
}
