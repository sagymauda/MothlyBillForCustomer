package model;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

class Challenge {
    public  double billFor(String month, Subscription activeSubscription, User[] users) {

        //in case no active subscribers
        if (activeSubscription == null || users.length == 0) {
            return 0;
        }


        //iterating over each day of the month and calculate how many user were active that day


        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM");
        YearMonth ym = YearMonth.parse(month, fmt);
        double answer = 0;
        int dayOfTheMonth = 1;
        int monthlyPriceInDollars = activeSubscription.monthlyPriceInDollars;
        double dailyRate =  (double) monthlyPriceInDollars/(double) ym.lengthOfMonth() ;
        double monthlyBill=0;

        int countNumberOfUsersForDay = 0;
        //going day by day from day 1 to the end of the month
        while (dayOfTheMonth <= ym.lengthOfMonth()) {
            LocalDate testedDay = ym.atDay(dayOfTheMonth);

            for (User user : users) {
                // if ture then we have deactivation and i can check if its in range
                if(user!=null&& user.deactivatedOn != null) {

                    // if ture then the user was online that day
                    if (isWithinRange(testedDay, user.activatedOn, user.deactivatedOn)
                            && user.customerId == activeSubscription.customerId) {
                        countNumberOfUsersForDay++;

                    }

                    //in case the deactivison is null meaning he still on active
                }else{
                    countNumberOfUsersForDay++;
                }
            }

            dayOfTheMonth++;
            double dailyBill =  countNumberOfUsersForDay * dailyRate;
            monthlyBill = monthlyBill+dailyBill;


        }
        

        return monthlyBill;

    }

    private static Boolean isWithinRange(LocalDate testDate, LocalDate startDate, LocalDate endDate) {
        return !(testDate.isBefore(startDate) || testDate.isAfter(endDate));
    }



}