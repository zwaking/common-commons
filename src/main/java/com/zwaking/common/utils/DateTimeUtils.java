/**
 *
 */
package com.zwaking.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author waking
 * @date 2020/11/25 11:25
 * @title 日期/时间工具类
 * @description 提供有关日期/时间的常用静态操作方法
 */

public class DateTimeUtils {

    public static final String YYYYMMDDHHMMSSFormat = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYYMMDDTHHMMSSXFormat = "yyyy-MM-dd'T'HH:mm:ssX";
    /**
     * 日期格式:完整日期/时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public static SimpleDateFormat FULL_DATE_TIME_FORMAT = new SimpleDateFormat(YYYYMMDDHHMMSSFormat);
    public static SimpleDateFormat FULL_DATE_TIME_FORMAT_NUM = new SimpleDateFormat("yyyyMMddHHmmss");
    public static SimpleDateFormat SFULL_DATE_TIME_FORMAT_NUM = new SimpleDateFormat("yyMMddHHmmssSSS");
    public static SimpleDateFormat XFULL_DATE_TIME_FORMAT_NUM = new SimpleDateFormat(YYYYMMDDTHHMMSSXFormat);
    /**
     * 日期格式:完整日期/时间格式(yyyy-MM-dd)
     */
    public static SimpleDateFormat FULL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * 日期格式:完整日期/时间格式(yyyy-MM-dd HH:mm:ss,S)
     */
    public static SimpleDateFormat EXAC_DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,S");
    /**
     * 日期格式:完整日期/时间格式(yyyyMMdd)
     */
    public static SimpleDateFormat FULL_DATE_FORMAT_NUM = new SimpleDateFormat("yyyyMMdd");
    /**
     * 日期格式:完整时间/时间格式(HHmmss)
     */
    public static SimpleDateFormat FULL_TIME_FORMAT_NUM = new SimpleDateFormat("HHmmss");
    /**
     * 日期格式:完整时间/时间格式(yyMM)
     */
    public static SimpleDateFormat YYMM_FORMAT_NUM = new SimpleDateFormat("yyMM");
    public static long dateSecond = 24 * 60 * 60 * 1000;
    static Map<String, String> weekName = new HashMap<String, String>();

    static {
        weekName.put("2", "星期一");
        weekName.put("3", "星期二");
        weekName.put("4", "星期三");
        weekName.put("5", "星期四");
        weekName.put("6", "星期五");
        weekName.put("7", "星期六");
        weekName.put("1", "星期日");
    }

    /**
     * 获取星期几的名称
     *
     * @param str
     * @return
     */
    public static String getWeekName(String str) {
        return weekName.get(str);
    }

    /**
     * 日期格式:完整时间/时间格式(yyMM)
     */
    public static String getYYMM() {
        return YYMM_FORMAT_NUM.format(new Date());
    }

