package com.sic.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class StringUtil {

	/**
	 * 判断对象是否为null
	 *
	 * @author <a href='mailto:dennisit@163.com'>Cn.苏若年(En.dennisit)</a> Copy Right since 2013-9-14 下午01:42:01
	 *				
	 * @param object	目标对象类型
	 * @return
	 */
	public static boolean isNullValue(Object object){
	    if (null == object) {
	    	return true;
	    }
	    if ((object instanceof String)){
	    	return "".equals(((String)object).trim());
	    }
	    return false;
	}

	/**
	 * 判断对象是否不为null
	 *
	 * @author <a href='mailto:dennisit@163.com'>Cn.苏若年(En.dennisit)</a> Copy Right since 2013-9-14 下午01:43:20
	 *				
	 * @param object
	 * @return
	 */
	public static boolean isNotNullValue(Object object){
	    return !isNullValue(object);
	}
	
	
	public static final String LASTURL_COKIENAME = "lastUrl";

	public static final String ascii2Html(String target) {
		if ((target == null) || (target.length() == 0))
			return target;
		target = replaceString(target, "&", "&amp;");
		target = replaceString(target, "\"", "&quot;");
		target = replaceString(target, "<", "&lt;");
		target = replaceString(target, ">", "&gt;");
		// target = replaceString(target, " ", "&nbsp;");
		target = replaceString(target, "'", "&#39");
		target = replaceString(target, "\r\n", "<br>");
		target = replaceString(target, "\r\n", "<br/>");

		return target;
	}

	public static final String ascii2Html_2(String target) {
		if ((target == null) || (target.length() == 0))
			return target;
		target = replaceString(target, "&", "&amp;");
		target = replaceString(target, "\"", "&quot;");
		target = replaceString(target, "<", "&lt;");
		target = replaceString(target, ">", "&gt;");
		target = replaceString(target, " ", "&nbsp;");
		target = replaceString(target, "'", "&#39");
		target = replaceString(target, "\r\n", "<br>");
		target = replaceString(target, "\r\n", "<br/>");

		return target;
	}

	public static long bin2Dec(String paramString) {
		int i = paramString.length();
		long l = 0L;
		for (int k = 0; k < i; ++k) {
			int j = getInt(paramString.substring(i - k - 1, i - k));
			l = (long) (l + j * Math.pow(2.0D, k));
		}
		return l;
	}

	private static final String byte2String(byte[] bytes) {
		String str = new String(bytes);
		if (str.length() == 0) {
			int i = bytes.length;
			if (i > 1) {
				byte[] b2 = new byte[i - 1];
				for (int j = 0; j < i - 1; ++j)
					b2[j] = bytes[j];
				return byte2String(b2);
			}
			return "";
		}
		return str;
	}

	public static final String checkedIt(long paramLong1, long paramLong2) {
		return ((paramLong1 == paramLong2) ? "checked" : "");
	}

	public static final String checkedIt(String paramString1,
			String paramString2) {
		return ((paramString1.equals(paramString2)) ? "checked" : "");
	}

	public static String convertArry2Str(String[] value) {
		StringBuilder valueSb = new StringBuilder();
		for (int i = 0; (value != null) && (i < value.length); i++) {
			valueSb.append(value[i]);

			if (i < value.length - 1) {
				valueSb.append(",");
			}
		}

		return valueSb.toString();
	}

	public static final String cuteNR(String paramString) {
		paramString = replaceString(paramString, "\n", "");
		paramString = replaceString(paramString, "\r", "");
		return paramString;
	}

	public static final String cutString(String paramString1, int paramInt,
			String paramString2) {
		int i = paramString1.length();
		if (i > paramInt)
			paramString1 = paramString1.substring(0, paramInt) + paramString2;
		return paramString1;
	}

	public static final String dealNull(String target) {
		if (target == null)
			return "";
		return target;
	}

	public static final String dealSql(String target) {
		if ((target == null) || (target.trim().length() == 0))
			return target;
		String str = replaceString(target.trim().replaceAll("\r", ""), "'",
				"''");
		str = replaceString(str, "\\", "\\\\");
		if (str.charAt(0) != '\'')
			str = "'" + str;
		if (!(str.endsWith("'")))
			str = str + "'";
		return str;
	}

	public static String decode(String value) {
		String ret = "";
		try {
			ret = URLDecoder.decode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static String deCodeBackURL(String paramString) {
		return paramString.replace('!', '&');
	}

	public static String enCodeBackURL(String paramString) {
		return paramString.replace('&', '!');
	}

	/**
	 * DateTime的解析的日期字符串为2012-02-13T11:23:11
	 * 
	 * @param datets
	 * @return 2012-02-13T11:23:11
	 */	
	public static String format2JodaDateTime(String datets) {
		if (datets.indexOf("-") != -1 && datets.indexOf(":") != -1
				&& datets.indexOf(" ") == 11) {
			datets = datets.replace(" ", "T");
		}
		return datets;
	}

	public static String formatNumber(String paramString, double paramDouble) {
		DecimalFormat localDecimalFormat = new DecimalFormat(paramString);
		return localDecimalFormat.format(paramDouble);
	}

	public static String formatNumber(String paramString, long paramLong) {
		DecimalFormat localDecimalFormat = new DecimalFormat(paramString);
		return localDecimalFormat.format(paramLong);
	}

	public static final String GB23122UTF8(String target) {
		try {
			return new String(target.getBytes("GB2312"), "UTF-8");
		} catch (Exception localException) {
			System.err.println("GBK2ISO编码转换出错!");
		}
		return null;
	}

	public static final String GBK2ISO(String target) {
		try {
			return new String(target.getBytes("GBK"), "ISO8859_1");
		} catch (Exception localException) {
			System.err.println("GBK2ISO编码转换出错!");
		}
		return null;
	}

	public static String getAllParameters(HttpServletRequest httpServletRequest) {
		Enumeration<String> enums = httpServletRequest.getParameterNames();
		StringBuffer localStringBuffer = new StringBuffer("");
		while (enums.hasMoreElements()) {
			String str1 = (String) enums.nextElement();
			String str2 = httpServletRequest.getParameter(str1);
			localStringBuffer.append(str1);
			localStringBuffer.append("=");
			localStringBuffer.append(str2);
			localStringBuffer.append("&");
		}
		return localStringBuffer.toString();
	}

	public static final String getAttribute(
			HttpServletRequest httpServletRequest, String name) {
		if (name == null)
			return null;
		String str = (String) httpServletRequest.getSession()
				.getAttribute(name);
		if ((str != null) && (!(str.equals(""))))
			return str.trim();
		return "";
	}

	public static final String getBackURL(HttpServletRequest httpServletRequest) {
		String backUrl = getString(httpServletRequest, "backurl");
		backUrl = replaceString(backUrl, "@", "");
		if (backUrl.equals("")) {
			String referer = httpServletRequest.getHeader("referer");
			if (referer == null) {
				referer = "";
			}

			return referer;
		}
		return backUrl;
	}

	public static final boolean getBooleanType(int paramInt) {
		return (paramInt == 1);
	}

	public static String getCurrentURL(HttpServletRequest httpServletRequest) {
		String str = httpServletRequest.getQueryString();
		if (str == null)
			return httpServletRequest.getRequestURI();
		return httpServletRequest.getRequestURI() + "?" + str;
	}

 

	public static int getCurrPage(HttpServletRequest request) {

		int currPage = 1;
		try {
			String page = request.getParameter("p");
			if (null == page || "".equals(page)) {
				return currPage;
			}
			currPage = Integer.parseInt(page);
		} catch (Exception e) {
			currPage = 1;
		}
		return currPage;
	}

	public static final double getDouble(HttpServletRequest httpServletRequest,
			String paramString) {
		String str = getString(httpServletRequest, paramString);
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return 0D;
		}
	}

	public static final double getDouble(String input) {
		if (StringUtil.isBlank(input) == true) {
			input = "0";
		}
		try {
			return Double.parseDouble(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return 0D;
	}

	public static final double getDoubleType() {
		return 0D;
	}

	public static final boolean getFalseType() {
		return false;
	}

	public static final float getFloat(HttpServletRequest httpServletRequest,
			String paramString) throws Exception, NumberFormatException {
		String str = httpServletRequest.getParameter(paramString);
		if (str == null)
			return 0F;
		try {
			return Float.parseFloat(str.trim());
		} catch (NumberFormatException e) {
		}
		return 0F;
	}

	public static final float getFloat(HttpServletRequest httpServletRequest,
			String paramString, float paramFloat) throws Exception,
			NumberFormatException {
		String str = httpServletRequest.getParameter(paramString);
		if (str == null) {
			System.err.println("val is null,so return default!");
			return paramFloat;
		}
		try {
			return Float.parseFloat(str.trim());
		} catch (NumberFormatException e) {
			System.err
					.println("getFloat(HttpServletRequest request,String strName,float def) NumberFormatException for input string:"
							+ str + ",so return default!");
		}
		return paramFloat;
	}

	public static final float getFloat(String paramString) throws Exception,
			NumberFormatException {
		if (paramString == null)
			throw new Exception("Input value is NULL!");
		try {
			return Float.parseFloat(paramString.trim());
		} catch (NumberFormatException e) {
			throw new NumberFormatException(
					"getFloat(String) NumberFormatException for input string:"
							+ paramString);
		}
	}

	public static float getFloatFromSession(HttpSession paramHttpSession,
			String paramString) {
		if (getStringFromSession(paramHttpSession, paramString) != null)
			try {
				return getFloat(getStringFromSession(paramHttpSession,
						paramString));
			} catch (NumberFormatException e) {
				return 0F;
			} catch (Exception localException) {
				return 0F;
			}
		return 0F;
	}

	public static final float getFloatType() {
		return 0F;
	}

	public static final int getInt(HttpServletRequest httpServletRequest,
			String name) {
		return getInt(httpServletRequest, name, 0);
	}

	public static final int getInt(HttpServletRequest httpServletRequest,
			String name, int defaultValue) {
		if (httpServletRequest.getParameter(name) != null)
			try {
				int i = Integer.parseInt(httpServletRequest.getParameter(name));
				return i;
			} catch (NumberFormatException e) {
				return 0;
			}
		return defaultValue;
	}

	public static final int getInt(String paramString) {
		return getInt(paramString, 0);
	}

	public static final int getInt(String paramString, int paramInt) {
		if (paramString == null)
			return paramInt;
		try {
			return Integer.parseInt(paramString.trim());
		} catch (Exception localException) {
		}
		return paramInt;
	}

	public static int getIntFromSession(HttpSession paramHttpSession,
			String paramString) {
		if (getStringFromSession(paramHttpSession, paramString) != null)
			return getInt(getStringFromSession(paramHttpSession, paramString));
		return 0;
	}

	 
	private static int getLength(String paramString) {
		if (paramString == null)
			return 0;
		return paramString.getBytes().length;
	}

	public static final long getLong(HttpServletRequest httpServletRequest,
			String name) {
		if (httpServletRequest.getParameter(name) != null)
			try {
				long l = Long.parseLong(httpServletRequest.getParameter(name)
						.trim());
				return l;
			} catch (NumberFormatException e) {
				return 0L;
			}
		return 0L;
	}

	public static final long getLong(HttpServletRequest httpServletRequest,
			String name, long defaultValue) {
		if (httpServletRequest.getParameter(name) != null)
			try {
				long l = Long.parseLong(httpServletRequest.getParameter(name)
						.trim());
				return l;
			} catch (NumberFormatException e) {
				return 0L;
			}
		return defaultValue;
	}

	public static final long getLong(String input) throws Exception,
			NumberFormatException {
		if (StringUtil.isBlank(input) == true)
			input = "0";
		try {
			return Long.parseLong(input.trim());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return 0L;
	}

	public static final long getLong(String paramString, long paramLong) {
		if (paramString == null)
			return paramLong;
		try {
			return Long.parseLong(paramString);
		} catch (Exception localException) {
		}
		return paramLong;
	}

	public static final long getLongType() {
		return 0L;
	}

	public static final long getLongType(String paramString) {
		return Long.parseLong(paramString);
	}

	public static final String getMultiString(String[] paramArrayOfString) {
		return getMultiString(paramArrayOfString, ",");
	}

	public static final String getMultiString(String[] paramArrayOfString,
			String target) {
		if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
			return "";
		StringBuffer localStringBuffer = new StringBuffer();
		String str = target;
		String[] arrayOfString = paramArrayOfString;
		int i = 0;
		for (i = 0; i < arrayOfString.length - 1; ++i)
			localStringBuffer.append(arrayOfString[i] + str);
		localStringBuffer.append(arrayOfString[i]);
		return localStringBuffer.toString();
	}

	public static final Object getNullType() {
		return null;
	}

	public static final Object getObjectType() {
		return new Object();
	}

	public static float getPayCostPercent(float paramFloat) {
		DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
		df.setMaximumFractionDigits(2);
		return Float.parseFloat(df.format(paramFloat * 100.0F));
	}

	public static String getPersentString(String paramString) {

		return Float.parseFloat(paramString.trim()) * 100 + "%";
	}

	public static String getRannumber() {
		StringBuffer strbufguess = new StringBuffer();
		String strguess = new String();
		int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random rannum = new Random();
		int count;
		int i = 0, temp_i = 0;
		for (int j = 10; j > 4; j--) {
			i = 0;
			temp_i = 0;
			count = rannum.nextInt(j);
			while (i <= count) {
				if (nums[temp_i] == -1) {
					temp_i++;
				} else {
					i++;
					temp_i++;
				}
			}
			strbufguess.append(Integer.toString(nums[temp_i - 1]));
			nums[temp_i - 1] = -1;
		}
		strguess = strbufguess.toString();
		rannum = null;
		strbufguess = null;
		nums = null;
		return strguess;
	}

	/**
	 * 分割字符串
	 */
	public static String[] getReplaceString(String str) {
		if (str != null) {
			str = str.replace(",", ";");
			str = str.replace("_", ";");
			str = str.replace(" ", ";");
			str = str.replace("/", ";");
			str = str.replace("\\", ";");
			String[] arrstr = str.split(";");
			return arrstr;
		}
		return null;
	}

	public static final HttpSession getSession(
			HttpServletRequest httpServletRequest) {
		return httpServletRequest.getSession(true);
	}

	public static final HttpSession getSessionV2(
			HttpServletRequest httpServletRequest) {
		return httpServletRequest.getSession(true);
	}

	public static String getStatusForCheckBoxAndRadio(int paramInt) {
		if (paramInt == 0)
			return "";
		return "checked";
	}

	public static final String getString(HttpServletRequest httpServletRequest,
			String name) {
		// logger.info("StringUtil.getString(HttpServletRequest httpServletRequest, String name) name = "+
		// name);

		if (name == null || "".equals(name) || name.length() == 0)
			return null;
		if (httpServletRequest == null) {
			return "";
		}
		String str = httpServletRequest.getParameter(name);

		if ((str != null) && (!(str.equals(""))))
			return str.trim();
		return "";
	}

	public static final String getString(HttpServletRequest httpServletRequest,
			String paramString1, String paramString2) {
		String str = httpServletRequest.getParameter(paramString1);
		if ((str != null) && (!(str.equals(""))))
			return str.trim();
		return paramString2;
	}
	
	public static final String getStringFromMap(Map target,String name) {
		if(target==null)
		{
			return "";
		}else
		{
			if (target.get(name)==null)
			{
				return "";
			}else
			{
				String[] values = (String[]) target.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				return valueStr;
			}
			

			
		}
	}

	public static final String getString(String target) {
		return getString(target, null);
	}

	public static final String getString(String paramString, int paramInt) {
		if (paramString == null)
			return null;
		if (getLength(paramString) <= paramInt)
			return paramString;
		byte[] arrayOfByte1 = paramString.getBytes();
		byte[] arrayOfByte2 = new byte[paramInt];
		for (int i = 0; i < paramInt; ++i)
			arrayOfByte2[i] = arrayOfByte1[i];
		return byte2String(arrayOfByte2);
	}

	public static final String getString(String target, String replace) {
		if (target == null)
			return replace;
		return target;
	}

	public static final String[] getStringArray(
			HttpServletRequest httpServletRequest, String name) {
		String[] arr = httpServletRequest.getParameterValues(name);
		return arr;
	}

	public static String getStringFromSession(HttpSession paramHttpSession,
			String paramString) {
		if (paramHttpSession.getAttribute(paramString) != null)
			return paramHttpSession.getAttribute(paramString).toString();
		return null;
	}

	public static String getSyncMd5(String sign) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();

			messageDigest.update(sign.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}

		return md5StrBuff.toString();
	}

	public static final boolean getTrueType() {
		return true;
	}

	/**
	 * 隐藏部分手机号码
	 * 
	 * @param mobile
	 * @param begin
	 * @param length
	 * @return
	 */
	public static String hideMobile(String mobile, int begin, int length) {
		if (begin == 0) {
			begin = 4;
		}
		if (length > 7 || length < 4) {
			length = 4;
		}
		StringBuffer ret = new StringBuffer();
		String first = mobile.substring(0, begin);
		ret.append(first);

		for (int i = 0; i < length; i++) {
			ret.append("*");
		}

		String end = mobile.substring(begin + length, mobile.length());
		ret.append(end);

		return ret.toString();
	}

	public static final String html2Ascii(String target) {
		if ((target == null) || (target.length() == 0))
			return target;
		target = replaceString(target, "&amp;", "&");
		target = replaceString(target, "&quot;", "\"");
		target = replaceString(target, "&lt;", "<");
		target = replaceString(target, "&gt;", ">");
		target = replaceString(target, "&nbsp;", " ");
		target = replaceString(target, "&#39", "'");
		target = replaceString(target, "<br>", "\r\n");
		target = replaceString(target, "<br/>", "\r\n");
		target = replaceString(target, "<br />", "\r\n");
		return target;
	}

	public static final String html2Ascii_2(String target) {
		if ((target == null) || (target.length() == 0))
			return target;
		target = replaceString(target, "&amp;", "&");
		target = replaceString(target, "&quot;", "\"");
		target = replaceString(target, "&lt;", "<");
		target = replaceString(target, "&gt;", ">");
		target = replaceString(target, "&nbsp;", " ");
		target = replaceString(target, "&#39", "'");
		target = replaceString(target, "<br >", "\r\n");
		target = replaceString(target, "<br />", "\r\n");
		target = replaceString(target, "<br/>", "\r\n");
		return target;
	}

	public static final String html2Ascii_3(String target) {
		if ((target == null) || (target.length() == 0))
			return target;
		if (target.indexOf("&lt;") != -1) {
			target = replaceString(target, "&lt;", "<");
		}
		if (target.indexOf("&gt;") != -1) {
			target = replaceString(target, "&gt;", ">");
		}
		if (target.indexOf("&quot;") != -1) {
			target = replaceString(target, "&quot;", "\"");
		}

		return target;
	}

	public static final String html2encoder(String target) {
		if ((target == null) || (target.length() == 0))
			return target;
		target = replaceString(target,
				"&lt;font style=&quot;color:red&quot;&gt;", "");
		target = replaceString(target, "&lt;/font&gt;", "");
		try {
			target = URLEncoder.encode(target, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return target;
	}

	public static final String html2hotkey(String target) {
		if ((target == null) || (target.length() == 0))
			return target;
		target = replaceString(target,
				"&lt;font style=&quot;color:red&quot;&gt;", "");
		target = replaceString(target, "&lt;/font&gt;", "");

		return target;
	}

	/**
	 * 把字符窜(source)截取规定的英文长度(length)并在后面加上后缀。
	 * 如：把“我们都有一个家”截取8英文个字符再加上“...”就是：“我们都有...”
	 * 
	 * @param source
	 * @param length
	 * @param postfix
	 * @return
	 */
	public static String interceptString(String source, int length,
			String postfix) {
		String value = source;
		if (value != null && !"".equals(value.trim())) {
			if (source.getBytes().length > length) {
				int enlength = length;
				char[] chs = value.toCharArray();
				value = "";
				for (int i = 0; enlength > 0 && i < chs.length; i++) {
					Character ch = chs[i];
					if (ch.toString().getBytes().length > 1) {
						enlength -= 2;
					} else {
						enlength -= 1;
					}
					if (enlength >= 0) {
						value += ch;
					}
				}
				if (source.getBytes().length > length && postfix != null) {
					value += postfix;
				}
			}

		} else {
			value = "";
		}
		return value;
	}

	public static final boolean isBlank(String target) {
		return ((target == null) || (target.trim().length() == 0) || ""
				.equals(target));
	}

	public static boolean isIP(String ip) throws Exception {
		String pattern = "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$";

		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(ip);

		return matcher.matches();
	}

	public static final boolean isNotBlank(String target) {
		return isBlank(target) == false ? true : false;
	}

	public static final int isNull(Object paramObject) {
		if (paramObject == null)
			return 1;
		return 0;
	}

	public static final boolean isNullObject(Object paramObject) {
		if (paramObject == null)
			return true;
		return false;
	}

	public static String ISO2GBK(String target) {
		try {
			return new String(target.getBytes("ISO8859_1"), "GBK");
		} catch (Exception localException) {
			System.err.println("ISO2GBK编码转换出错!");
		}
		return null;
	}

	public static final String ISO2UTF8(String target) {
		try {
			return new String(target.getBytes("ISO8859-1"), "UTF-8");
		} catch (Exception localException) {
			System.err.println("ISO2UTF8");
		}
		return null;
	}

	public static final String loginWebSite(String paramString)
			throws Exception {
		StringBuffer localStringBuffer = new StringBuffer("");
		URL localURL = new URL(paramString);
		HttpURLConnection localHttpURLConnection = (HttpURLConnection) localURL
				.openConnection();
		localHttpURLConnection = (HttpURLConnection) localURL.openConnection();
		localHttpURLConnection.setRequestProperty("User-Agent",
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows 2000)");
		localHttpURLConnection.connect();
		InputStream localInputStream = localHttpURLConnection.getInputStream();
		BufferedReader localBufferedReader = new BufferedReader(
				new InputStreamReader(localInputStream, "UTF-8"));
		String str;
		while ((str = localBufferedReader.readLine()) != null) {
			localStringBuffer.append(str);
			localStringBuffer.append("\n");
		}
		return localStringBuffer.toString();
	}

	/**
	 * Produce a string in double quotes with backslash sequences in all the
	 * right places. A backslash will be inserted within </, producing <\/,
	 * allowing JSON text to be delivered in HTML. In JSON text, a string cannot
	 * contain a control character or an unescaped quote or backslash.
	 * 
	 * @param string
	 *            A String
	 * @return A String correctly formatted for insertion in a JSON text.
	 */
	public static String quote(String string) {
		if (string == null || string.length() == 0) {
			return "\"\"";
		}

		char b;
		char c = 0;
		String hhhh;
		int i;
		int len = string.length();
		StringBuffer sb = new StringBuffer(len + 4);

		sb.append('"');
		for (i = 0; i < len; i += 1) {
			b = c;
			c = string.charAt(i);
			switch (c) {
			case '\\':
			case '"':
				sb.append('\\');
				sb.append(c);
				break;
			case '/':
				if (b == '<') {
					sb.append('\\');
				}
				sb.append(c);
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\r':
				sb.append("\\r");
				break;
			default:
				if (c < ' ' || (c >= '\u0080' && c < '\u00a0')
						|| (c >= '\u2000' && c < '\u2100')) {
					hhhh = "000" + Integer.toHexString(c);
					sb.append("\\u" + hhhh.substring(hhhh.length() - 4));
				} else {
					sb.append(c);
				}
			}
		}
		sb.append('"');
		return sb.toString();
	}

	public static String readURL(String paramString) throws Exception {
		String str1 = "";
		String str2 = "";
		try {
			URL localURL = new URL(paramString);
			HttpURLConnection httpURLConnection = (HttpURLConnection) localURL
					.openConnection();
			httpURLConnection.connect();
			InputStream inputStream = httpURLConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					inputStream));
			while ((str1 = br.readLine()) != null)
				str2 = str2 + str1 + "\n";
			br.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return str2;
	}

	public static String regReplace(String paramString1, String paramString2,
			String paramString3) {
		String str = new String();
		str = paramString1;
		if ((paramString1 != null) && (!(paramString1.equals("")))) {
			str = paramString1;
			Pattern localPattern = Pattern.compile(paramString2, 2);
			Matcher localMatcher = localPattern.matcher(str);
			StringBuffer localStringBuffer = new StringBuffer();
			// int i = 0;
			for (boolean bool = localMatcher.find(); bool; bool = localMatcher
					.find()) {
				// ++i;
				localMatcher.appendReplacement(localStringBuffer, paramString3);
			}
			localMatcher.appendTail(localStringBuffer);
			str = localStringBuffer.toString();
		} else {
			str = "";
		}
		return str;
	}

	public static String removeHH(String paramString) {
		return replaceString(replaceString(paramString, "\n", ""), "\r", "");
	}

	public static final String replaceBr(String target) {
		if ((target == null) || (target.length() == 0))
			return target;
		target = replaceString(target, "<br/>", "\r\n");
		target = replaceString(target, "<br/>", "\n");
		target = replaceString(target, "<br>", "\r\n");
		target = replaceString(target, "<br/>", "\n");
		return target;
	}

	public static final String replaceEnter(String target) {
		if ((target == null) || (target.length() == 0))
			return target;
		target = replaceString(target, "\r\n", "<br/>");
		target = replaceString(target, "\r\n", "<br>");
		return target;
	}

	/**
	 * 将target中的sign替换成value
	 * 
	 * @param target
	 * @param sign
	 * @param value
	 * @return
	 */
	public static final String replaceString(String target, String sign,
			String value) {
		if ((target == null) || (target.length() == 0))
			return target;
		StringBuffer sb = new StringBuffer();
		int i;
		while ((i = target.indexOf(sign)) >= 0) {
			sb.append(target.substring(0, i));
			sb.append(value);
			target = target.substring(i + sign.length());
		}
		if (target.length() > 0)
			sb.append(target);
		return sb.toString();
	}

	public static final String selectIt(long paramLong1, long paramLong2) {
		return ((paramLong1 == paramLong2) ? "selected" : "");
	}

	public static final String subString(String str, int len) {
		StringBuffer sb = new StringBuffer();
		if (!StringUtil.isBlank(str)) {
			if (str.getBytes().length != str.length()) {
				// 为中文
				if (str.length() > len) {
					sb.append(str.substring(0, len)).append("...");
				} else {
					sb.append(str);
				}
			} else {
				if (str.length() > 16) {
					sb.append(str.substring(0, 15)).append("...");
				} else {
					sb.append(str);
				}
			}
		}
		if (sb.toString().equals("")) {
			return "";
		} else {
			return sb.toString();
		}
	}

	public static final String subStringBegin1(String string) {
		return string.substring(1);
	}

	/**
	 * 按字节长度截取字符串(支持截取带HTML代码样式的字符串),并自动补全截断的HTML代码样式
	 * 
	 * @param param
	 *            将要截取的字符串参数
	 * @param length
	 *            截取的字节长度
	 * @param end
	 *            字符串末尾补上的字符串
	 * @return 返回截取后的字符串
	 */
	public static String subStringHTML(String param, int length, String end) {
		StringBuffer result = new StringBuffer();
		int n = 0;
		char temp;
		boolean isCode = false; // 是不是HTML代码
		boolean isHTML = false; // 是不是HTML特殊字符,如&nbsp;
		boolean append = false;
		for (int i = 0; i < param.length(); i++) {
			temp = param.charAt(i);
			if (temp == '<') {
				isCode = true;
			} else if (temp == '&') {
				isHTML = true;
			} else if (temp == '>' && isCode) {
				n = n - 1;
				isCode = false;
			} else if (temp == ';' && isHTML) {
				isHTML = false;
			}

			if (!isCode && !isHTML) {
				n = n + 1;
				// UNICODE码字符占两个字节
				if ((temp + "").getBytes().length > 1) {
					n = n + 1;
				}
			}

			result.append(temp);
			if (n >= length) {
				append = true;
				break;
			}
		}
		result.append(end);
		// 取出截取字符串中的HTML标记
		String temp_result = result.toString().replaceAll("(>)[^<>]*(<?)",
				"$1$2");
		// 去掉不需要结素标记的HTML标记
		temp_result = temp_result
				.replaceAll(
						"</?(AREA|BASE|BASEFONT|BODY|BR|COL|COLGROUP|DD|DT|FRAME|HEAD|HR|HTML|IMG|INPUT|ISINDEX|LI|LINK|META|OPTION|P|PARAM|TBODY|TD|TFOOT|TH|THEAD|TR|area|base|basefont|body|br|col|colgroup|dd|dt|frame|head|hr|html|img|input|isindex|li|link|meta|option|p|param|tbody|td|tfoot|th|thead|tr)[^<>]*/?>",
						"");
		// 去掉成对的HTML标记
		temp_result = temp_result.replaceAll("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>",
				"$2");
		// 用正则表达式取出标记
		Pattern p = Pattern.compile("<([a-zA-Z]+)[^<>]*>");
		Matcher m = p.matcher(temp_result);

		List<String> endHTML = new ArrayList<String>();

		while (m.find()) {
			endHTML.add(m.group(1));
		}
		// 补全不成对的HTML标记
		for (int i = endHTML.size() - 1; i >= 0; i--) {
			result.append("</");
			result.append(endHTML.get(i));
			result.append(">");
		}
		if (append) {
			result.append(end);
		}
		return result.toString();
	}

	public static final String UTF82GB2312(String target) {
		try {
			return new String(target.getBytes("UTF-8"), "gb2312");
		} catch (Exception localException) {
		}
		return null;
	}

	public static final String UTF82GBK(String target) {
		try {
			return new String(target.getBytes("UTF-8"), "GBK");
		} catch (Exception localException) {
		}
		return null;
	}

	public static final String UTF82ISO(String target) {
		try {
			return new String(target.getBytes("UTF-8"), "ISO8859-1");
		} catch (Exception localException) {
			System.err.println("GBK2ISO编码转换出错!");
		}
		return null;
	}

	public static final String Windows1252UTF8(String target) {
		try {
			return new String(target.getBytes("Windows-1252"), "UTF-8");
		} catch (Exception localException) {
			System.err.println("Windows1252UTF8");
		}
		return null;
	}

	public static String withColor(String paramString1, String paramString2,
			boolean paramBoolean) {
		if (paramBoolean)
			return "<font color='".concat(paramString2).concat("'>")
					.concat(paramString1).concat("</font>");
		return paramString1;
	}

	/**
	 * 删除target字符串中的html格式
	 * 
	 * @param target
	 * @param length
	 * @return
	 */
	public static String splitAndFilterHTML(String target, int showLength,
			String end) {
		if (target == null || target.trim().equals("")) {
			return "";
		}
		// 去掉所有html元素,
		String str = target.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll(
				"<[^>]*>", "");
		str = str.replaceAll("[(/>)<]", "");

		int len = str.length();
		if (showLength > 0) {
			if ((len <= showLength)) {
				return str;
			} else {
				str = str.substring(0, showLength);
				if (end != null && !"".equals(end) && end.length() > 0) {
					str += end;
				}
			}
		}

		return str;
	}

	public static String getServerIP() {
		InetAddress address = null;
		String hostAddr = null;
		try {
			address = InetAddress.getLocalHost();
			hostAddr = address.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return hostAddr;
	}

	public static String getRemortIP(HttpServletRequest request) {
		// 通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串ip值，应该取X-Forwarded-For中第一个非unknown的有效IP字符串
		String ip = request.getHeader("x-forwarded-for");
		// LogUtil.testInfo(" StringUtil.getRemortIP() x-forwarded-for ip = "+ip);
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
			// LogUtil.testInfo(" StringUtil.getRemortIP() Proxy-Client-IP = "+ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			// LogUtil.testInfo(" StringUtil.getRemortIP() WL-Proxy-Client-IP = "+ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			// LogUtil.testInfo(" StringUtil.getRemortIP()  getRemoteAddr = "+ip);
		}
		if (ip.indexOf(",") != -1) {
			ip = ip.split(",")[0];
		}
		if (ip != null && !"".equals(ip) && ip.length() > 15) {
			ip = ip.substring(0, 15);
		}
		// LogUtil.testInfo("截后 ip = "+ip);
		return ip;
	}

	public static String hideAccount(String account) {

		if (account == null)
			return "";

		StringBuffer ret = new StringBuffer();
		int length = account.length();

		if (length >= 2) {
			String first = account.substring(0, 1);
			String end = account.substring(length - 1, length);
			ret.append(first);
			// length = length==2?11:length;
			// for (int i = 0; i < length -2; i++) {
			// ret.append("*");
			// }
			// 改为显示3个*号
			ret.append("***");
			ret.append(end);
		} else if (account.trim() == "匿名用户") {
			ret.append("匿名用户");
		} else {
			ret.append(account);
			// for (int i = 0; i < 10; i++) {
			// ret.append("*");
			// }
			// 改为显示3个*号
			ret.append("***");
		}

		return ret.toString();
	}

	public static String hideAccount2(String account, int hiddenName) {
		if (account == null)
			return "";
		StringBuffer ret = new StringBuffer();
		int length = account.length();

		// 匿名发布
		if (hiddenName == 1) {
			ret.append("匿名用户");
		} else {
			if (account.trim().equals("匿名用户")) {
				ret.append("匿名用户");
			} else {
				if (length >= 2) {
					String first = account.substring(0, 1);
					String end = account.substring(length - 1, length);
					ret.append(first);
					ret.append("***");
					ret.append(end);
				} else {
					ret.append(account);
					ret.append("***");
				}
			}
		}
		return ret.toString();
	}

	public static String enCodeUrl(String paramString) {
		try {
			return URLEncoder.encode(paramString, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String encode(String value) {
		String ret = "";
		try {
			ret = URLEncoder.encode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public static String getBatchOid() {
		/*
		 * ljf@800pharm.com 银联支付对商户订单号有长度限制，最长只能是20位
		 * 因此需要改变订单批号生成方式
		 * */
//		UUIDUtil uuid = new UUIDUtil();
//		return uuid.generate().toString();
		return "ph"+System.nanoTime();
	}

	/*public static void main(String[] args) throws Exception {
		System.out
				.println(StringUtil
						.getSyncMd5("shopcode=43000&productcode=1150832&storage=40&price=27.2&marketprice=32&alive=1&datetime=20130702 16:05:03&signkey=c6a8488de86eddf87c84edf4136a1126"));
	}*/
}