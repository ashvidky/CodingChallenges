package com.ashvidky.challenge.general;


import java.io.*;
import java.util.*;
import java.util.stream.*;

/*

Question 1:

Input 1:
      {"58", "Linear Algebra"},
      {"94", "Art History"},
      {"94", "Operating Systems"},
      {"17", "Software Design"},
      {"58", "Mechanics"},
      {"58", "Economics"},
      {"17", "Linear Algebra"},
      {"17", "Political Science"},
      {"94", "Economics"},
      {"25", "Economics"},
      {"58", "Software Design"}

output1:
		58,94:[Economics]
		17,25:[]
		17,58:[Linear Algebra, Software Design]
		25,58:[Economics]
		17,94:[]
		25,94:[Economics]
		
Input 2:
{
      {"0", "Advanced Mechanics"},
      {"0", "Art History"},
      {"1", "Course 1"},
      {"1", "Course 2"},
      {"2", "Computer Architecture"},
      {"3", "Course 1"},
      {"3", "Course 2"},
      {"4", "Algorithms"}
    };
    
Output 2:
	0,1:[]
	0,2:[]
	0,3:[]
	1,2:[]
	0,4:[]
	1,3:[Course 1, Course 2]
	1,4:[]
	2,3:[]
	2,4:[]
	3,4:[]

Input 3:
{
      {"23", "Software Design"}, 
      {"3",  "Advanced Mechanics"}, 
      {"2",  "Art History"}, 
      {"33", "Another"},
    };
    
Output 3:
	33,3:[]
	33,2:[]
	2,3:[]
	33,23:[]
	2,23:[]
	3,23:[]

------------------------

Question 2:

You're developing a system for scheduling advising meetings with students in a Computer Science program. Each meeting should be scheduled when a student has completed 50% of their academic program.

Each course at our university has at most one prerequisite that must be taken first. No two courses share a prerequisite. There is only one path through the program.

Write a function that takes a list of (prerequisite, course) pairs, and returns the name of the course that the student will be taking when they are halfway through their program. (If a track has an even number of courses, and therefore has two "middle" courses, you should return the first one.)

Sample input 1: (arbitrarily ordered)
prereqs_courses1 = [
	["Foundations of Computer Science", "Operating Systems"],
	["Data Structures", "Algorithms"],
	["Computer Networks", "Computer Architecture"],
	["Algorithms", "Foundations of Computer Science"],
	["Computer Architecture", "Data Structures"],
	["Software Design", "Computer Networks"]
]

In this case, the order of the courses in the program is:
	Software Design
	Computer Networks
	Computer Architecture
	Data Structures
	Algorithms
	Foundations of Computer Science
	Operating Systems

Sample output 1:
	"Data Structures"


Sample input 2:
prereqs_courses2 = [
	["Data Structures", "Algorithms"],
	["Algorithms", "Foundations of Computer Science"],
	["Foundations of Computer Science", "Logic"]
]


Sample output 2:
	"Algorithms"

Sample input 3:
prereqs_courses3 = [
	["Data Structures", "Algorithms"],
]


Sample output 3:
	"Data Structures"

Complexity analysis variables:

n: number of pairs in the input

*/


public class Courses {
  public static void main(String[] argv) {

    String[][] studentCoursePairs1 = {
      {"58", "Linear Algebra"},
      {"94", "Art History"},
      {"94", "Operating Systems"},
      {"17", "Software Design"},
      {"58", "Mechanics"},
      {"58", "Economics"},
      {"17", "Linear Algebra"},
      {"17", "Political Science"},
      {"94", "Economics"},
      {"25", "Economics"},
      {"58", "Software Design"}
    };

    String[][] studentCoursePairs2 = {
      {"0", "Advanced Mechanics"},
      {"0", "Art History"},
      {"1", "Course 1"},
      {"1", "Course 2"},
      {"2", "Computer Architecture"},
      {"3", "Course 1"},
      {"3", "Course 2"},
      {"4", "Algorithms"}
    };

    String[][] studentCoursePairs3 = {
      {"23", "Software Design"}, 
      {"3",  "Advanced Mechanics"}, 
      {"2",  "Art History"}, 
      {"33", "Another"},
    };

    
    Map<String, List<String>> result = solution(studentCoursePairs3);
    result.entrySet().forEach(e -> {
      
      System.out.println(e.getKey() + ":" + e.getValue());
    });
  }
  
  static class Student{
    
    private Integer studentId;
    private String courseName;
    
    public Student(String[] record){
      this.studentId = Integer.valueOf(record[0]);
      this.courseName = record[1];
    }
    
    public Integer getStudentId(){
      return studentId;
    }
    
    public String getCourseName(){
      return courseName;
    }
  
  }
  
  
  public static Map<String, List<String>> solution(String[][] logs){
    
    Map<Integer, List<Student>> studentCourseMap =  Arrays.stream(logs).map(Student::new).collect(Collectors.groupingBy(Student::getStudentId));
    
    List<Map.Entry<Integer, List<Student>>> entryList = studentCourseMap.entrySet().stream().collect(Collectors.toList());
    
    Map<String, List<String>> result = new HashMap<>();
    
    for (int i = 0; i < entryList.size() - 1; i++ ){
      
      Integer id1 = entryList.get(i).getKey();
      List<Student> l1 = entryList.get(i).getValue();
      Map<String, String> courses = l1.stream().collect(Collectors.toMap(Student::getCourseName, Student::getCourseName));
      
      for (int j = i; j < entryList.size(); j++){
        
        if (i == j)
          j++;
      
        Integer id2 = entryList.get(j).getKey();
        
        String resultKey = id1 + "," + id2;
        
        List<Student> l2 = entryList.get(j).getValue();
        l2.sort(Comparator.comparing(Student::getCourseName));
        
        List<String> matchingcourses = new ArrayList<>();
        
        for (int k = 0; k < l2.size(); k++){
          
          String courseName = l2.get(k).getCourseName();
          
          if (courses.containsKey(courseName)){
            matchingcourses.add(courseName);
          }
        }
        
        result.put(resultKey, matchingcourses);
      }
      
    }
    
    return result;
  }
}

