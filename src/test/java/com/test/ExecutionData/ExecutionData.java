package com.test.ExecutionData;

import java.util.HashMap;

public class ExecutionData {

    static HashMap<String, Object> runData = new HashMap<>();

    public static void storeObject(String key, Object obj) {
        runData.put(key, obj);
    }

    public static Object getOject(String key){
        return runData.get(key);
    }

}
