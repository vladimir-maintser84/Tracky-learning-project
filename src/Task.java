import java.time.*;
import java.util.HashMap;
import java.util.Map;

public class Task {
    private String name;
    private int id;
    private LocalDateTime startingDateTime;
    private LocalDateTime finishDateTime;
    private String priority;
    private String tag;
    private boolean isDone;

    public Task(String name, int id, String tag, String priority, LocalDateTime startingDateTime) {
        this.tag = tag;
        this.priority = priority;
        this.startingDateTime = LocalDateTime.now();
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

    public void setFinishDate() {
        this.finishDateTime = LocalDateTime.now();
    }


    public Map<String, Long> getPeriod() {
        Map<String, Long> totalTime = new HashMap<>();
        if (this.finishDateTime == null) {
            totalTime.put("Days: ", 0L);
            totalTime.put("Months: ", 0L);
            totalTime.put("Years: ", 0L);
            totalTime.put("Hours: ", 0L);
            totalTime.put("Minutes: ", 0L);
            totalTime.put("Seconds: ", 0L);

        }
        else {
            LocalDate startDate = startingDateTime.toLocalDate();
            LocalDate endDate = finishDateTime.toLocalDate();
            Period period = Period.between(startDate, endDate);

            Duration d = Duration.between(startingDateTime, finishDateTime);

            totalTime.put("Days: ", (long) period.getDays());
            totalTime.put("Months: ", (long) period.getMonths());
            totalTime.put("Years: ", (long) period.getYears());
            totalTime.put("Seconds: ", (long) d.toSecondsPart());
            totalTime.put("Minutes: ", (long) d.toMinutesPart());
            totalTime.put("Hours: ", d.toHours());
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

    public void markAsDone(boolean done) {
        isDone = done;
        this.finishDateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "The task : " + this.name + " with id: " + this.id +
                "\n startingTime: " + this.startingDateTime +
                "\n finishTime: " + this.startingDateTime +
                "\n Time used: "+ getPeriod().toString() +
                "\n priority: " + this.priority +
                "\n tag: " + this.tag +
                "\n isDone: " + this.isDone + "\n ";
    }
}
