package org.example.springboot.demos.web.service;

import com.alibaba.excel.EasyExcel;
import org.example.springboot.demos.web.entity.Employee;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelExportService {

    // 导出数据到 Excel 文件
    public void exportEmployeeData(HttpServletResponse response, List<Employee> employeeList) throws IOException {
        // 设置响应头，指定文件下载和文件名
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=employee_data.xlsx");

        // 使用 EasyExcel 导出 Excel 文件
        EasyExcel.write(response.getOutputStream(), Employee.class)
                .sheet("员工数据")
                .doWrite(employeeList);  // 写入数据
    }
}

