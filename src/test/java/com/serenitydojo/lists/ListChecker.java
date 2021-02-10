package com.serenitydojo.lists;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ListChecker {
    public static List<String> correctlySortedListOf(List<String> actualList) {
        List<String> correctlySortedList = new ArrayList<>(actualList);

        correctlySortedList.sort(new CustomComparator());

        return correctlySortedList;
    }

    static class CustomComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if (trailingDateIn(o1) != null && trailingDateIn(o2) != null) { // both are dates
                return compareByDatesIn(o1,o2);
            } else if (trailingDateIn(o1) != null) { // first one is a date
                return -1;
            } else if (trailingDateIn(o2) != null) { // second one is a date
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        }

        private int compareByDatesIn(String o1, String o2) {
            Date firstDate = trailingDateIn(o1);
            Date secondDate = trailingDateIn(o2);
            return secondDate.compareTo(firstDate);
        }

        private Date trailingDateIn(String value) {
            if (value.length() < 10) {
                return null;
            }
            String dateComponent = value.substring(value.length() - 10);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                return format.parse(dateComponent);
            } catch (ParseException e) {
                return null;
            }
        }
    }
}
