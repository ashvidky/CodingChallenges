package com.ashvidky.challenge.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
/*
Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, 
the ID of the user making the access, and the resource ID. 

The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

For example:
logs1 = [
    ["58523", "user_1", "resource_1"],
    ["62314", "user_2", "resource_2"],
    ["54001", "user_1", "resource_3"],
    ["200", "user_6", "resource_5"],    
    ["215", "user_6", "resource_4"],
    ["54060", "user_2", "resource_3"],
    ["53760", "user_3", "resource_3"],
    ["58522", "user_22", "resource_1"],
    ["53651", "user_5", "resource_3"],
    ["2", "user_6", "resource_1"],
    ["100", "user_6", "resource_6"],
    ["400", "user_7", "resource_2"],
    ["100", "user_8", "resource_6"],
    ["54359", "user_1", "resource_3"],
]


Example 2:
logs2 = [
    ["300", "user_1", "resource_3"],
    ["599", "user_1", "resource_3"],
    ["900", "user_1", "resource_3"],
    ["1199", "user_1", "resource_3"],
    ["1200", "user_1", "resource_3"],
    ["1201", "user_1", "resource_3"],
    ["1202", "user_1", "resource_3"]
]

1. Write a function that takes the logs and returns the resource with the highest number of accesses 
in any 5 minute window, together with how many accesses it saw.

Expected Output:
most_requested_resource(logs1) # => ('resource_3', 3)
Reason: resource_3 is accessed at 53760, 54001, and 54060

most_requested_resource(logs2) # => ('resource_3', 4)
Reason: resource_3 is accessed at 1199, 1200, 1201, and 1202


2. Write a function that returns user first and last session

*/
public class LogRecords {
  public static void main(String[] argv) {
    String[][] logs1 = new String[][] {
        { "58523", "user_1", "resource_1" },
        { "62314", "user_2", "resource_2" },
        { "54001", "user_1", "resource_3" },
        { "200", "user_6", "resource_5" },
        { "215", "user_6", "resource_4" },
        { "54060", "user_2", "resource_3" },
        { "53760", "user_3", "resource_3" },
        { "58522", "user_22", "resource_1" },
        { "53651", "user_5", "resource_3" },
        { "2", "user_6", "resource_1" },
        { "100", "user_6", "resource_6" },
        { "400", "user_7", "resource_2" },
        { "100", "user_8", "resource_6" },
        {"54359", "user_1", "resource_3"},
    };

    String[][] logs2 = new String[][] {
        {"300", "user_1", "resource_3"},
        {"599", "user_1", "resource_3"},
        {"900", "user_1", "resource_3"},
        {"1199", "user_1", "resource_3"},
        {"1200", "user_1", "resource_3"},
        {"1201", "user_1", "resource_3"},
        {"1202", "user_1", "resource_3"}
    };

     Map<String, List<Integer>> s2 = getUserSessions(logs1);
     s2.entrySet().stream().forEach((e) -> {
      
       System.out.println("{" + e.getKey() + ":" + e.getValue().get(0)  + "," + e.getValue().get(1) + "}");
     });
    
//      Entry<String, Integer> maxAccess = get5minAccess(logs2);
//      System.out.println(maxAccess);
//      accessMap.entrySet().stream().forEach((e) -> {
//	    
//	  System.out.println("{" + e.getKey() + ":" + e.getValue() + "}");
//	});
  }
  
  private static Map<String, List<Integer>> getUserSessions(String[][] logs) {

	  Map<String, List<Integer>> userSessions = new HashMap<>();
	  
	  Map<String, List<Record>> userRecordsMap = Arrays.stream(logs).map(Record::new).collect(Collectors.groupingBy(r->r.getUser()));
	  userRecordsMap.entrySet().stream().forEach(e -> {
		  String user = e.getKey();
		  
		  List<Record> userRecords = e.getValue();
		  userRecords.sort(Comparator.comparingInt(Record::getTime));
		  Integer first = userRecords.get(0).getTime();
		  Integer last = userRecords.get(userRecords.size() - 1).getTime();
		  
		  List<Integer> times = new ArrayList<Integer>();
		  times.add(first);
		  times.add(last);
		  
		  userSessions.put(user, times);
	  });
	  
	  
	  return userSessions;
  }
  
