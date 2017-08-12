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

// 3. Create custom view from AbstractXlsView or AbstractXlsxView
public class DistrictExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, Workbook workbook, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fname = URLEncoder.encode("爷给你的表格.xls", "utf-8");
		// case 1: inline / attachment
		// case 2: filename --- percentage encoding --- URLEncoder.encode
		response.setHeader("Content-Disposition", "attachment; filename=" + fname);
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
				// get property using reflection / introspectation
				infoCell.setCellValue(BeanUtils.getProperty(district, propNames[i]));
			}
			rowIndex += 1;
		}
	}

}
