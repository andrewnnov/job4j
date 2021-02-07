package collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );

        System.out.println("Sort by priority");
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);

        //by name
        System.out.println("Sort by name");
        Collections.sort(jobs, new SortByNameJob());
        System.out.println(jobs);
    }
}
