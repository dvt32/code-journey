# https://www.codeeval.com/open_challenges/122/submit/

import sys

dict = { 
	"a" : "0",  
	"b" : "1",
	"c" : "2",
	"d" : "3",
	"e" : "4",
	"f" : "5",
	"g" : "6",
	"h" : "7",
	"i" : "8",
	"j" : "9"
}

with open(sys.argv[1], 'r') as lines_in_file:
	for line in lines_in_file:
		output_string = ""
		for i in range(len(line)):
			current_char = line[i]
			if (current_char in dict):
				output_string += dict[current_char]
			elif (current_char in dict.values()):
				output_string += current_char
		if (len(output_string) == 0):
			output_string = "NONE"
		print(output_string)
