package model;

import java.time.LocalDate;

public class Main {

//    private static LocalDate firstDayOfMonth(LocalDate date) {
//        return date.withDayOfMonth(1);
//    }

//   private static Boolean isWithinRange(LocalDate testDate,LocalDate startDate ,LocalDate endDate) {
//        return !(testDate.isBefore(startDate) || testDate.isAfter(endDate));
//    }


    public static void main(String[] args) {


//         LocalDate activatedOn= LocalDate.of(2019, 1, 1);
//         LocalDate deactivatedOn= LocalDate.of(2019, 1, 10);
//        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM");
//        YearMonth ym = YearMonth.parse("2019-01", fmt);
//        int dayOfTheMonth = 4;
//       // System.out.println(ym.lengthOfMonth());
//        LocalDate testedDay = ym.atDay(dayOfTheMonth);
//        System.out.println(testedDay);
//       // System.out.println(isWithinRange(testedDay,activatedOn,deactivatedOn));
//

//        double dailyRate =  (double) ym.lengthOfMonth()/(double) 4;
//        System.out.println(dailyRate);


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


        //System.out.println(localDate);
    }
}
//
//    private static LocalDate firstDayOfMonth(LocalDate date) {
//        return date.withDayOfMonth(1);
//    }
//    public static void main(String[] args) {
//        Calculating invoices for customer billing
//        Background
//        In the past, we provided some raw billing data in JSON format to the finance team, which they used to manually generate monthly invoices for our customers. Recently, they’ve asked us to create some automation to make this process less error-prone.
//
//                Instructions
//        Your goal is to implement the billFor function to calculate the total monthly bill for a customer.
//
//        Customers are billed based on their subscription tier for the month. We charge them a prorated amount for each user who was active during that month.
//
//        You talked with the other engineers on the team and decided that the following algorithm would work:
//
//        Calculate a daily rate for the active subscription tier
//        For each day of the month, identify which users were active that day
//        Multiply the number of active users for the day by the daily rate to calculate the total for the day
//        Return the running total for the month at the end, rounded to 2 decimal places
//        Parameters
//        This billing function accepts the following parameters:
//
//        month
//        Always present. Has the following structure:
//
//        "2019-01"   // January 2019 in YYYY-MM format
//        activeSubscription
//        May be null. If present, has the following structure:
//
//// see Subscription class
//        {
//            id: 1,
//                    customerId: 1,
//                monthlyPriceInDollars: 4, // price per active user per month
//        }
//        users
//        May be empty, but not null. Has the following structure:
//
//// see User class
//[
//        {
//            id: 1,
//                    name: "Employee #1",
//                customerId: 1,
//
//                // when this user started
//                activatedOn: LocalDate.of(2018, 11, 4),
//
//                // last day to bill for user
//                // should bill up to and including this date
//                // since user had some access on this date
//                deactivatedOn: LocalDate.of(2019, 1, 10)
//        },
//        {
//            id: 2,
//                    name: "Employee #2",
//                customerId: 1,
//
//                // when this user started
//                activatedOn: LocalDate.of(2018, 12, 4),
//
//                // hasn't been deactivated yet
//                deactivatedOn: null
//        }
//]
//        Return value
//        This function should return the total monthly bill for the customer, rounded to 2 decimal places.
//
//        If there are no users or the subscription is not present, the function should return 0 since the customer does not owe anything for that month.
//
//        Calculation Examples
//        Here is an example of calculating the amount to bill each customer using the algorithm described above. This example is captured by the "works when a user is activated during the month" test.
//
//                Month	2019-01
//        Subscription tier	$4 / month
//        User activations	2018-11-04
//        2018-12-04
//        2019-01-10 (new this month)
//        User deactivations	None
//        Daily rate is $0.129032258   (this is the monthly rate of $4.00 / 31 days in January)
//
//        2019-01-01  2 active users * $0.129032258 = $0.258064516  (subtotal: $0.258064516)
//        2019-01-02  2 active users * $0.129032258 = $0.258064516  (subtotal: $0.516129032)
//...
//        2019-01-09  2 active users * $0.129032258 = $0.258064516  (subtotal: $2.322580645)
//        2019-01-10  3 active users * $0.129032258 = $0.387096774  (subtotal: $2.709677419)
//        2019-01-11  3 active users * $0.129032258 = $0.387096774  (subtotal: $4.387096772)
//...
//        2019-01-30  3 active users * $0.129032258 = $0.387096774  (subtotal: $10.451612903)
//        2019-01-31  3 active users * $0.129032258 = $0.387096774  (subtotal: $10.838709677)
//
//        Total = $10.84 (round subtotal to nearest cent)
//        Testing
//        The automated tests we provide only cover a few key cases, so you should plan to add some of your own tests or modify the existing ones to ensure that your solution handles any edge cases. You should be able to follow the existing patterns for naming and constructing tests to add your own.
//
//        Notes / Edge cases
//        It’s more important for the return value to be correct than it is for the algorithm to be highly optimized.
//        You can store intermediate results as any kind of decimal type (e.g. float, double). You do not need to round values until the last step.
//                You should bill for all days between and including both the activation and deactivation dates since the user still had some access on the last day.
//        You should not change function names or return types of the provided functions since our test cases depend on those not changing.
//
//        System.out.println(firstDayOfMonth(LocalDate.of(2019, 2, 7)));
//
//
//

//}
