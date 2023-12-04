package newYearCountdown;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class NewYearCountDown {
    public static void main(String[] args) {
        // Set the target date and time for New Year
        LocalDateTime newYear = LocalDateTime.of(2024, 1, 1, 0, 0);

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Calculate the period and duration
        Period period = Period.between(now.toLocalDate(), newYear.toLocalDate());
        Duration duration = Duration.between(now, newYear);

        // Display the countdown
        System.out.println("Countdown to New Year:");

        while (!now.isAfter(newYear)) {
            System.out.printf("%02d days %02d hours %02d minutes %02d seconds%n",
                    period.getDays(), now.getHour(), now.getMinute(), now.getSecond());

            try {
                // Sleep for one second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Update the current date and time
            now = LocalDateTime.now();

            // Recalculate period and duration
            period = Period.between(now.toLocalDate(), newYear.toLocalDate());
            duration = Duration.between(now, newYear);
        }

        System.out.println("Happy New Year!");
        
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Get the date of the next New Year
        LocalDate nextNewYear = LocalDate.of(currentDateTime.getYear() + 1, 1, 1);

        // Calculate the period until the next New Year
        Period periodUntilNewYear = Period.between(LocalDate.now(), nextNewYear);

        // Calculate the duration until the next New Year
        LocalDateTime nextNewYearDateTime = LocalDateTime.of(nextNewYear, currentDateTime.toLocalTime());
        Duration durationUntilNewYear = Duration.between(currentDateTime, nextNewYearDateTime);

        // Print the remaining time
        System.out.println("Time until the next New Year:");
        System.out.println("Months: " + periodUntilNewYear.getMonths());
        System.out.println("Days: " + periodUntilNewYear.getDays());
        System.out.println("Hours: " + durationUntilNewYear.toHours());
        System.out.println("Minutes: " + durationUntilNewYear.toMinutes());
        System.out.println("Seconds: " + durationUntilNewYear.getSeconds());
    }
}