// https://leetcode.com/problems/k-closest-points-to-origin/

class Solution {
    
    private class Point 
        implements Comparable<Point> 
    {
        private int x;
        private int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
        
        // https://en.wikipedia.org/wiki/Euclidean_distance#Two_dimensions
        public double getEuclideanDistance() {
            return Math.sqrt( this.getX() * this.getX() + this.getY() * this.getY() );
        }
        
        @Override
        public int compareTo(Point otherPoint) {
            double distance1 = this.getEuclideanDistance();
            double distance2 = otherPoint.getEuclideanDistance();
            return Double.compare(distance1, distance2);
        }
    }
    
    public int[][] kClosest(int[][] points, int K) {
        Point[] pointData = new Point[points.length];
        
        for (int i = 0; i < points.length; ++i) {
            int x = points[i][0];
            int y = points[i][1];
            pointData[i] = new Point(x, y);
        }
        
        Arrays.sort(pointData);
        
        int[][] result = new int[K][2];
        for (int i = 0; i < K; ++i) {
            result[i][0] = pointData[i].getX();
            result[i][1] = pointData[i].getY();
        }
        
        return result;
    }
    
}
