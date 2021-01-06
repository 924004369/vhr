package com.crt.vhr.utils;

import com.crt.vhr.bean.*;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/4/24 13:28
 */
public class POIUtils {
    public static ResponseEntity<byte[]> employee2Excel(List<Employee> list) {

        //1、创建一个excel文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2、创建文档摘要
        workbook.createInformationProperties();
        //3、获取并配置文档信息
        DocumentSummaryInformation documentSummaryInformation = workbook.getDocumentSummaryInformation();
        documentSummaryInformation.setCategory("员工信息");//文档类别
        documentSummaryInformation.setManager("crt");//文档管理员
        documentSummaryInformation.setCompany("万达信息股份有限公司");//设置公司信息
        //4、获取文档摘要信息
        SummaryInformation information = workbook.getSummaryInformation();
        information.setTitle("员工表信息");//文档标题
        information.setAuthor("crt");//文档作者
        information.setComments("本文档有crt提供");//文档备注
        //5、创建样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillBackgroundColor(IndexedColors.RED.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFCellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        HSSFSheet sheet = workbook.createSheet("员工信息表");
        //设置列的宽度
        sheet.setColumnWidth(0, 5 * 256);
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(2, 10 * 256);
        sheet.setColumnWidth(3, 5 * 256);
        sheet.setColumnWidth(4, 12 * 256);
        sheet.setColumnWidth(5, 20 * 256);
        sheet.setColumnWidth(6, 10 * 256);
        sheet.setColumnWidth(7, 10 * 256);
        sheet.setColumnWidth(8, 20 * 256);
        sheet.setColumnWidth(9, 20 * 256);
        sheet.setColumnWidth(10, 20 * 256);
        sheet.setColumnWidth(11, 20 * 256);
        sheet.setColumnWidth(12, 20 * 256);
        sheet.setColumnWidth(13, 20 * 256);
        sheet.setColumnWidth(14, 20 * 256);
        sheet.setColumnWidth(15, 20 * 256);
        sheet.setColumnWidth(16, 20 * 256);
        sheet.setColumnWidth(17, 20 * 256);
        sheet.setColumnWidth(18, 20 * 256);
        sheet.setColumnWidth(19, 20 * 256);
        sheet.setColumnWidth(20, 20 * 256);
        sheet.setColumnWidth(21, 20 * 256);
        sheet.setColumnWidth(22, 20 * 256);
        sheet.setColumnWidth(23, 20 * 256);
        sheet.setColumnWidth(24, 20 * 256);
        sheet.setColumnWidth(25, 20 * 256);
        //6、创建标题行
        HSSFRow r0 = sheet.createRow(0);
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("编号");
        c0.setCellStyle(headerStyle);
        HSSFCell c1 = r0.createCell(1);
        c1.setCellValue("姓名");
        c1.setCellStyle(headerStyle);
        HSSFCell c2 = r0.createCell(2);
        c2.setCellValue("性别");
        c2.setCellStyle(headerStyle);
        HSSFCell c3 = r0.createCell(3);
        c3.setCellValue("工号");
        c3.setCellStyle(headerStyle);
        HSSFCell c4 = r0.createCell(4);
        c4.setCellValue("出生日期");
        c4.setCellStyle(headerStyle);
        HSSFCell c5 = r0.createCell(5);
        c5.setCellValue("身份证号码");
        c5.setCellStyle(headerStyle);
        HSSFCell c6 = r0.createCell(6);
        c6.setCellValue("婚姻状况");
        c6.setCellStyle(headerStyle);
        HSSFCell c7 = r0.createCell(7);
        c7.setCellValue("民族");
        c7.setCellStyle(headerStyle);
        HSSFCell c8 = r0.createCell(8);
        c8.setCellValue("籍贯");
        c8.setCellStyle(headerStyle);
        HSSFCell c9 = r0.createCell(9);
        c9.setCellValue("联系地址");
        c9.setCellStyle(headerStyle);
        HSSFCell c10 = r0.createCell(10);
        c10.setCellValue("政治面貌");
        c10.setCellStyle(headerStyle);
        HSSFCell c11 = r0.createCell(11);
        c11.setCellValue("电子邮件");
        c11.setCellStyle(headerStyle);
        HSSFCell c12 = r0.createCell(12);
        c12.setCellValue("电话");
        c12.setCellStyle(headerStyle);
        HSSFCell c13 = r0.createCell(13);
        c13.setCellValue("部门");
        c13.setCellStyle(headerStyle);
        HSSFCell c14 = r0.createCell(14);
        c14.setCellValue("职称等级");
        c14.setCellStyle(headerStyle);
        HSSFCell c15 = r0.createCell(15);
        c15.setCellValue("职位");
        c15.setCellStyle(headerStyle);
        HSSFCell c16 = r0.createCell(16);
        c16.setCellValue("聘用形式");
        c16.setCellStyle(headerStyle);
        HSSFCell c17 = r0.createCell(17);
        c17.setCellValue("最高学历");
        c17.setCellStyle(headerStyle);
        HSSFCell c18 = r0.createCell(18);
        c18.setCellValue("专业");
        c18.setCellStyle(headerStyle);
        HSSFCell c19 = r0.createCell(19);
        c19.setCellValue("毕业院校");
        c19.setCellStyle(headerStyle);
        HSSFCell c20 = r0.createCell(20);
        c20.setCellValue("入职日期");
        c20.setCellStyle(headerStyle);
        HSSFCell c21 = r0.createCell(21);
        c21.setCellValue("是否在职");
        c21.setCellStyle(headerStyle);
        HSSFCell c22 = r0.createCell(22);
        c22.setCellValue("合同年限");
        c22.setCellStyle(headerStyle);
        HSSFCell c23 = r0.createCell(23);
        c23.setCellValue("合同起始日期");
        c23.setCellStyle(headerStyle);
        HSSFCell c24 = r0.createCell(24);
        c24.setCellValue("合同结束日期");
        c24.setCellStyle(headerStyle);
        HSSFCell c25 = r0.createCell(25);
        c25.setCellValue("转正日期");
        c25.setCellStyle(headerStyle);


        for (int i = 0; i < list.size(); i++) {
            HSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(i + 1);
            row.createCell(1).setCellValue(list.get(i).getName());
            row.createCell(2).setCellValue(list.get(i).getGender());
            row.createCell(3).setCellValue(list.get(i).getWorkid());
            HSSFCell cell4 = row.createCell(4);
            cell4.setCellStyle(dateStyle);
            cell4.setCellValue(list.get(i).getBirthday());
            row.createCell(5).setCellValue(list.get(i).getIdCard());
            row.createCell(6).setCellValue(list.get(i).getWedlock());
            row.createCell(7).setCellValue(list.get(i).getNation().getName());
            row.createCell(8).setCellValue(list.get(i).getNativeplace());
            row.createCell(9).setCellValue(list.get(i).getAddress());
            row.createCell(10).setCellValue(list.get(i).getPoliticsStatus().getName());
            row.createCell(11).setCellValue(list.get(i).getEmail());
            row.createCell(12).setCellValue(list.get(i).getPhone());
            row.createCell(13).setCellValue(list.get(i).getDepartment().getName());
            row.createCell(14).setCellValue(list.get(i).getJobLevel().getName());
            row.createCell(15).setCellValue(list.get(i).getPosition().getName());
            row.createCell(16).setCellValue(list.get(i).getEngageform());
            row.createCell(17).setCellValue(list.get(i).getTiptopdegree());
            row.createCell(18).setCellValue(list.get(i).getSpecialty());
            row.createCell(19).setCellValue(list.get(i).getSchool());
            HSSFCell cell20 = row.createCell(20);
            cell20.setCellStyle(dateStyle);
            cell20.setCellValue(list.get(i).getBegindate());
            row.createCell(21).setCellValue(list.get(i).getWorkstate());
            row.createCell(22).setCellValue(list.get(i).getContractterm());
            HSSFCell cell23 = row.createCell(23);
            cell23.setCellStyle(dateStyle);
            cell23.setCellValue(list.get(i).getBegincontract());

            HSSFCell cell24 = row.createCell(24);
            cell24.setCellStyle(dateStyle);
            cell24.setCellValue(list.get(i).getEndcontract());

            HSSFCell cell25 = row.createCell(25);
            cell25.setCellStyle(dateStyle);
            cell25.setCellValue(list.get(i).getConversiontime());
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();

        try {
            workbook.write(stream);
            headers.setContentDispositionFormData("attachment", new String("员工表.xls".getBytes("UTF-8"), "ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<byte[]>(stream.toByteArray(), headers, HttpStatus.CREATED);
    }

    /**
     * excel解析成员工数据集合
     *
     * @param file
     * @param allNations
     * @param allJobLevels
     * @param politicsStatus
     * @param allPositions
     * @param allDepartment
     * @return
     */
    public static List<Employee> excel2Employee(MultipartFile file, List<Nation> allNations, List<JobLevel> allJobLevels, List<politicsStatus> politicsStatus, List<Position> allPositions, List<Department> allDepartment) {
        List<Employee> list = new ArrayList<>();
        Employee employee = null;
        try {
            //1、创建一个workbook对象
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            //2、获取workbook的表单对象
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                //3、获取表单
                HSSFSheet sheet = workbook.getSheetAt(i);
                //4、获取表单中的行数
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    if (j == 0) {
                        continue;//跳过标题行
                    }
                    HSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;//防止中间有空行
                    }

                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    employee=new Employee();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        HSSFCell cell = row.getCell(k);
                        switch (cell.getCellType()) {
                            case STRING:
                                String stringCellValue = cell.getStringCellValue();
                                switch (k) {
                                    case 1:
                                        employee.setName(stringCellValue);
                                        break;
                                    case 2:
                                        employee.setGender(stringCellValue);
                                        break;
                                    case 3:
                                        employee.setWorkid(stringCellValue);
                                        break;
                                    case 5:
                                        employee.setIdCard(stringCellValue);
                                        break;
                                    case 6:
                                        employee.setWedlock(stringCellValue);
                                        break;
                                    case 7:
                                        for (Nation nation : allNations
                                        ) {
                                            if (Objects.equals(stringCellValue, nation.getName())) {
                                                employee.setNationid(nation.getId());
                                            }
                                        }
                                        break;
                                    case 8:
                                        employee.setNativeplace(stringCellValue);
                                        break;
                                    case 9:
                                        employee.setAddress(stringCellValue);
                                        break;
                                    case 10:
                                        for (politicsStatus politicsStatus1 : politicsStatus) {
                                            if (Objects.equals(stringCellValue, politicsStatus1.getName())) {
                                                employee.setPoliticid(politicsStatus1.getId());
                                            }
                                        }
                                        break;
                                    case 11:
                                        employee.setEmail(stringCellValue);
                                        break;
                                    case 12:
                                        employee.setPhone(stringCellValue);
                                        break;
                                    case 13:
                                        for (Department dep : allDepartment
                                        ) {
                                            if (Objects.equals(stringCellValue, dep.getName())) {
                                                employee.setDepartmentid(dep.getId());
                                            }
                                        }
                                        break;
                                    case 14:
                                        for (JobLevel jobLevel : allJobLevels
                                        ) {
                                            if (Objects.equals(stringCellValue, jobLevel.getName())) {
                                                employee.setJoblevelid(jobLevel.getId());
                                            }
                                        }
                                        break;
                                    case 15:
                                        for (Position position : allPositions
                                        ) {
                                            if (Objects.equals(stringCellValue, position.getName())) {
                                                employee.setPosid(position.getId());
                                            }
                                        }
                                        break;
                                    case 16:
                                        employee.setEngageform(stringCellValue);
                                        break;
                                    case 17:
                                        employee.setTiptopdegree(stringCellValue);
                                        break;
                                    case 18:
                                        employee.setSpecialty(stringCellValue);
                                        break;
                                    case 19:
                                        employee.setSchool(stringCellValue);
                                        break;
                                    case 21:
                                        employee.setWorkstate(stringCellValue);
                                        break;
                                }
                                break;
                            default: {
                                switch (k) {
                                    case 4:
                                        employee.setBirthday(cell.getDateCellValue());
                                        break;
                                    case 20:
                                        employee.setBegindate(cell.getDateCellValue());
                                        break;
                                    case 22:
                                        employee.setContractterm(cell.getNumericCellValue());
                                        break;
                                    case 23:
                                        employee.setBegincontract(cell.getDateCellValue());
                                        break;
                                    case 24:
                                        employee.setEndcontract(cell.getDateCellValue());
                                        break;
                                    case 25:
                                        employee.setConversiontime(cell.getDateCellValue());
                                        break;
                                }
                            }
                            break;
                        }
                    }
                    list.add(employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
