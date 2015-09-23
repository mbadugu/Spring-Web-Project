package com.mtc.web.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.mtc.app.entity.Product;

@Component("productPdfView")
public class ProductPDFView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	List<Product> products =(List<Product>)map.get("products");
	Table table = new Table(4); //takes the no.of columns as input
	table.addCell("ProductID");//1st row has 4 cells
	table.addCell("ProductName");
	table.addCell("ProductPrice");
	table.addCell("ProductDescription");
	
	for(Product product:products){
		table.addCell(product.getId()+"");//this method only returns string values therefore it is concatenated with an empty string
		table.addCell(product.getName());
		table.addCell(product.getPrice()+"");
		table.addCell(product.getDescription());
	}
		document.add(table);
	}
//	@Override
//	protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//	Product product =(Product)map.get("product");
//	Table table = new Table(4); //takes the no.of columns as input
//	table.addCell("ProductID");//1st row has 4 cells
//	table.addCell("ProductName");
//	table.addCell("ProductPrice");
//	table.addCell("ProductDescription");
//	
//	
//		table.addCell(product.getId()+"");//this method only returns string values therefore it is concatenated with an empty string
//		table.addCell(product.getName());
//		table.addCell(product.getPrice()+"");
//		table.addCell(product.getDescription());
//	
//		document.add(table);
//	}

}
