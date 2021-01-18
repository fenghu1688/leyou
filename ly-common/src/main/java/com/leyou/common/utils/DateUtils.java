/**  
 * @Title: DateUtils.java 
 * @Package com.wondersgroup.wsseaf.v2.utils 
 * @author chenlin
 * @date 2016-7-30 下午12:46:56 
 * @version V1.0  
*/ 
package com.leyou.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

/** 
 * @ClassName: DateUtils 
 * @author chenlin
 * @date 2016-7-30 下午12:46:56 
 *  
 */
public class DateUtils {
	
	/**
	 * 按照指定的格式格式化日期
	 * @Title: formatDate 
	 * @param @param date     需要格式化的日期
	 * @param @param format   按照什么格式格式化日期
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws 
	 * @author chenlin
	 * @date 2016-7-30 下午1:01:41
	 */
	public static String formatDate(Date date,String format){
		if(date == null ){
			date = new Date();
		}
		if(!StringUtils.hasText(format)){
			format = "yyyyMMdd HH:mm:ss";
		}
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(date);
	}
	
	/**
	 * 返回符合javascript格式化的年月日的字符串
	 * @Title: getSysDateForJavaScript 
	 * @param @param date
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws 
	 * @author chenlin
	 * @date 2016-8-4 上午10:28:48
	 */
	public static String getSysDateForJavaScript(Date date){
		if(date == null){
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR)+"-"+c.get(Calendar.MONTH)+"-"+c.get(Calendar.DAY_OF_MONTH);
	}
	/**
	 * 按照yyyyMMdd的格式格式化日期
	 * @Title: formatDateByYmd 
	 * @param @param date
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws 
	 * @author chenlin
	 * @date 2016-7-30 下午1:05:03
	 */
	public static String formatDateByYmd(Date date){
		if(date == null){
			date = new Date();
		}
		return formatDate(date,"yyyyMMdd");
	}
	
