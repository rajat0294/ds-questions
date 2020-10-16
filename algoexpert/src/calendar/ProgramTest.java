package src.calendar;

import java.util.*;

class ProgramTest {

    public boolean arraysEqual(List<Program.StringMeeting> arr1, List<Program.StringMeeting> arr2) {
        if (arr1.size() != arr2.size()) return false;

        for (int i = 0; i < arr1.size(); i++) {
            if (!arr1.get(i).start.equals(arr2.get(i).start)
                    || !arr1.get(i).end.equals(arr2.get(i).end)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Program.StringMeeting> calendar1 = new ArrayList<Program.StringMeeting>();
        calendar1.add(new Program.StringMeeting("9:00", "10:30"));
        calendar1.add(new Program.StringMeeting("12:00", "13:00"));
        calendar1.add(new Program.StringMeeting("16:00", "18:00"));

        Program.StringMeeting dailyBounds1 = new Program.StringMeeting("9:00", "20:00");

        List<Program.StringMeeting> calendar2 = new ArrayList<Program.StringMeeting>();
        calendar2.add(new Program.StringMeeting("10:00", "11:30"));
        calendar2.add(new Program.StringMeeting("12:30", "14:30"));
        calendar2.add(new Program.StringMeeting("14:30", "15:00"));
        calendar2.add(new Program.StringMeeting("16:00", "17:00"));

        Program.StringMeeting dailyBounds2 = new Program.StringMeeting("10:00", "18:30");

        int meetingDuration = 30;

        List<Program.StringMeeting> expected = new ArrayList<Program.StringMeeting>();
        expected.add(new Program.StringMeeting("11:30", "12:00"));
        expected.add(new Program.StringMeeting("15:00", "16:00"));
        expected.add(new Program.StringMeeting("18:00", "18:30"));

        List<Program.StringMeeting> actual =
                Program.calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
        System.out.println(actual);
    }
}
