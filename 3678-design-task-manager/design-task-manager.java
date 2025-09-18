import java.util.*;

class TaskManager {
    private static class TaskInfo {
        int userId;
        int priority;
        TaskInfo(int u, int p) {
            this.userId = u;
            this.priority = p;
        }
    }
    private static class TaskEntry {
        int taskId;
        int priority;
        TaskEntry(int t, int p) {
            this.taskId = t;
            this.priority = p;
        }
    }
    private final Comparator<TaskEntry> entryComparator = (a, b) -> {
        if (a.priority != b.priority) {
            return Integer.compare(b.priority, a.priority);
        }
        return Integer.compare(b.taskId, a.taskId);
    };
    private final Map<Integer, TaskInfo> taskMap;
    private final PriorityQueue<TaskEntry> pq;
    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        pq = new PriorityQueue<>(entryComparator);
        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            add(userId, taskId, priority);
        }
    }
    public void add(int userId, int taskId, int priority) {
        TaskInfo ti = new TaskInfo(userId, priority);
        taskMap.put(taskId, ti);
        pq.offer(new TaskEntry(taskId, priority));
    }
    public void edit(int taskId, int newPriority) {
        TaskInfo ti = taskMap.get(taskId);
        if (ti != null) {
            ti.priority = newPriority;
            pq.offer(new TaskEntry(taskId, newPriority)); 
        }
    }
    public void rmv(int taskId) {
        taskMap.remove(taskId); 
    }
    public int execTop() {
        while (!pq.isEmpty()) {
            TaskEntry top = pq.peek();
            TaskInfo ti = taskMap.get(top.taskId);
            if (ti == null) {
                pq.poll();
            } else if (ti.priority != top.priority) {
                pq.poll();
            } else {
                pq.poll();
                taskMap.remove(top.taskId);
                return ti.userId;
            }
        }
        return -1;
    }
}