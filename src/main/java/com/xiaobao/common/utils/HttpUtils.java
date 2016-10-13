package com.xiaobao.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.commons.collections.CollectionUtils;

import com.alibaba.fastjson.JSONArray;
import com.jfinal.kit.HttpKit;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

/**
 * Http请求的工具类 Created by King on 2016/1/23.
 */
public abstract class HttpUtils {
	private static final int TIMEOUT_IN_MILLIONS = 10000;

	public interface CallBack {
		void onRequestComplete(String result);
	}

	/**
	 * 异步的Get请求
	 *
	 * @param urlStr
	 * @param callBack
	 */
	public static void doGetAsyn(final String urlStr, final CallBack callBack) {
		new Thread() {
			public void run() {
				try {
					String result = doGet(urlStr);
					if (callBack != null) {
						callBack.onRequestComplete(result);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			;
		}.start();
	}

	/**
	 * 异步的Post请求
	 *
	 * @param urlStr
	 * @param params
	 * @param callBack
	 * @throws Exception
	 */
	@Deprecated
	public static void doPostAsyn(final String urlStr, final String params, final CallBack callBack) throws Exception {
		new Thread() {
			public void run() {
				try {
					String result = doPost(urlStr, params);
					if (callBack != null) {
						callBack.onRequestComplete(result);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			;
		}.start();

	}

	/**
	 * Get请求，获得返回数据
	 *
	 * @param urlStr
	 * @return
	 * @throws Exception
	 */
	public static String doGet(String urlStr) {
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader is = null;
		String result = "";
		// ByteArrayOutputStream baos = null;
		try {
			url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(TIMEOUT_IN_MILLIONS);
			conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			if (conn.getResponseCode() == 200) {
				is = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
				// baos = new ByteArrayOutputStream();
				String len;
				while ((len = is.readLine()) != null) {
					// baos.write(buf, 0, len);
					result += len;
				}
				// baos.flush();
				// return baos.toString();
				return result;
			} else {
				throw new RuntimeException(" responseCode is not 200 ... ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
			}
			// try {
			// if (baos != null)
			// baos.close();
			// } catch (IOException e) {
			// }
			conn.disconnect();
		}

		return null;

	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 *
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 * @throws Exception
	 */
	@Deprecated
	public static String doPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("charset", "utf-8");
			conn.setUseCaches(false);
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setReadTimeout(TIMEOUT_IN_MILLIONS);
			conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);

			if (param != null && !param.trim().equals("")) {
				// 获取URLConnection对象对应的输出流
				out = new PrintWriter(conn.getOutputStream());
				// 发送请求参数
				out.print(param);
				// flush输出流的缓冲
				out.flush();
			}
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 *
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 * @throws Exception
	 */
	public static String doPostJson(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestMethod("POST");
			conn.setRequestProperty("charset", "utf-8");
			conn.setUseCaches(false);
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setReadTimeout(TIMEOUT_IN_MILLIONS);
			conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);

			byte[] outputBytes = param.getBytes("UTF-8");
			OutputStream os = conn.getOutputStream();
			os.write(outputBytes);
			os.close();
			// 定义BufferedReader输入流来读取URL的响应
			int status = conn.getResponseCode();
			if (status >= 400) {
				in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			} else {
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 处理get请求
	 * 
	 * @param url
	 *            请求url
	 * @return
	 */
	public final static String get(String url) {
		final HttpRequest httpRequest = HttpRequest.get(url);
		final HttpResponse response = httpRequest.send();
		// 获取返回数据
		return response.bodyText();
	}

	/**
	 * 处理post请求
	 * 
	 * @param url
	 *            请求url
	 * @param paramStr
	 *            请求参数(入a=1&b=2&key=xxx)
	 * @return
	 */
	public final static String post(final String url, final String paramStr) {
		final HttpRequest httpRequest = HttpRequest.post(url).queryString(paramStr);
		final HttpResponse response = httpRequest.send();
		final String retStr = response.bodyText();
		return retStr;
	}

	/**
	 * 获取短url地址(需要缓存分享地址) 分享url需要缓存，不必每次请求服务
	 * 
	 * @param baseUrl
	 * @param code
	 * @return
	 */
	public final static String shorturl(final String baseUrl, final String code) {
		String shareUrl = "";
		try {
			// 服务接口地址
			final String shorturl = ConfigReader.getProp("shorturl.url");
			// 通过新浪微博短链接服务地址获取短链接
			// 请求返回信息
			String tmpRet = HttpKit.get(shorturl+"?source="+ConfigReader.getProp("shorturl.apikey") +"&url_long="+URLEncoder.encode(baseUrl + "?code=" + code, "ISO-8859-1"));
			JSONArray retArr = JSONArray.parseArray(tmpRet);
			if (CollectionUtils.isNotEmpty(retArr)) {
				shareUrl = retArr.getJSONObject(0).getString("url_short");
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		return shareUrl;
	}
}
