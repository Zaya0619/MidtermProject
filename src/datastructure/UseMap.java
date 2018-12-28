package datastructure;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import databases.ConnectToMongoDB;
import java.util.List;


public class UseMap {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        /*
         * Demonstrate how to use Map that includes storing and retrieving elements.
         * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
         * Use For Each loop and while loop with Iterator to retrieve data.
         *
         * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
         */

        ArrayList<String> employees_of_mgt = new ArrayList();
        employees_of_mgt.add("employee-1");
        employees_of_mgt.add("employee-2");
        employees_of_mgt.add("employee-3");

        ArrayList<String> employees_of_act = new ArrayList();
        employees_of_act.add("employees-4");
        employees_of_act.add("employees-5");
        employees_of_act.add("employees-6");

        ArrayList<String> employees_of_sls = new ArrayList();
        employees_of_sls.add("employee-7");
        employees_of_sls.add("employee-8");
        employees_of_sls.add("employee-9");


        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        map.put("Management", employees_of_mgt);
        map.put("Accountant", employees_of_act);
        map.put("Sales", employees_of_sls);

//Iterate over all map entry, using the keySet method
        for (Entry<String, ArrayList<String>> key : map.entrySet()) {
            System.out.println(key.getKey() + " " + key.getValue());
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        ConnectToMongoDB connect = new ConnectToMongoDB();
        connect.insertDataFromArrayListToMongoDB((ArrayList<String>) employees_of_mgt,"table1","employee-1");
        connect.insertDataFromArrayListToMongoDB((ArrayList<String>) employees_of_mgt,"table2","employee-2");
        connect.insertDataFromArrayListToMongoDB((ArrayList<String>) employees_of_mgt,"table3","employee-3");
        connect.insertDataFromArrayListToMongoDB((ArrayList<String>) employees_of_mgt,"table4","employee-4");
        connect.insertDataFromArrayListToMongoDB((ArrayList<String>) employees_of_mgt,"table5","employee-5");
        connect.insertDataFromArrayListToMongoDB((ArrayList<String>) employees_of_mgt,"table6","employee-6");
    }

}

