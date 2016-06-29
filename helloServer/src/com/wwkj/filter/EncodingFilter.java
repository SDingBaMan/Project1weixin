package com.wwkj.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * 编码过滤器，解决全站中文乱码问题，高级版�?通过包装设计模式，重新包装HttpServletRequest，使其能够接受url中文参数
 * 
 * @author : zhaoyubetter
 */
public class EncodingFilter implements Filter {

	private String encoding = "UTF-8";

	public void init(FilterConfig filterConfig) throws ServletException {
		String temp = filterConfig.getInitParameter("encoding");
		if (temp != null) {
			encoding = temp;
		}
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("========我是监听器=======");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		// POST请求中文问题
		request.setCharacterEncoding(encoding);
		// 响应输出编码和浏览器使用的编�?
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + encoding);

		if ("GET".equalsIgnoreCase(request.getMethod())) {
			// get 方式请求资源
			// 创建 MyHttpServletRequest 对象，并赋�?�?request对象�?
			// 这样做是为了减少内部类MyHttpServletRequest的判�?
			request = new MyHttpServletRequest(request);
		}
		// 放行
		chain.doFilter(request, response);
	}

	public void destroy() {

	}

	/**
	 * 内部类： 包装HttpServletRequest对象，覆盖接收参数的方法，用于解决url中文参数的问�?
	 * @author zhaoyu
	 */
	private class MyHttpServletRequest extends HttpServletRequestWrapper {

		public MyHttpServletRequest(HttpServletRequest request) {
			super(request);
		}

		@Override
		public String getParameter(String name) {
			String value = super.getParameter(name);
			if (value != null) {
				value = encodingValue(value);
			}
			return value;
		}

		@Override
		public Map<String, String[]> getParameterMap() {
			Map<String, String[]> map = super.getParameterMap();
			if (map != null) {
				for (Entry<String, String[]> me : map.entrySet()) {
					String[] values = me.getValue();
					for(int i=0; i<values.length; i++) {
						values[i] = encodingValue(values[i]);		// 编码后，替换
					}
				}
			}
			return map;
		}

		@Override
		public String[] getParameterValues(String name) {
			String[] values = super.getParameterValues(name);
			if(values != null) {
				for(int i=0; i<values.length; i++) {
					values[i] = encodingValue(values[i]);		// 编码后，替换
				}
			}
			return values;
		}
		
		/**
		 * 返回编码后的字符�?
		 * 
		 * @param value
		 * @return
		 */
		private String encodingValue(String value) {
			try {
				return new String(value.getBytes("ISO-8859-1"),
						super.getCharacterEncoding());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

}
