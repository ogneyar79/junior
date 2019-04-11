package ru.job4j.tasksortdeparament;

import java.util.*;

import static java.util.Arrays.asList;

public class DepartmentStrArray {

    Map<String, List<String>> sortDepartmetns = new TreeMap<>();

    Map<String, List<String>> fillMapDepartments(String[] departments) {

        List<String> departmentsBest = new ArrayList<>();
        departmentsBest = asList(departments);

        for (String department : departmentsBest) {
            sortDepartmetns.put(department, asList(department.split("\\\\")));
        }

        return sortDepartmetns;
    }

    public Map<String, List<String>> deleteGapAtdepartaments(String[] departments) {

        Map<String, List<String>> tempDeportametnShouldAdd = new TreeMap<>();

        sortDepartmetns = fillMapDepartments(departments);

        for (List<String> oneDepartamentList : sortDepartmetns.values()) {
            if (oneDepartamentList.size() <= 1) {
                continue;
            } else {
                List<String> subListFromDepartmentMinusLast = new ArrayList<>();
                String append = "";
                subListFromDepartmentMinusLast = oneDepartamentList.subList(0, oneDepartamentList.size() - 1);

                if (!sortDepartmetns.containsValue(subListFromDepartmentMinusLast) && subListFromDepartmentMinusLast.size() == 1) {
                    append = subListFromDepartmentMinusLast.get(0);
                    tempDeportametnShouldAdd.put(append, subListFromDepartmentMinusLast);
                } else if (!sortDepartmetns.containsValue(subListFromDepartmentMinusLast) && subListFromDepartmentMinusLast.size() > 1) {
                    for (String element : subListFromDepartmentMinusLast) {
                        append += element + "\\";
                    }
                    String ap2 = append.substring(0, append.length() - 1);
                    tempDeportametnShouldAdd.put(ap2, subListFromDepartmentMinusLast);
                }
            }
        }
        sortDepartmetns.putAll(tempDeportametnShouldAdd);

        return sortDepartmetns;
    }

    public String[] depsMapToArray(Map<String, List<String>> mapTreDepartments) {

        String[] departments = new String[mapTreDepartments.size()];
        int i = 0;
        for (String departmentMap : mapTreDepartments.keySet()) {
            departments[i++] = departmentMap;
        }
        return departments;
    }

    public String[] deletAndSortArraysbyAscendingOrderHigh(String[] departments) {
        sortDepartmetns = deleteGapAtdepartaments(departments);
        return depsMapToArray(sortDepartmetns);
    }

    public String[] deletAndSortArraysbyDescendingOrederLow(String[] departments) {
        sortDepartmetns = deleteGapAtdepartaments(departments);
        Map<String, List<String>> treMapDepartmentsForDescendingOr = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                List<String> a1 = sortDepartmetns.containsKey(o1) ? sortDepartmetns.get(o1) : null;
                List<String> a2 = sortDepartmetns.containsKey(o2) ? sortDepartmetns.get(o2) : null;
                int res = 0;
                boolean isLengthsEqual = a1.size() - a2.size() == 0 ? true : false;
                int min = Math.min(a1.size(), a2.size());
                for (int i = 0; i < min; i++) {
                    if (!a1.get(i).equals(a2.get(i))) {
                        res = -1 * a1.get(i).compareTo(a2.get(i));
                        break;
                    }
                    if (i == min - 1 && !isLengthsEqual) {
                        res = a1.size() - a2.size();
                        break;
                    }
                }
                return res;
            }
        });
        treMapDepartmentsForDescendingOr.putAll(sortDepartmetns);
        return depsMapToArray(treMapDepartmentsForDescendingOr);
    }
}