# https://www.hackerrank.com/challenges/bash-tutorials---arithmetic-operations

read expression

printf "%.3f" $(echo "$expression" | bc -l)
