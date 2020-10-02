// https://leetcode.com/problems/baseball-game/

class Solution {

    public int calPoints(String[] ops) {
        LinkedList<Integer> roundScores = new LinkedList<>();
        int sum = 0;
        
        for (String op : ops) {
            if (op.equals("C")) {
                sum -= roundScores.removeLast();
            }
            else if (op.equals("D")) {
                roundScores.add( roundScores.getLast() * 2 );
                sum += roundScores.getLast();
            }
            else if (op.equals("+")) {
                roundScores.add(
                    roundScores.getLast() + roundScores.get(roundScores.size()-2)
                );
                sum += roundScores.getLast();
            }
            else {
                roundScores.add(Integer.valueOf(op));
                sum += roundScores.getLast();
            }
        }
        
        return sum;
    }
    
}
