// https://www.hackerrank.com/challenges/simple-addition-varargs

class Add {
    void add(int ... numbers) {
        StringBuilder output = new StringBuilder();
        int sum = 0;
        for (int number : numbers) {
            sum += number;
            output.append(number).append("+");
        }
        output.deleteCharAt(output.length()-1);
        System.out.println(output + "=" + sum);
    }
}
