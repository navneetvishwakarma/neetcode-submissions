class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int cars = position.length;
        if (cars < 2) return cars;

        Map<Integer, Integer> speedMap = new HashMap<>();
        for (int i = 0; i < cars; i++) {
            speedMap.put(position[i], speed[i]);
        }

        // Arrays.sort(position, Collections.reverseOrder());
        position = Arrays.stream(position)
                                  .boxed() // Convert int to Integer
                                  .sorted(Collections.reverseOrder())
                                  .mapToInt(Integer::intValue) // Convert Integer back to int
                                  .toArray();
        for (int i = 0; i < cars; i++) {
            speed[i] = speedMap.get(position[i]);
        }

        int fleets = 1;
        double prevTime = (double)(target - position[0]) / speedMap.get(position[0]);
        for (int i = 1; i < cars; i++) {
            double timeTaken = (double)(target - position[i]) / speedMap.get(position[i]);
            if (prevTime < timeTaken) {
                fleets++;
                prevTime = timeTaken;
            }
        }

        return fleets;
    }
}
