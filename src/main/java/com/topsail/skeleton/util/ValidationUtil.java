package com.topsail.skeleton.util;

import com.topsail.skeleton.exception.AlreadyExistException;
import com.topsail.skeleton.exception.NotFoundException;

/**
 * @author Steven
 */
public final class ValidationUtil {

    /**
     * 判断是否找不到
     *
     * @param object
     * @param entity
     * @param parameter
     * @param value
     */
    public static void isNotFound(Object object, String entity, String parameter, Object value) {
        if (null == object) {
            String msg = entity
                    + " is not found! "
                    + "{ " + parameter + ":" + value.toString() + " }";
            throw new NotFoundException(msg, 404);
        }
    }

    /**
     * 判断是否找不到
     *
     * @param ret
     * @param entity
     * @param parameter
     * @param value
     */
    public static void isNotFound(int ret, String entity, String parameter, Object value) {
        if (0 == ret) {
            String msg = entity
                    + " is not found! "
                    + "{ " + parameter + ":" + value.toString() + " }";
            throw new NotFoundException(msg, 404);
        }
    }

    /**
     * 判断是否已经存在
     *
     * @param ret
     * @param entity
     * @param parameter
     * @param value
     */
    public static void isAlreadyExist(int ret, String entity, String parameter, Object value) {
        if (0 == ret) {
            String msg = entity
                    + " already exist! "
                    + "{ " + parameter + ":" + value.toString() + " }";
            throw new AlreadyExistException(msg, 400);
        }
    }

}
