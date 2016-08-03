# https://www.hackerrank.com/challenges/bash-tutorials---more-on-conditionals

read X
read Y
read Z

if (( $X == $Y && $X == $Z && $Y == $Z )); then
    echo "EQUILATERAL"
elif (( $X == $Y || $X == $Z || $Y == $Z )); then
    echo "ISOSCELES"
else
    echo "SCALENE"
fi
