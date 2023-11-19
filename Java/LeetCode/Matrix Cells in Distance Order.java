// https://leetcode.com/problems/matrix-cells-in-distance-order

class Solution {

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        LinkedList<LinkedList<Integer>> ans = new LinkedList<>();

        for (int r1 = 0; r1 < rows; ++r1) {
            for (int c1 = 0; c1 < cols; ++c1) {
                ans.add(new LinkedList<>(
                    Arrays.asList(r1, c1, Math.abs(r1 - rCenter) + Math.abs(c1 - cCenter))
                ));
            }
        }

        Collections.sort(ans, new Comparator<LinkedList<Integer>>() {
            @Override
            public int compare(LinkedList<Integer> t1, LinkedList<Integer> t2) {
                return t1.get(2).compareTo(t2.get(2));
            }
        });

        for (LinkedList<Integer> t : ans) {
            t.removeLast();
        }

        int[][] arr = ans.stream()
            .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
            .toArray(int[][]::new);

        return arr;
    }

}
