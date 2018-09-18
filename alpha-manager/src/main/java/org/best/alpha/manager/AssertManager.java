package org.best.alpha.manager;

import org.best.alpha.exception.AssertException;

import java.util.Collection;

public class AssertManager {

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new AssertException(message);
        }
    }

    public static boolean isEmptyText(String text) {
        return text == null || "".equals(text);
    }

    public static boolean isEmptyCollection(Collection<Object> collection) {
        return collection == null || collection.size() == 0;
    }
}
