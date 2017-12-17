package com.inetsoft.log4j;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class InitLog4jServlet extends HttpServlet {

	private static final long serialVersionUID = 9203392013908166899L;

	@Override
	public void init() throws ServletException {
		String path = this.getInitParameter("log4j-location");
		System.out.println("========== path =========" + path);
		if(path == null) {
			System.out.println("=== path is null ===使用默认的配置======");
			BasicConfigurator.configure();
		} else {
			path = this.getServletContext().getRealPath(path);
			System.out.println();
			File config = new File(path);
			if(config.exists()) {
				System.out.println("==========使用配置文件配置=========" + path);
				PropertyConfigurator.configure(path);
			} else {
				System.out.println("====config is not exists==使用默认的配置======");
				BasicConfigurator.configure();
			}
		}

		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
