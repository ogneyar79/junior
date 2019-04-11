package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void whenSortListtoSetMinToMaxAge() {
        List<UserP> usersP = new ArrayList<>();
        usersP.add(new UserP(54, "Maksim"));
        usersP.add(new UserP(51, "Robert"));
        usersP.add(new UserP(21, "Elena"));
        usersP.add(new UserP(18, "Bill"));

        Set<UserP> excpected = new TreeSet<>();
        excpected.addAll(usersP);
        System.out.println(excpected);
        SortUser forSortUsersP = new SortUser();
        Set<UserP> result;
        result = forSortUsersP.sort1(usersP);
        System.out.println(result);
        assertThat(result, is(excpected));
    }

    @Test
    public void whenSortComporatorNameLengtchMinMax() {
        List<UserP> usersP1 = new ArrayList<>();
        usersP1.add(new UserP(54, "Maksim"));
        usersP1.add(new UserP(51, "Robert"));
        usersP1.add(new UserP(21, "Elena"));
        usersP1.add(new UserP(18, "Bill"));
        SortUser forSortUsersP1 = new SortUser();
        List<UserP> expected = new ArrayList<>();
        expected.add(usersP1.get(3));
        expected.add(usersP1.get(2));
        expected.add(usersP1.get(1));
        expected.add(usersP1.get(0));
        List<UserP> result = forSortUsersP1.sortNameLength(usersP1);
        System.out.println(result);
        System.out.println(expected);
        assertThat(result.get(0), is(expected.get(0)));

    }
    @Test
    public void whenSortComporatorNameAgeLexicalMinMax() {
        List<UserP> usersP2 = new ArrayList<>();
        SortUser forSortUsersP2 = new SortUser();
        usersP2.add(new UserP(23, "Tom"));
        usersP2.add(new UserP(34, "Nikc"));
        usersP2.add(new UserP(10, "Tom"));
        usersP2.add(new UserP(14, "Bill"));
        List<UserP> result = forSortUsersP2.sortByAllFields(usersP2);
        System.out.println(usersP2);
        System.out.println(result);
        assertThat(result, is(usersP2));
    }

}