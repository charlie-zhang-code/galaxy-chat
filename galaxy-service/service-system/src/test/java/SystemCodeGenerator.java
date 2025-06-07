import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.model.ClassAnnotationAttributes;
import io.github.charlie.base.BaseEntity;
import org.apache.ibatis.annotations.Mapper;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author charlie-zhang-code
 * @version v1.0
 * @date 2025/4/13
 * @description 代码生成器
 */
public class SystemCodeGenerator {
    public static void main(String[] args) {
        String outputDir = Paths.get("E:\\MyProjects\\spring-starter\\galaxy-service\\service-system").toFile().getAbsolutePath();
        List<String> tables = new ArrayList<>();
        tables.add("sys_role");
        tables.add("sys_user");

        // 使用元数据查询的方式生成代码,默认已经根据jdbcType来适配java类型,支持使用typeConvertHandler来转换需要映射的类型映射
        DataSourceConfig.Builder datasourceBuilder = new DataSourceConfig.Builder(
                "jdbc:mysql://localhost:3306/galaxy_db?serverTimezone=Asia/Shanghai",
                "root",
                "123456")
                .schema("galaxy_db");

        FastAutoGenerator.create(datasourceBuilder)
                /**
                 * 全局配置
                 */
                .globalConfig(builder -> {
                    builder.author("Charlie Zhang") // 作者
                            .disableOpenDir() // 禁止打开输出目录
                            .enableSpringdoc()
                            .outputDir(outputDir + "/src/main/java"); // 指定输出目录
                })

                /**
                 * 包配置
                 */
                .packageConfig(builder -> builder
                        .parent("io.github.charlie.system") // 设置父包名
                        .entity("model.entity")
                        .service("service")
                        .mapper("mapper")
                        .controller("controller")
                        .xml("mapper")
                        .pathInfo(Collections.singletonMap(OutputFile.xml, outputDir + "/src/main/resources/mapper/system")) // 设置mapperXml生成路径
                )

                /**
                 * 策略配置
                 */
                .strategyConfig(builder -> builder
                                .addInclude(tables) // 设置需要生成的表名
//                                .addTablePrefix("sys_") // 设置过滤表前缀
//                                .addTablePrefix("unit_") // 设置过滤表前缀

                                /**
                                 * Entity
                                 */
                                .entityBuilder()
                                .enableFileOverride()
                                .idType(IdType.ASSIGN_ID)
                                .superClass(BaseEntity.class)
                                .addSuperEntityColumns("create_at", "update_at")
                                .enableLombok(new ClassAnnotationAttributes("@Data", "lombok.Data")) // 开启 lombok 模式
                                .naming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                                .formatFileName("%s")

                                /**
                                 * Service
                                 */
                                .serviceBuilder()
//                                .enableFileOverride()
                                .formatServiceFileName("%sService")
                                .formatServiceImplFileName("%sServiceImpl")

                                /**
                                 * Mapper
                                 */
                                .mapperBuilder()
                                .mapperAnnotation(Mapper.class)
//                                .enableBaseResultMap()
//                                .enableBaseColumnList()
                                .formatMapperFileName("%sMapper")
                                .formatXmlFileName("%sMapper")

                                /**
                                 * Controller
                                 */
                                .controllerBuilder()
//                        .enableFileOverride() // 覆盖已生成文件
                                .enableHyphenStyle() // 开启驼峰转连字
                                .enableRestStyle() // 开启生成@RestController 控制器
                                .formatFileName("%sController")//	格式化文件名称
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