	/**
	 * 把字符串转成日期对象，如果返回null，则表示转换失败
	 * @Title: parseDate 
	 * @param @param d
	 * @param @param format
	 * @param @return    设定文件 
	 * @return Date    返回类型 
	 * @throws 
	 * @author chenlin
	 * @date 2016-7-30 下午1:07:33
	 */
	public static Date parseDate(String d,String format){
		try {
			SimpleDateFormat sf = new SimpleDateFormat(format);
			return sf.parse(d);
		} catch (ParseException e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 检查当前时间是否在参保期内，true表示在，false表示不在
	 * @Title: checkInCbsj 
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws 
	 * @author chenlin
	 * @date 2016-7-31 下午12:44:05
	 */
	public static Boolean checkInCbsj(String cbqStart,String cbqEnd){
		Integer sM = Integer.parseInt(cbqStart.substring(0,2));
		Integer sD = Integer.parseInt(cbqStart.substring(2));
		
		Integer eM = Integer.parseInt(cbqEnd.substring(0,2));
		Integer eD = Integer.parseInt(cbqEnd.substring(2));
		
		Date now = new Date();//当前时间
		Calendar cbsj = Calendar.getInstance();
		cbsj.set(cbsj.get(Calendar.YEAR),sM-1,sD);//当年的9月1号
		if(now.getTime() < cbsj.getTime().getTime()){//小于当年的9月1号
			return false;
		}else{
			cbsj.set(cbsj.get(Calendar.YEAR),eM-1,eD);//当年的9月30号
			if(now.getTime() <= cbsj.getTime().getTime()){
				return true;
			}else{
				return false;
			}
		}
	}
	
	/**
	 * 根据出生日期判断是否是两个月内新出生,true表示是两个月内的新生儿,false不是,
	 * @Title: isXsr 
	 * @param @param csrq  出生日期的格式是yyyy-MM-dd
	 * @param @return    设定文件 
	 * @return Boolean    返回类型 
	 * @throws 
	 * @author chenlin
	 * @date 2016-7-31 下午12:48:05
	 */
	public static Boolean isXsr(String csrq){
		return isXsr(csrq,"yyyy-MM-dd");
	}
	
	/**
	 * 根据出生日期判断是否是两个月内新出生,true表示是两个月内的新生儿,false不是,
	 * @Title: isXsr 
	 * @param @param csrq
	 * @param @param format
	 * @param @return    设定文件 
	 * @return Boolean    返回类型 
	 * @throws 
	 * @author chenlin
	 * @date 2016-10-3 下午6:54:11
	 */
	public static Boolean isXsr(String csrq,String format){
		Date birth = parseDate(csrq, format);
		Date now = parseDate(formatDate(new Date(),"yyyy-MM-dd"), "yyyy-MM-dd");
		Calendar birthC = Calendar.getInstance();
		birthC.setTime(birth);
		Calendar twoMonths = Calendar.getInstance();
		twoMonths.set(birthC.get(Calendar.YEAR),birthC.get(Calendar.MONTH)+2 , birthC.get(Calendar.DAY_OF_MONTH));
		if(twoMonths.get(Calendar.DAY_OF_MONTH) != birthC.get(Calendar.DAY_OF_MONTH)){
			twoMonths.set(Calendar.MONTH, twoMonths.get(Calendar.MONTH) - 1);
			twoMonths.set(Calendar.DAY_OF_MONTH, twoMonths.getActualMaximum(Calendar.DAY_OF_MONTH));
		}
		Calendar nowC = Calendar.getInstance();
		nowC.setTime(now);
		if(nowC.getTimeInMillis() > twoMonths.getTimeInMillis()){//表示已经超出两个自然月
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 判断是否是一周岁，true表示在一周岁内，false表示已经超过一周岁
	 * @Title: isOneYear 
	 * @param @param csrq
	 * @param @return    设定文件 
	 * @return Boolean    返回类型 
	 * @throws 
	 * @author chenlin
	 * @date 2016-8-4 上午10:27:08
	 */
	public static Boolean isOneYear(String csrq){
		Date birth = parseDate(csrq, "yyyy-MM-dd");
		Calendar birthC = Calendar.getInstance();
		birthC.setTime(birth);
		Calendar oneYear = birthC;
		oneYear.set(Calendar.YEAR, oneYear.get(Calendar.YEAR)+1);
		if(oneYear.get(Calendar.MONTH) != birthC.get(Calendar.MONTH)){
			oneYear.set(Calendar.MONTH, oneYear.get(Calendar.MONTH) -1 );
			oneYear.set(Calendar.DAY_OF_MONTH, oneYear.getActualMaximum(Calendar.DAY_OF_MONTH));
		}
		Date now = parseDate(formatDate(new Date(),"yyyy-MM-dd"), "yyyy-MM-dd");
		Calendar nowC = Calendar.getInstance();
		nowC.setTime(now);
		if(nowC.getTimeInMillis() > oneYear.getTimeInMillis()){//表示已经超出1周岁
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 计算参保期
	 * @Title: getCbqjByCbnd 
	 * @param @param cbnd
	 * @param @return    设定文件 
	 * @return Integer[]    返回类型 
	 * @throws 
	 * @author chenlin
	 * @date 2016-10-3 下午3:11:19
	 */
	public static Integer[] getCbqjByCbnd(Integer cbnd,String cbqStart,String cbqEnd){
		Integer[] cbq = new Integer[2];
		cbq[0] = Integer.valueOf(cbnd+cbqStart);
		cbq[1] = Integer.valueOf(cbnd+cbqEnd);
		return cbq;
	}
	
	/**
	 * 计算待遇时间
	 * @Title: getCbqBycbnd 
	 * @param @param cbnd
	 * @param @return    设定文件 
	 * @return Integer[]    返回类型 
	 * @throws 
	 * @author chenlin
	 * @date 2016-10-3 下午3:09:41
	 */
	@SuppressWarnings("deprecation")
	public static Integer[] getCbqBycbnd(Integer cbnd,String cbqStart){
		Integer[] cbq = new Integer[2];
		cbq[0] = Integer.valueOf( cbnd+cbqStart);
		Date d = parseDate(cbq[0]+"","yyyyMMdd");
		d.setDate(d.getDate()-1);
		d.setYear(d.getYear()+1);
		cbq[1] = Integer.valueOf(formatDateByYmd(d));
		return cbq;
	}
	
	public static Integer[] getCbqBycbnd(Integer cbnd){
		Integer[] cbq = new Integer[2];
		cbq[0] = Integer.valueOf( cbnd+"0901");
		cbq[1] = Integer.valueOf((cbnd+1)+"0831");
		return cbq;
	}
	
	/**
	 * 获取参保年度
	 * @Title: getCbnd 
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws 
	 * @author chenlin
	 * @date 2016-7-31 上午11:53:47
	 */
	public static int getCbnd(String cbqStart){
		Integer month = Integer.valueOf(cbqStart.substring(0,2));
		Integer date = Integer.valueOf(cbqStart.substring(2));
		Date now = new Date();
		Calendar c = Calendar.getInstance();
		c.set(c.get(Calendar.YEAR), month-1, date);
		if(now.getTime() >= c.getTime().getTime()){
			return c.get(Calendar.YEAR);
		}else{
			return c.get(Calendar.YEAR) - 1;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(formatDate(new Date(), "yyyyMMddHHmmss"));
		System.out.println(getSysDateForJavaScript(null));
		for(Integer s : getCbqBycbnd(2016,"0901")){
			System.out.println(s);
		}
		String str = "10";
		System.out.println(Integer.valueOf(str));
		
	}
}
