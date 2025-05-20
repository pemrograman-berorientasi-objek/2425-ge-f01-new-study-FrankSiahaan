package pbo;

import pbo.model.*;

import javax.persistence.*;
import java.util.*;
import java.util.Scanner;

public class App {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("study_plan_pu");
        entityManager = entityManagerFactory.createEntityManager();

        Exec Exec = new Exec(entityManager);
        Scanner input = new Scanner(System.in);

        Exec.cleanTable();

        while (input.hasNext()) {
            String inputs = input.nextLine();
            if (inputs.equals("---")) {
                break;
            } else {
                String data[] = inputs.split("#");
                switch (data[0]) {
                    case "student-add":
                        Exec.addStudent(data);
                        break;
                    case "course-add":
                        Exec.addCourse(data);
                        break;
                    case "student-show-all":
                        Exec.showStudent();
                        break;
                    case "course-show-all":
                        Exec.showCourse();
                        break;
                    case "enroll":
                        Exec.Enroll(data);
                        break;
                    case "student-show":
                        Exec.showNim(data);
                        break;
                    default:
                        break;
                }
            }
        }

        input.close();
        entityManager.close();
        entityManagerFactory.close();

    }
}