    /**
     * 取得当前完整日期/时间字符串(yyyy-MM-dd HH:mm:ss)
     *
     * @return
     */
    public static String getCurrentFullDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * 将日期字符转换为 日期对象
     *
     * @param dateStr(yyyy-MM-dd
     *            HH:mm:ss)
     * @return
     */
    public static Date getToDateObject(String dateStr) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
    }

    /**
     * 生成唯一序列 规则：当前时间+8位随机数(yyyyMMddHHmmss123345)
     * 
     * @param shortTableName
     *            表名(缩写) 例：uc - user_customer
     * @return
     * @throws Exception
     */
    public static synchronized String getSequence(String shortTableName) throws Exception {
        String currentDate = getCurrentDate("yyyyMMddHHmmssSSS");
        String random = random(8);
        return shortTableName + currentDate + random;
    }

    /**
     * 获取当前时间
     * 
     * @param formatStr
     *            时间格式
     * @return
     * @throws Exception
     */
    public static String getCurrentDate(String formatStr) {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sft = new SimpleDateFormat(formatStr);
        return sft.format(date);
    }

    /**
     * 取得当前日期(yyyy-MM-dd)
     *
     * @return
     */
    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * 取得指定日期完整日期/时间字符串(yyyy-MM-dd HH:mm:ss)
     *
     * @param date
     * @return
     */
    public static String getFullDateTime(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    /**
     * 日期偏移
     *
     * @param date
     *            当前日期
     * @param dayNum
     *            偏移天数
     * @return
     */
    public static Date getDateTimeForword(Date date, int dayNum) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, dayNum);
        return cal.getTime();
    }

    /**
     * 日期偏移为当天的最后一秒
     *
     * @param date
     *            当前日期
     * @param dayNum
     *            偏移天数
     * @return
     */
    public static Date getDateTimeForwordLastsecond(Date date, int dayNum) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        cal.add(Calendar.DATE, dayNum);
        return cal.getTime();
    }

    /**
     * 日期偏移为当天的最后一秒
     * 
     * @param date
     *            当前日期
     * @param dayNum
     *            偏移天数
     * @return
     */
    public static Date getDateTimeForwordStartsecond(Date date, int dayNum) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 00);
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 00);
        cal.set(Calendar.MILLISECOND, 000);
        cal.add(Calendar.DATE, dayNum);
        return cal.getTime();
    }

    public static Date getDateTimeForword(Date date, int num, String type) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if ("年".equals(type)) {
            cal.add(Calendar.YEAR, num);
        }
        if ("月".equals(type)) {
            cal.add(Calendar.MONTH, num);
        }
        if ("天".equals(type)) {
            cal.add(Calendar.DATE, num);
        }
        if ("时".equals(type)) {
            cal.add(Calendar.HOUR_OF_DAY, num);
        }
        if ("分钟".equals(type)) {
            cal.add(Calendar.MINUTE, num);
        }
        if ("秒".equals(type)) {
            cal.add(Calendar.SECOND, num);
        }
        return cal.getTime();
    }

    public synchronized static Date getDateTimeForword(String date, int num, String type) throws ParseException {
        return getDateTimeForword(getToDateObject(date), num, type);
    }

    /**
     * 取得当前精确时间("yyyy-MM-dd HH:mm:ss,S")
     *
     * @return
     */
    public static String getCurrentExacDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,S").format(new Date());
    }

    /**
     * 验证字符串是否符合(yyyy-MM-dd HH:mm:ss)格式
     *
     * @param beginTime
     * @return
     */
    public static boolean validateStringForFullTime(String beginTime) {
        try {
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(beginTime);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * 验证字符串是否符合(yyyy-MM-dd)格式
     *
     * @param beginTime
     * @return
     */
    public static boolean validateStringForDate(String beginTime) {
        try {
            new SimpleDateFormat("yyyy-MM-dd").parse(beginTime);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static String getCurrentYearMonth() {
        return new SimpleDateFormat("yyyy-MM").format(new Date());
    }

    public static String getCurrentDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String getCurrentDateNum() {
        return new Date().getTime() + (new Random(System.currentTimeMillis()).nextInt() + "");
    }

    /**
     * 求两个日期的天数之差
     *
     * @param beginTime
     *            开始时间
     * @param endTime
     *            结束时间
     * @return
     */
    public static int getOddDateNum(String beginTime, String endTime) throws ParseException {
        Date dateBegin = getToDateObject(beginTime);
        System.out.println("dateBegin=" + dateBegin);
        Date dateEnd = getToDateObject(endTime);
        System.out.println("dateEnd=" + dateEnd);
        if ((dateEnd.getTime() - dateBegin.getTime()) < 0) {
            return -1;
        }
        int odd = (int)((dateEnd.getTime() - dateBegin.getTime()) / (dateSecond));
        return odd;
    }

    /**
     * 把时间范围转为list
     * 
     * @param timeBegin
     * @param timeEnd
     * @return
     * @throws ParseException
     */
    public static List<String> getTimeList(String timeBegin, String timeEnd) throws ParseException {
        List<String> timeList = new ArrayList<String>();

        // 时间不正确
        if (timeBegin.compareTo(timeEnd) > 0) {
            return timeList;
        }

        // 两时间相等
        if (timeBegin.compareTo(timeEnd) == 0) {
            timeList.add(timeBegin);
            return timeList;
        }

        Date timeBeginDate = DateTimeUtils.FULL_DATE_FORMAT.parse(timeBegin);
        Date timeEndDate = DateTimeUtils.FULL_DATE_FORMAT.parse(timeEnd);
        do {
            timeList.add(timeBegin);
            timeBeginDate = getDateTimeForword(timeBeginDate, 1, "天");
            timeBegin = DateTimeUtils.formateDateStr(timeBeginDate, "yyyy-MM-dd");
        } while (timeEndDate.after(timeBeginDate));

        timeList.add(timeBegin);
        return timeList;
    }

    /**
     * 根据当前日期计算上月月初
     */
    public static String getFirstDayOfLastMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(GregorianCalendar.MONTH, -1); // 上月
        cal.set(GregorianCalendar.DAY_OF_MONTH, 1); // 上月首天
        return sdf.format(cal.getTime());
    }

    /**
     * 根据某日期计算某月月初
     * 
     * @param date（某时间）
     * @param monthNum（该月前/后的某月：正则加，负则减）
     * @param dayNum（该月的某天：1为该月首天）
     */
    public static String getFirstDayOfLastMonth(Date date, int monthNum, int dayNum) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(GregorianCalendar.MONTH, monthNum);
        cal.set(GregorianCalendar.DAY_OF_MONTH, dayNum);
        return sdf.format(cal.getTime());
    }

    public static String getFullDate() {
        return new SimpleDateFormat("yyyyMMdd").format(getDateTimeForword(new Date(), -1));
    }

    /**
     * @return yyyyMMdd 获得今天日期
     */
    public static String getFullDateToday() {
        return new SimpleDateFormat("yyyyMMdd").format(getDateTimeForword(new Date(), 0));
    }

    /**
     * 获取当前分钟
     */
    public static String getCurrentMinutes() {
        return new SimpleDateFormat("mm").format(new Date());
    }

    /**
     * 获取当前日期时间(yyyyMMddHHmm)
     * 
     * @return
     */
    public static String getFullDateTimeMinutesNum() {
        return new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
    }

    /**
     * 获取当前日期时间(yyyyMMddHHmmss)
     * 
     * @return
     */
    public static String getFullDateTimeNum() {
        return FULL_DATE_TIME_FORMAT_NUM.format(new Date());
    }

    /**
     * 获取当前日期时间(yyMMddHHmmssSSS)
     * 
     * @return
     */
    public static String getSFullDateTimeNum() {
        return SFULL_DATE_TIME_FORMAT_NUM.format(new Date());
    }

    /**
     * 获取当前时间(HH:mm:ss)
     * 
     * @return
     */
    public static String getFullTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 获取当前时间(HHmmss)
     * 
     * @return
     */
    public static String getFullTimeNum() {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        return sdf.format(new Date());
    }

    public static String getFullDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(getDateTimeForword(date, -1));
    }

    public static String gettringForVerifyAlipayDate(String beginTime) throws ParseException {
        return getFullDate(new SimpleDateFormat("yyyy-MM-dd").parse(beginTime));
    }

    public static boolean validateAlipayStringForDate(String beginTime) {
        try {
            new SimpleDateFormat("yyyyMMdd").parse(beginTime);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * 根据当前日期计算上月月末
     */
    public static String getLastDayOfLastMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.set(GregorianCalendar.DAY_OF_MONTH, 1); // 当月首天
        cal.add(GregorianCalendar.DAY_OF_MONTH, -1); // 上月末天
        return sdf.format(cal.getTime());
    }

    /**
     * 根据某日期计算某月月末
     * 
     * @param date（某时间）
     * @param monthNum（该月的某天：1为第一天）
     * @param dayNum（该天前/后的某天：-1为该天前/后的某天）
     * @return
     */
    public static String getLastDayOfLastMonth(Date date, int monthNum, int dayNum) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(GregorianCalendar.DAY_OF_MONTH, monthNum);
        cal.add(GregorianCalendar.DAY_OF_MONTH, dayNum);
        return sdf.format(cal.getTime());
    }

    public static String formateDateStr(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    /**
     * 得到时间字符串的时间戳(字符串格式:yyyy-MM-dd HH:mm:ss) <br />
     * if dateStr == null then get_now
     */
    public static Long getCurrentTimeMillis(String dateStr) throws ParseException {
        if (dateStr == null) {
            return System.currentTimeMillis();
        }
        return FULL_DATE_TIME_FORMAT.parse(dateStr).getTime();
    }

    /**
     * 转换格式
     *
     * @param dateStr
     * @param oldFormat
     * @param newFormat
     * @return
     */
    public static String convertDateTimeFormat(String dateStr, String oldFormat, String newFormat)
        throws ParseException {
        String newDate = null;
        SimpleDateFormat newSimple = new SimpleDateFormat(newFormat);
        SimpleDateFormat oldSimple = new SimpleDateFormat(oldFormat);
        Date date = oldSimple.parse(dateStr);
        newDate = newSimple.format(date);
        return newDate;
    }

    /**
     * 时间转换
     **/
    public static Date convertDateTimeFormat(String dateStr, String format) throws ParseException {
        SimpleDateFormat newSimple = new SimpleDateFormat(format);
        Date newDate = null;
        newDate = newSimple.parse(dateStr);
        return newDate;
    }

    /**
     * 判断时间范围
     **/
    public static boolean timeRangeCheck(String startTime, String endTime, Date checkDate, String format)
        throws ParseException {
        Date start = convertDateTimeFormat(startTime, format);
        Date end = convertDateTimeFormat(endTime, format);
        return timeRangeCheck(start, end, checkDate);
    }

    /**
     * 判断时间范围
     **/
    public static boolean timeRangeCheck(String startTime, String endTime, Date checkDate) throws ParseException {
        Date start = convertDateTimeFormat(startTime, YYYYMMDDHHMMSSFormat);
        Date end = convertDateTimeFormat(endTime, YYYYMMDDHHMMSSFormat);
        return timeRangeCheck(start, end, checkDate);
    }

    /**
     * 判断时间范围<br />
     * 当前时间既等于开始时间又等于结束时间则为false
     **/
    public static boolean timeRangeCheck(Date startTime, Date endTime, Date checkDate) {
        if (checkDate.getTime() == startTime.getTime() && checkDate.getTime() == endTime.getTime()) {
            return false;
        }
        if (checkDate.getTime() == startTime.getTime() || checkDate.getTime() == endTime.getTime()) {
            return true;
        }
        Calendar date = Calendar.getInstance();
        date.setTime(checkDate);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断 当前日期时间 前推24小时
     *
     * @return
     */
    public synchronized static String getYesDForFullTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(GregorianCalendar.DATE, -1);
        return sdf.format(cal.getTime()) + " " + DateTimeUtils.getFullTime();
    }

    /**
     * 数据库timestamp类型转换为yyyy-MM-dd HH:mm:ss格式字符串
     *
     * @param timestamp
     * @return
     */
    public synchronized static String timestampToFullDateTimeStr(Timestamp timestamp) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp.getTime());
        return getFullDateTime(c.getTime());
    }

    /**
     * 判断日期格式:yyyy-mm-dd
     * 
     * @param sDate
     * @return
     */
    public static boolean isValidDate(String sDate) {
        String datePattern1 = "\\d{4}-\\d{2}-\\d{2}";
        String datePattern2 = "^((\\d{2}(([02468][048])|([13579][26]))"
            + "[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|"
            + "(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?"
            + "((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?("
            + "(((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?"
            + "((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
        if ((sDate != null)) {
            Pattern pattern = Pattern.compile(datePattern1);
            Matcher match = pattern.matcher(sDate);
            if (match.matches()) {
                pattern = Pattern.compile(datePattern2);
                match = pattern.matcher(sDate);
                return match.matches();
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * 计算时间差
     * 
     * @param beginTime
     * @param endTime
     * @param format
     * @param type
     *            （day、hour、min、sec）
     * @return
     */
    public static Long dateCompare(String beginTime, String endTime, String format, String type) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat(format);
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long ns = 1000;// 一秒钟的毫秒数
        long result = 0L;

        // 获得两个时间的毫秒时间差异
        result = sd.parse(endTime).getTime() - sd.parse(beginTime).getTime();

        if (type.equals("day")) {
            result = result / nd;// 计算差多少天
        } else if (type.equals("hour")) {
            result = result / nh;// 计算差多少小时
        } else if (type.equals("min")) {
            result = result / nm;// 计算差多少分钟
        } else if (type.equals("sec")) {
            result = result / ns;// 计算差多少秒
        }
        return result;
    }

    /**
     * 判断 当前日期时间 前推小n天
     * 
     * @return
     */
    public synchronized static String getBackDay(int settleCycle) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(GregorianCalendar.DATE, -settleCycle);
        return sdf.format(cal.getTime());
    }

    /**
     * 判断指定时间的前一天
     * 
     * @param date
     * @return
     */
    public static Date getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -2);
        date = calendar.getTime();
        return date;
    }

    /**
     * 判断指定时间后推n天
     * 
     * @param date
     * @param settleCycle
     * @return
     */
    public static String getNextDay(String date, int settleCycle) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getToDateObject(date));
        calendar.add(Calendar.DAY_OF_MONTH, settleCycle);
        return sdf.format(calendar.getTime());
    }

    /**
     * 当天开始时间
     */
    public static Date getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 当天结束时间
     * 
     * @return
     */
    public static Date getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * 获取当天时间的时间差
     * 
     * @throws ParseException
     */
    public static long getTimeSeconds() throws ParseException {
        String endDate = DateTimeUtils.getCurrentDate() + " 23:59:59";

        Date parse = FULL_DATE_TIME_FORMAT.parse(endDate);

        long starttime = new Date().getTime();
        long endtime = parse.getTime();
        long time = ((endtime - starttime) / 1000);
        return time;
    }

    /**
     * 获取N位随机数
     * 
     * @param n
     * @return
     */
    public static String random(int n) {
        if (n < 1 || n > 10) {
            throw new IllegalArgumentException("cannot random " + n + " bit number");
        }
        Random ran = new Random();
        if (n == 1) {
            return String.valueOf(ran.nextInt(10));
        }
        String tmp_s = "";
        for (int i = 0; i < n; i++) {
            tmp_s += ran.nextInt(10);
        }
        return new String(tmp_s);
    }

    /**
     * 比较两个日期时间大小
     * 
     * @param time1
     * @param time2
     * @return
     * @throws ParseException
     */
    public static boolean compare(String time1, String time2) throws ParseException {
        // 如果想比较日期则写成"yyyy-MM-dd"就可以了
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 将字符串形式的时间转化为Date类型的时间
        Date a = sdf.parse(time1);
        Date b = sdf.parse(time2);
        // Date类的一个方法，如果a早于b返回true，否则返回false
        if (a.before(b))
            return true;
        else
            return false;
        /*
         * 如果你不喜欢用上面这个太流氓的方法，也可以根据将Date转换成毫秒
        if(a.getTime()-b.getTime()<0)
        	return true;
        else
        	return false;
        */
    }

    /**
     * 获取传入时间是星期几 0:星期天 1：星期一
     **/
    public static int lookDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 获取传入时间是几号
     **/
    public static int lookDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 批次号生成 生成规则：当天日期[8位]+序列号[24位]，如：20181031383385283484579432669936
     * 
     * @return
     */
    public static String getRandomBatchNum() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String format = dateFormat.format(new Date());
        int max = 24;
        int min = 24;
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s; i++) {
            Integer val = (int)(Math.random() * 9 + 1);
            buffer.append(val.toString());
        }
        return format + buffer.toString();
    }

    /**
     * 生成时间区间
     * 
     * @param beginDate
     *            开始时间
     * @param maxDay
     *            差距最大天数
     * @return
     */
    public static Date[] randomDateTimeInterval(Date beginDate, int maxDay) {
        Date _beginDate = randomDateTime(beginDate, null);
        Date endDate = getDateTimeForword(_beginDate, maxDay);
        Date _endDate = randomDateTime(_beginDate, endDate);
        return new Date[] {_beginDate, _endDate};
    }

    /**
     * 获取给定范围内的随机时间
     * 
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Date randomDateTime(Date beginDate, Date endDate) {
        Date end = endDate == null ? new Date() : endDate;
        if (beginDate.getTime() >= end.getTime()) {
            return null;
        }
        long date = random(beginDate.getTime(), end.getTime());

        return new Date(date);
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long)(Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }
}
