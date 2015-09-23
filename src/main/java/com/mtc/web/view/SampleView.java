package com.mtc.web.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import com.mtc.app.entity.Product;
@Component("sampleView")
public class SampleView implements View {

	@Override
	public String getContentType() {
		
		return "text/html";
	}

	@Override
	public void render(Map<String, ?> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		out.println("This is a CustomView component");
		Product product=(Product)map.get("product");
		out.println("Id:"+product.getId());
		out.println("</br>");
		out.println("Name:"+product.getName());
		out.println("</br>");
		out.println("Price:"+product.getPrice());
		out.println("</br>");
		out.println("Description:"+product.getDescription());
	}


	}


