import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.Collections;

public class MyCodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/ai_food", "root", "admin123")
                .globalConfig(builder -> {
                    builder.author("qiuzhuang.wang")
                            .outputDir(System.getProperty("user.dir") + "/cloud-service/src/main/java")
                            .disableOpenDir(); // 生成后不自动打开文件夹
                })
                .packageConfig(builder -> {
                    builder.parent("com.example") // 父包名
                            .entity("entity")          // 实体类包名
                            .service("service")        // Service 接口包名
                            .serviceImpl("service.impl") // Service 实现类包名
                            .mapper("mapper")          // Mapper 接口包名
                            .controller("controller")  // Controller 包名
                            .xml("mapper.xml")         // XML 存放位置
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/cloud-service/src/main/resources/mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("sw_user","sw_cart","sw_food","sw_merchant","sw_order","sw_order_item","w_user_address") // 填入你的表名
                            // Entity 配置
                            .entityBuilder().enableLombok().enableTableFieldAnnotation()
                            // Service 配置
                            .serviceBuilder().formatServiceFileName("%sService") // 去掉默认的 I 前缀
                            .formatServiceImplFileName("%sServiceImpl")
                            // Controller 配置
                            .controllerBuilder().enableRestStyle(); // 生成 @RestController
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}