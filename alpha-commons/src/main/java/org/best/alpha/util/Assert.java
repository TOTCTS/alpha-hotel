package org.best.alpha.util;

import java.util.Collection;

public class Assert {

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
    }

    public static boolean isNull(Object object) {
        return object == null;
    }


    public static boolean isEmptyText(String text) {
        return text == null || "".equals(text);
    }

    public static boolean isEmptyCollection(Collection<Object> collection) {
        return collection == null || collection.size() == 0;
    }
}
