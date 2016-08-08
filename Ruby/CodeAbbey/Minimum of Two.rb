# http://www.codeabbey.com/index/task_view/min-of-two

def min_number(a, b)
    return a < b ? a : b
end

number_of_testcases = gets.to_i
min_numbers = Array.new

for i in 0...number_of_testcases
    pair = gets.chomp.split(' ')
    first_number = pair.first.to_i
    second_number = pair.last.to_i
    min_numbers << min_number(first_number, second_number)
end

min_numbers.each {
    |number|
    print number.to_s + " "
}
