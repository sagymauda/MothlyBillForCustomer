package model;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {


        //    public  double billFor(String month, Subscription activeSubscription, User[] users) {
        Challenge challenge = new Challenge();
        Subscription subscription = new Subscription(1, 1, 4);

        LocalDate activatedOnSagi = LocalDate.of(2019, 1, 1);
        LocalDate deactivatedOnSagi = LocalDate.of(2019, 1, 5);
        LocalDate activatedOnBobi = LocalDate.of(2019, 1, 1);
        LocalDate deactivatedOnBobi = LocalDate.of(2019, 1, 20);
        LocalDate activatedOnNofar = LocalDate.of(2019, 1, 1);
        LocalDate deactivatedOnNofar = LocalDate.of(2019, 1, 30);

        User userSagi = new User(1, "sagi", activatedOnSagi, deactivatedOnSagi, 1);
        User userBobi = new User(2, "bobi", activatedOnBobi, deactivatedOnBobi, 1);
        User userNofar = new User(3, "nofar", activatedOnNofar, deactivatedOnNofar, 1);
        User[] users = new User[]{userSagi, userBobi, userNofar};

        User[] emptyList = new User[0];

        //expecting an answer
        System.out.println(challenge.billFor("2019-01", subscription, users));
        //expecting 0
        System.out.println(challenge.billFor("2019-01", subscription, emptyList));
        //expecting 0
        System.out.println(challenge.billFor("2019-01", null, users));



    }
}
