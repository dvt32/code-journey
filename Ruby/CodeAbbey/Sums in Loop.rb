# http://www.codeabbey.com/index/task_view/sums-in-loop

number_of_pairs = gets.to_i
pair_sums = Array.new

for i in 0...number_of_pairs
    sum = 0
    pair = gets.chomp.split(' ')
    pair_sums << pair.first.to_i + pair.last.to_i
end

pair_sums.each {
	|pair_sum|
	print pair_sum.to_s + " "
}
