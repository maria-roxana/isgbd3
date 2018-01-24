package isgbd.util;

/**
 * Created by Laura on 1/24/2018
 */

public class Utils {

    public Utils() {
    }

    public static java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }
}
