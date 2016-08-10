# http://www.codeabbey.com/index/task_view/fahrenheit-celsius

input = gets.chomp.split(' ').map(&:to_i)
output = Array.new

for i in 1..input.first
  celsius = ((input[i] - 32) * (5/9r)).round
  output << celsius
end

output.each {
  |celsius_value|
  print "#{celsius_value} "
}
