package com.qfedu.house.view;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.qfedu.house.domain.District;
//3.自定义视图,继承AbstractxlsView或者AbstractxlsxView(2007及更高版)
public class DistrictExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, Workbook workbook, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//用URLEncoder.encode("爷给你的表格.xls", "utf-8")来处理中文设置表名和格式
		String fname = URLEncoder.encode("爷给你的表格.xls", "utf-8");
		//请求头设置是内联打开(inline)还是附件下载(attachment),filename有中文的话要处理成百分号编码(percentage encode)
		response.setHeader("Content-Disposition", "attachment; filename=" + fname);
		//旧版和新版的格式不一样
		HSSFWorkbook book = (HSSFWorkbook) workbook;
		HSSFSheet sheet = book.createSheet("区县信息汇总");
		HSSFRow headerRow = sheet.createRow(0);
		String[] colNames = {"省编号", "省名称", "市编号", "市名称", "区县编号", "区县名称"};
		for (int i = 0; i < colNames.length; ++i) {
			HSSFCell headerCell = headerRow.createCell(i);
			headerCell.setCellValue(colNames[i]);
		}
		List<District> distList = (List<District>) model.get("districts");
		int rowIndex = 1;
		String[] propNames = { "city.province.id", "city.province.name", "city.id", "city.name", "id", "name" };
		for (District district : distList) {
			HSSFRow infoRow = sheet.createRow(rowIndex);
			for (int i = 0; i < propNames.length; ++i) {
				HSSFCell infoCell = infoRow.createCell(i);
				infoCell.setCellValue(BeanUtils.getProperty(district, propNames[i]));
			}
			rowIndex += 1;
		}
	}

}
