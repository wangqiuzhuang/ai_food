//import com.baomidou.mybatisplus.generator.FastAutoGenerator;
//import com.baomidou.mybatisplus.generator.config.OutputFile;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//import java.util.Collections;
//
//public class MyCodeGenerator {
//    public static void main(String[] args) {
//        FastAutoGenerator.create("jdbc:mysql://localhost:3306/ai_food", "root", "admin123")
//                .globalConfig(builder -> {
//                    builder.author("qiuzhuang.wang")
//                            .outputDir(System.getProperty("user.dir") + "/cloud-service/src/main/java")
//                            .fileOverride() // 重点：开启覆盖已有文件，确保 7 张表都能重新生成实现
//                            .disableOpenDir();
//                })
//                .packageConfig(builder -> {
//                    builder.parent("com.example")
//                            .entity("entity")
//                            .service("service")
//                            .serviceImpl("service.impl")
//                            .mapper("mapper")
//                            .controller("controller")
//                            .xml("mapper.xml")
//                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/cloud-service/src/main/resources/mapper"));
//                })
//                // --- 核心修改部分：注入自定义模板 ---
//                .templateConfig(builder -> {
//                    builder.controller("/templates/controller.java"); // 只要填 resources/templates 下的相对路径，不用加 .ftl
//                })
//                // --------------------------------
//                .strategyConfig(builder -> {
//                    builder.addInclude("sw_user","sw_cart","sw_food","sw_merchant","sw_order","sw_order_item","sw_user_address")
//                            // Entity 覆盖
//                            .entityBuilder().enableLombok().enableTableFieldAnnotation().enableFileOverride()
//                            // Service 覆盖
//                            .serviceBuilder().formatServiceFileName("%sService").formatServiceImplFileName("%sServiceImpl").enableFileOverride()
//                            // Mapper 覆盖
//                            .mapperBuilder().enableFileOverride()
//                            // Controller 覆盖
//                            .controllerBuilder().enableRestStyle().enableFileOverride();
//                })
//                .templateEngine(new FreemarkerTemplateEngine())
//                .execute();
//    }
//}