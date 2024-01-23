class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadend_set = new HashSet<String>();
        for (String deadend : deadends) {
            deadend_set.add(deadend);
        }

        Queue<String> q = new LinkedList<String>();
        HashSet<String> seen = new HashSet();
        q.add("0000");
        q.add(null);
        seen.add("0000");
        int step = 0;
        while (!q.isEmpty()) {
            String wheel = q.poll();
            if (wheel == null) {
                step++;
                if (q.peek() != null)
                    q.offer(null);
                continue;
            } else if (wheel.equals(target)) {
                return step;
            } else if (deadend_set.contains(wheel)) {
                continue;
            } else {
                for (int i = 0; i < 4; i++) {
                    for (int d = -1; d <= 1; d += 2) {
                        String new_wheel = wheel.substring(0, i) + ((wheel.charAt(i) - '0' + d + 10) % 10 + "")
                                + wheel.substring(i + 1);
                        if (!seen.contains(new_wheel)) {
                            seen.add(new_wheel);
                            q.offer(new_wheel);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
