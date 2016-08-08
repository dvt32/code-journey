# http://www.codeabbey.com/index/task_view/min-of-three

def min(a, b)
    return a < b ? a : b
end

def min_of_three(a, b, c);
    return min(min(a, b), min(b, c))
end

number_of_testcases = gets.to_i
minimum_triplets = Array.new

for i in 0...number_of_testcases
    triplet = gets.chomp.split(' ')
    minimum_triplets << min_of_three(triplet[0].to_i, triplet[1].to_i, triplet[2].to_i)
end

minimum_triplets.each {
    |number|
    print number.to_s + " "
}
