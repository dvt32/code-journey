# http://www.codeabbey.com/index/task_view/body-mass-index

number_of_people = gets.to_i

bmi_arr = Array.new

for i in 0...number_of_people
  input = gets.chomp.split(' ').map(&:to_f)
  weight = input[0]
  height = input[1]
  bmi = weight / (height ** 2)
  bmi_arr << bmi
end

bmi_arr.each {
	|bmi|
	print "under " if bmi < 18.5
	print "normal " if bmi >= 18.5 && bmi < 25.0
	print "over " if bmi >= 25.0 && bmi < 30.0
	print "obese " if bmi >= 30.0
}
