package test;

/**
 * Created by umamaheshwar on 30/11/2017.
 */
public class TestMain {

    String valid ="{\n" +
            "    \"status\": 1,\n" +
            "    \"msg\": {\n" +
            "        \"aadhaarNumber\": \"XXXXXXXX\",\n" +
            "        \"status\": \"Active\"\n" +
            "    }\n" +
            "}";
    String invalid ="{\n" +
            "    \"status\": 0,\n" +
            "    \"msg\": \"Invalid Aadhaar\"\n" +
            "}";

    public static void main(String [] args) {
    }

}
