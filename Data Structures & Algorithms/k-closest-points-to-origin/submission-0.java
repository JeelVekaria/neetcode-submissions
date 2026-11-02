class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // max heap to store shortest k distance
        PriorityQueue<Double> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        // hashmap distance to point
        Map<Double, ArrayList<Integer[]>> map = new HashMap<>();

        int[][] res = new int[k][2];
        for(int[] point: points) {
            int x = point[0];
            int y = point[1];

            double distance = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
            map.put(distance, map.getOrDefault(distance, new ArrayList<>()));
            map.get(distance).add(new Integer[]{x,y});
            maxheap.add(distance);

            if(maxheap.size()>k) {
                double dist = maxheap.poll();
                map.get(dist).remove(map.get(dist).size()-1);
                if(map.get(dist).size()==0) map.remove(dist);
            }
        }
        int i=0;
        for(ArrayList<Integer[]> values: map.values()) {
            for(Integer[] p: values) {
                res[i][0] = p[0];
                res[i][1] = p[1];
                i++;
            }
        }
        return res;
    }
}