package com.qfedu.house.view;

import java.awt.Color;
import java.io.InputStream;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.qfedu.house.domain.District;

public class DistrictPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		document.setPageSize(PageSize.A4);
		document.setMargins(20, 20, 40, 40);
		String fname = URLEncoder.encode("区县信息表.pdf", "utf-8");
		response.setHeader("Content-Disposition", "inline; filename=" + fname);
		BaseFont bf = BaseFont.createFont("c:/Windows/Fonts/STXINWEI.TTF", BaseFont.IDENTITY_H, true);
		Font font = new Font(bf , 32, Font.BOLD, Color.RED);
		Paragraph p = new Paragraph("区县信息汇总表", font);
		document.add(p);
		List<District> distList = (List<District>) model.get("districts");
		Font font2 = new Font(bf, 16, Font.NORMAL, Color.BLUE);
		Table t = new Table(6);
		String[] propNames = { "city.province.id", "city.province.name", "city.id", "city.name", "id", "name" };
		for (District district : distList) {
			for (int i = 0; i < propNames.length; ++i) {
				String content = BeanUtils.getProperty(district, propNames[i]);
				Cell cell = new Cell(new Paragraph(content, font2));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				t.addCell(cell);
			}
		}
		document.add(t);
		document.newPage();
		String path = request.getServletContext().getRealPath("/images") + "/" + "mm.jpg";
		try (InputStream in = new FileInputStream(path)) {
			byte[] buffer = new byte[in.available()];
			in.read(buffer);
			// URL url = new URL("https://www.baidu.com/img/bd_logo1.png");
			Image image = Image.getInstance(buffer);
			image.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
			document.add(image);
		}
	}

}
