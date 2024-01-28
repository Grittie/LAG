import java.util.*;

public class Comparator {
    public static void main(String[] args) {
        int N = 1000000;
        List<Date> dateList = new ArrayList<>();

        // Generate N random Date objects
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            dateList.add(new Date(random.nextLong()));
        }

        // Sort the list using the Collections.sort() method
        Collections.sort(dateList, new java.util.Comparator<Date>() {
            public int compare(Date date1, Date date2) {
                return date1.compareTo(date2);
            }
        });

        // Verify if the sorting method is stable
        boolean isStable = true;
        for (int i = 1; i < dateList.size(); i++) {
            Date prevDate = dateList.get(i - 1);
            Date currDate = dateList.get(i);
            if (prevDate.compareTo(currDate) == 0 && dateList.indexOf(prevDate) > dateList.indexOf(currDate)) {
                isStable = false;
                break;
            }
        }

        System.out.println("Is the sorting method stable? " + isStable);
    }
}
