import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int idCounter = 0;
        FileWriter file = new FileWriter("TrackyFile.txt", true);
        List<Task> tasksList = new ArrayList<>();
        labelWhile: while (true) {
            System.out.println("What do you want to do?: 1. Add new Task; 2. Print all tasks 3. Mark task as done 4. Finish/Leave");
            int userInput;
            try {
                userInput = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input, please enter the valid number: ");
                s.nextLine();
                continue;
            }
            s.nextLine();
            System.out.println("--------------------------------");
            switch (userInput) {
                case 1:
                    System.out.println("Name of the Task: ");
                    String taskName = s.nextLine();
                    int id = idCounter++;
                    System.out.println("Add a tag to your Task: ");
                    String taskTag = s.nextLine();
                    System.out.println("What is priority for your task?: ");
                    String priority = s.nextLine();
                    Task task = new Task(taskName, id, taskTag, priority, LocalDate.now());
                    tasksList.add(task);
                    file.write(task + "\n");
                    break;

                case 2:
                    for (Task t : tasksList) {
                        System.out.println(t);
                    }

                    break;

                case 3:
                    System.out.println("Enter the task id: ");
                    int userID = s.nextInt();
                    if (userID >= 0 && userID < tasksList.size()) {
                        Task isDoneTask = tasksList.get(userID);
                        isDoneTask.setDone(true);
                        isDoneTask.setFinishTime(LocalDate.now());
                    }
                    else {
                        System.out.println("Enter the valid ID");
                        continue;
                    }
                    break;

                case 4:
                    file.close();
                    break labelWhile;
            }
            file.close();
        }

    }
}