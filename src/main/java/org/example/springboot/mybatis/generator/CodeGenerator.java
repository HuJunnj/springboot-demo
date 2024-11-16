package org.example.springboot.mybatis.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.Entity;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeGenerator {

    public static void main(String[] args) {
        // 1. 数据源配置
        DataSourceConfig.Builder dataSourceConfig = new DataSourceConfig.Builder(
                "jdbc:mysql://localhost:3306/jun?useSSL=false&serverTimezone=UTC",
                "root",
                "root");

        // 2. 全局配置
        GlobalConfig.Builder globalConfig = new GlobalConfig.Builder()
                .outputDir(System.getProperty("user.dir") + "/src/main/java") // 代码生成目录
                .author("Jun") // 作者
                .disableOpenDir(); // 生成后不打开文件夹

        // 3. 包配置
        PackageConfig.Builder packageConfig = new PackageConfig.Builder()
                .parent("org.example.springboot") // 父包名
                .moduleName("demos.web"); // 模块名

        // 4. 策略配置
        Entity.Builder strategyConfig = new StrategyConfig.Builder()
                .addInclude("user") // 表名
                .addTablePrefix("t_") // 表前缀
                .entityBuilder()
                .enableFileOverride()
                .naming(NamingStrategy.underline_to_camel) // 下划线转驼峰
                .enableLombok(); // 启用 Lombok

        // 5. 模板引擎配置（Freemarker）
        FreemarkerTemplateEngine templateEngine = new FreemarkerTemplateEngine();

        // 6. 构建 AutoGenerator
        AutoGenerator generator = new AutoGenerator(dataSourceConfig.build());
        generator.global(globalConfig.build());
        generator.packageInfo(packageConfig.build());
        generator.strategy(strategyConfig.build());

        // 7. 执行代码生成
        generator.execute(templateEngine);
    }
}