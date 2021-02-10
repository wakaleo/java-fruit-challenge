package com.serenitydojo.lists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class WhenSortingAList {
    @Test
    public void shouldCheckThatAnEmptyListIsCorrectlySorted() {
        List<String> emptyList = new ArrayList();

        List<String> correctlySorted = ListChecker.correctlySortedListOf(emptyList);
        assertThat(correctlySorted).containsExactlyElementsOf(emptyList);
    }

    @Test
    public void shouldSortStringsInNaturalOrder() {
        List<String> actualList = asList("cat","dog","badger");

        List<String> correctlySorted = ListChecker.correctlySortedListOf(actualList);

        assertThat(correctlySorted).containsExactlyElementsOf(asList("badger","cat","dog"));
    }

    @Test
    public void shouldSortDatesInReverseOrder() {
        List<String> actualList = asList("15/04/2020","20/01/2020","21/01/2021");

        List<String> correctlySorted = ListChecker.correctlySortedListOf(actualList);

        assertThat(correctlySorted).containsExactlyElementsOf(asList("21/01/2021","15/04/2020","20/01/2020"));
    }

    @Test
    public void shouldSortDatesInReverseOrderAndStringsInNaturalOrder() {
        List<String> actualList = asList("bat","cat","cat 15/04/2020","bat 20/01/2020","21/01/2021");

        List<String> correctlySorted = ListChecker.correctlySortedListOf(actualList);

        assertThat(correctlySorted).containsExactlyElementsOf(asList("21/01/2021","cat 15/04/2020","bat 20/01/2020","bat","cat"));
    }

    /*
        - Empty list
        - List containing normal strings
        - A list containing dated strings
        - A list containing dated and normal strings
     */
}