  public static void get5minAccess(String[][] logs) {
	  
	  Map<String, List<Record>> resourceRecordsMap = Arrays.stream(logs).map(Record::new).collect(Collectors.groupingBy(r->r.getResource()));
	  resourceRecordsMap.entrySet().stream().forEach(e -> {
		  String user = e.getKey();
		  
		  List<Record> userRecords = e.getValue();
		  userRecords.sort(Comparator.comparingInt(Record::getTime));
		  
		  int l = 0, r = 0;
		  
		  while (r < userRecords.size()) {
			  int leftTime = userRecords.get(l).getTime();
			  int rightTime = userRecords.get(r).getTime();

			  int currMax = 0, max = 0;
					  
			  if (rightTime - leftTime <= 300) {
				  
				  currMax++;
				  r++;
			  }
			  else {
				  
				  if (currMax > max)
					  max = currMax;
				  
				  l++;
			  }
			  
		  }
		  
	  });
  
  }

public static class Record{
	  
	  public String resource;
	  public Integer time;
	  public String user;
	  
	  public Record(String[] record) {
		  
		  time = Integer.parseInt(record[0]);
		  user = record[1];
		  resource = record[2];
	  }

	public String getResource() {
		return resource;
	}

	public Integer getTime() {
		return time;
	}

	public String getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "Record [resource=" + resource + ", time=" + time + ", user=" + user + "]";
	}
	  
	 
  }
  
  
  public static void get5MinAccess(String[][] logs) {
	  
	  
	  
  }
  
  
  
  
//  public static Entry<String, Integer> get5minAccess(String[][] logs){
//    
////	  List<Record> records = Arrays.stream(logs).map(Record::new).collect(Collectors.toList());
////	  records.stream().collect(Collectors.groupingBy(r->r.getResource()));
//    
//	  Map<String, Integer> resourceAccess = new HashMap<>();
//	  
//	  Map<String, List<Record>> resourceMap = Arrays.stream(logs).map(Record::new)
//			  .collect(Collectors.groupingBy(r->r.getResource()));
//	  
//	  resourceMap.entrySet().stream().forEach(e -> {
//		  List<Record> records = e.getValue();
//		  Collections.sort(records, Comparator.comparingInt(Record::getTime));
//		  
//		  int l = 0, r = 0;
//		  int currWindow = 0;
//		  int maxWindow = 0;
//		  while (r < records.size()) {
//			  
//			  Integer leftTime = records.get(l).getTime();
//			  Integer rightTime = records.get(r).getTime();
//
//			  if (rightTime - leftTime <= 300) {
//				  r++;
//				  currWindow++;
//			  }
//			  else {
//				  
//				  maxWindow = Math.max(maxWindow, currWindow);
//				  currWindow--;
//				  l++;
//			  }			  
//		  }
//		  
//		  maxWindow = Math.max(maxWindow, currWindow);
//		  
//		  resourceAccess.put(e.getKey(), maxWindow);
//		  
//	  });
//	  
//	  Optional<Entry<String, Integer>> max = resourceAccess.entrySet().stream().max(Comparator.comparingInt(e->e.getValue()));
//	  
//	  return max.get();
//	  
//  }
//    
//  
//  public static Map<String, List<Integer>> getUserSessions(String[][] logs){
//    
//    Map<String, List<Integer>> userSessions = new HashMap<>();
//    
//	Map<String, List<Record>> resourceMap = Arrays.stream(logs).map(Record::new).collect(Collectors.groupingBy(r->r.getUser()));
//	resourceMap.entrySet().stream().forEach(e -> {
//		  List<Record> records = e.getValue();
//		  Collections.sort(records, Comparator.comparingInt(Record::getTime));
//		  
//		  Record min = records.get(0);
//		  Record max = records.get(records.size() - 1);
//
//		  ArrayList<Integer> times = new ArrayList<>();
//		  times.add(min.getTime());
//		  times.add(max.getTime());
//		  
//		  userSessions.put(e.getKey(), times);
//	});
//    
//    
//    
////    for (int i = 0; i < logs.length; i++){
////      
////      String[] record = logs[i];
////      String userName = record[1];
////      Integer time = Integer.parseInt(record[0]);
////
////      List<Integer> sessions = userSessions.get(userName);
////      if (sessions == null){
////        sessions = new ArrayList<Integer>();
////        userSessions.put(userName,sessions);
////      }
////      else{
////        
////        sessions.add(time);
////        
////
////      }
////    }
//    
//    return userSessions;
//  }
}
/*
Complexity analysis variables:

n: number of logs in the input

O(n)

O(n)
*/