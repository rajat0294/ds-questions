package src.calendar;

import java.util.*;

class Program {
    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {

        int startTime=0;
        int startIndexTime=0;
        int endTime=0;
        int endIndexTime=0;


        if(convertTimeStringToMinutes(dailyBounds1.start)<convertTimeStringToMinutes(dailyBounds2.start)){
            startTime=convertTimeStringToMinutes(dailyBounds2.start);
            startIndexTime=convertTimeStringToMinutes(dailyBounds1.start);
        }else{
            startTime=convertTimeStringToMinutes(dailyBounds1.start);
            startIndexTime=convertTimeStringToMinutes(dailyBounds2.start);
        }


        if(convertTimeStringToMinutes(dailyBounds1.end)<convertTimeStringToMinutes(dailyBounds2.end)){
            endTime=convertTimeStringToMinutes(dailyBounds1.end);
            endIndexTime=convertTimeStringToMinutes(dailyBounds2.end);
        }else{
            endTime=convertTimeStringToMinutes(dailyBounds2.end);
            endIndexTime=convertTimeStringToMinutes(dailyBounds1.end);
        }

        int totalSlots=(endIndexTime-startIndexTime)/meetingDuration;
        boolean[] slots=new boolean[totalSlots];

        for(StringMeeting meeting:calendar1){
            fillSlots(slots,meeting,startIndexTime,meetingDuration);
        }

        for(StringMeeting meeting:calendar2){
            fillSlots(slots,meeting,startIndexTime,meetingDuration);
        }

        ArrayList<StringMeeting> result=new ArrayList<StringMeeting>();

        for(int i=((startTime-startIndexTime)/meetingDuration);i<((endTime-startIndexTime)/meetingDuration);i++){
            if(!slots[i]){
                String startString=convertTimetoString(startIndexTime+(i*meetingDuration));
                while(i<((endTime-startIndexTime)/meetingDuration) && !slots[i]){
                    i++;
                }
                String endString=convertTimetoString(startIndexTime+(i*meetingDuration));
                result.add(new StringMeeting(startString,endString));
            }
        }
        // Write your code here.
        return result;
    }

    public static int convertTimeStringToMinutes(String time){
        String[] timeArray=time.split(":");
        int hour=Integer.parseInt(timeArray[0]);
        int minutes=Integer.parseInt(timeArray[1]);
        return 60*hour+minutes;
    }

    public static void fillSlots(boolean[] slots,StringMeeting meeting,int slotStartTime,int duration){
        int startTime=convertTimeStringToMinutes(meeting.start);
        int endTime=convertTimeStringToMinutes(meeting.end);
        int startIndex=(startTime-slotStartTime)/duration;
        int endIndex=(endTime-slotStartTime)/duration;
        for(int i=startIndex;i<endIndex;i++){
            slots[i]=true;
        }

    }

    public static String convertTimetoString(int time){
        int hour=time/60;
        int minutes=time%60;
        String hourString=(hour<10)?"0"+String.valueOf(hour):String.valueOf(hour);
        String minuteString=(minutes<10)?"0"+String.valueOf(minutes):String.valueOf(minutes);
        return hourString+":"+minuteString;
    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }
}
