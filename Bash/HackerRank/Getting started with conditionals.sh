# https://www.hackerrank.com/challenges/bash-tutorials---getting-started-with-conditionals

read character

if [[ $character == 'Y' || $character == 'y' ]]
then 
    echo "YES"
else 
    echo "NO"
fi
