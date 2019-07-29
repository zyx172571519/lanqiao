package org.taru.lanqiao.util;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Id生成�?
 */
public class IdUtil {
    private static DateTimeFormatter
            formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    /**
     * 获取UUID
     * @return
     */
    public static String   getUuid(){
        String  uuid =UUID.randomUUID().toString();
        return uuid;
    }

    /**
     * 获取DateId 当前时间时分�?
     * @return
     */
    public static String  getDateId(){
        LocalDateTime dateTime =LocalDateTime.now();
        String str =formatter.format(dateTime);
        return  str;

    }
    /**
     * 获取tLongTime 当前时间的毫秒数
     * @return
     */
    public static String  getLongTimeId(){
        long  longValue =System.currentTimeMillis();
        return  String.valueOf(longValue);

    }

}
