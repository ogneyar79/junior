package ru.job4j.tasksortdeparament;


import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentStrArrayTest {

    @Test
    public void whendeleteGapAtdepartaments() {
        String[] departments = {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        DepartmentStrArray testDepartments = new DepartmentStrArray();

        Map<String, List<String>> result = new TreeMap<>();

        result = testDepartments.deleteGapAtdepartaments(departments);
        System.out.println(result);

        for (String key : result.keySet()) {
            System.out.println(key);
        }

        DepartmentStrArray testDepartments2 = new DepartmentStrArray();
        String[] departmentsForExpected = {"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        Map<String, List<String>> excpected = new TreeMap<>();
        excpected = testDepartments2.fillMapDepartments(departmentsForExpected);

        assertThat(result, is(excpected));

    }

    @Test
    public void whenreturnOurDepartamentsArrayFromOurMap() {
        String[] departments1 = {"K1\\SK1", "K1\\SK2"};
        DepartmentStrArray testDepartments3 = new DepartmentStrArray();
        String[] result = testDepartments3.depsMapToArray(testDepartments3.fillMapDepartments(departments1));
        System.out.println(testDepartments3.fillMapDepartments(departments1));
        System.out.println(testDepartments3.fillMapDepartments(departments1).size());
        System.out.println(result);
        String[] excpected = departments1;
        assertThat(result, is(excpected));
    }


    @Test
    public void whenDeleteGapAndSortArraysByDescendingOrederLow() {
        String[] departments4 = {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        DepartmentStrArray testDepartments4 = new DepartmentStrArray();
        String[] result = testDepartments4.deletAndSortArraysbyDescendingOrederLow(departments4);
        String[] excpected = {"K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"};
        System.out.println(result);
        assertThat(result, is(excpected));


    }

}