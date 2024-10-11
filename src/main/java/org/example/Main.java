package org.example;

import org.example.entity.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static List<Employee> findDuplicates(List<Employee> employeeList) {
        if (employeeList == null || employeeList.isEmpty()) {
            return new LinkedList<>(); // Boş liste döner
        }

        List<Employee> duplicates = new LinkedList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Counting occurrences of each employee id
        for (Employee emp : employeeList) {
            if (emp == null) continue; // Null Employee kontrolü
            frequencyMap.put(emp.getId(), frequencyMap.getOrDefault(emp.getId(), 0) + 1);
        }

        // Adding employees with frequency > 1 to duplicates list
        for (Employee emp : employeeList) {
            if (emp == null) continue; // Null Employee kontrolü
            if (frequencyMap.get(emp.getId()) > 1 && !duplicates.contains(emp)) {
                duplicates.add(emp);
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employeeList) {
        if (employeeList == null || employeeList.isEmpty()) {
            return new HashMap<>(); // Boş map döner
        }

        Map<Integer, Employee> uniqueMap = new HashMap<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Counting occurrences of each employee id
        for (Employee emp : employeeList) {
            if (emp == null) continue; // Null Employee kontrolü
            frequencyMap.put(emp.getId(), frequencyMap.getOrDefault(emp.getId(), 0) + 1);
        }

        // Adding unique employees (frequency == 1) to the map
        for (Employee emp : employeeList) {
            if (emp == null) continue; // Null Employee kontrolü
            if (frequencyMap.get(emp.getId()) == 1) {
                uniqueMap.put(emp.getId(), emp);
            } else if (frequencyMap.get(emp.getId()) > 1 && !uniqueMap.containsKey(emp.getId())) {
                // Adding only one instance of a duplicate employee to the map
                uniqueMap.put(emp.getId(), emp);
            }
        }

        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employeeList) {
        if (employeeList == null || employeeList.isEmpty()) {
            return new LinkedList<>(); // Boş liste döner
        }

        List<Employee> uniqueList = new LinkedList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Counting occurrences of each employee id
        for (Employee emp : employeeList) {
            if (emp == null) continue; // Null Employee kontrolü
            frequencyMap.put(emp.getId(), frequencyMap.getOrDefault(emp.getId(), 0) + 1);
        }

        // Adding employees with frequency == 1 to the unique list
        for (Employee emp : employeeList) {
            if (emp == null) continue; // Null Employee kontrolü
            if (frequencyMap.get(emp.getId()) == 1) {
                uniqueList.add(emp);
            }
        }

        return uniqueList;
    }
}
