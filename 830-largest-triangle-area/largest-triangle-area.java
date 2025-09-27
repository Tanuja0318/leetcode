class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                for (int k = j + 1; k < n; k++) {
                    int x3 = points[k][0], y3 = points[k][1];
                    double area = areaOfTriangle(x1, y1, x2, y2, x3, y3);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    private double areaOfTriangle(int x1, int y1,
                                  int x2, int y2,
                                  int x3, int y3) {
        double cross = (double)(x2 - x1) * (y3 - y1) - (double)(x3 - x1) * (y2 - y1);
        return Math.abs(cross) / 2.0;
    }
}