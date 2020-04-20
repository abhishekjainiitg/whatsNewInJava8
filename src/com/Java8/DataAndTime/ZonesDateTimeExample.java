package com.Java8.DataAndTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.TreeSet;

public class ZonesDateTimeExample {

    public void execute() {

        System.out.println("");
        System.out.println("*** List of all Zone Ids: ");
        Set<String> listOfZones = ZoneId.getAvailableZoneIds();
        Set<String> sortedListOfZones = new TreeSet<>(listOfZones);

        for(String zone: sortedListOfZones) {
            System.out.println(zone);
        }

        System.out.println("");
        System.out.println("*** Creating a zoned time and formatting it: ");
        ZonedDateTime currentMeeting = ZonedDateTime.of(
                LocalDate.of(2020, Month.APRIL, 20),
                LocalTime.of(20, 50),
                ZoneId.of("Asia/Kolkata")
        );

        System.out.println("The meeting is set for : " + DateTimeFormatter.RFC_1123_DATE_TIME.format(currentMeeting));

        ZonedDateTime nextMeeting = currentMeeting.plus(Period.ofMonths(1));

        System.out.println("Next meeting is set for : " + DateTimeFormatter.RFC_1123_DATE_TIME.format(nextMeeting));

        ZonedDateTime nextMeetingUS = nextMeeting.withZoneSameInstant(ZoneId.of("US/Central"));

        System.out.println("Next meeting is set for : " + DateTimeFormatter.RFC_1123_DATE_TIME.format(nextMeetingUS) + " is US Time Zone");

    }
}
