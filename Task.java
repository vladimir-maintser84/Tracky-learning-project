import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

public class Task {
    private String name;
    private int id;
    private LocalDate startingTime;
    private LocalDate finishTime;
    private String priority;
    private String tag;
    private boolean isDone;

    public Task(String name, int id, String tag, String priority, LocalDate startingTime) {
        this.tag = tag;
        this.priority = priority;
        this.startingTime = startingTime;
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalDate startingTime) {
        this.startingTime = startingTime;
    }

    public void setFinishTime(LocalDate finishTime) {
        this.finishTime = finishTime;
    }

    public Map getPeriod() {
        Map<String, Integer> totalTime = new HashMap<>();
        if (this.finishTime == null) {
            totalTime.put("Days: ", 0);
            totalTime.put("Months: ", 0);
            totalTime.put("Years: ", 0);
        }
        else {
            Period p = Period.between(this.startingTime, this.finishTime);
            totalTime.put("Days: " , p.getDays());
            totalTime.put("Months: " , p.getMonths());
            totalTime.put("Years: " , p.getYears());
        }
            return totalTime;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "The task : " + this.name + " with id: " + this.id +
                "\n startingTime: " + this.startingTime +
                "\n finishTime: " + this.finishTime +
                "\n Time used: "+ getPeriod().toString() +
                "\n priority: " + this.priority +
                "\n tag: " + this.tag +
                "\n isDone: " + this.isDone + "\n ";
    }
}
