class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(0);
        visited.add(0);
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            List<Integer> keys = rooms.get(cur);
            for (int i : keys) {
                if (visited.contains(i)) continue;
                q.offer(i);
                visited.add(i);
            }
        }
        return rooms.size() == visited.size();
    }
}
