package org.example.springboot.demos.web.controller;

import org.example.springboot.demos.web.entity.Employee;
import org.example.springboot.demos.web.service.ExcelExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/excel")
public class ExcelExportController {

    @Autowired
    private ExcelExportService excelExportService;

    // 生成示例数据
    private List<Employee> generateSampleData() {
        return Arrays.asList(
                new Employee(1, "张三", "经理"),
                new Employee(2, "李四", "开发工程师"),
                new Employee(3, "王五", "产品经理"),
                new Employee(4, "赵六", "设计师")
        );
    }

    // 导出 Excel
    @GetMapping("/export")
    public String exportExcel(HttpServletResponse response) {
        List<Employee> employeeList = generateSampleData();
        try{
            excelExportService.exportEmployeeData(response, employeeList);
            return "导出成功";
        }catch (Exception e) {
            return "导出失败";
        }

    }
}
