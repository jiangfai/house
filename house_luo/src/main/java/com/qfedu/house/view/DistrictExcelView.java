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
//3.�Զ�����ͼ,�̳�AbstractxlsView����AbstractxlsxView(2007�����߰�)
public class DistrictExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, Workbook workbook, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��URLEncoder.encode("ү����ı��.xls", "utf-8")�������������ñ����͸�ʽ
		String fname = URLEncoder.encode("ү����ı��.xls", "utf-8");
		//����ͷ������������(inline)���Ǹ�������(attachment),filename�����ĵĻ�Ҫ����ɰٷֺű���(percentage encode)
		response.setHeader("Content-Disposition", "attachment; filename=" + fname);
		//�ɰ���°�ĸ�ʽ��һ��
		HSSFWorkbook book = (HSSFWorkbook) workbook;
		HSSFSheet sheet = book.createSheet("������Ϣ����");
		HSSFRow headerRow = sheet.createRow(0);
		String[] colNames = {"ʡ���", "ʡ����", "�б��", "������", "���ر��", "��������"};
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
