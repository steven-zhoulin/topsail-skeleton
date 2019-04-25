package automatically;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * mysql 代码生成器演示例子
 * </p>
 *
 * @author Steven
 * @since 2019-04-24
 */
@Slf4j
public class MySQLGenerator {

    /**
     * 以下是代码生成前需要修改的部分:
     */
    private static String author = "Steven";

    private static String url = "jdbc:mysql://39.106.228.124:3306/hitech?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String schemaName = "hitech";
    private static String username = "hitech";
    private static String password = "20190422";

    private static String parentPackege = "com.hitech.skeleton";

    /**
     * 以下不用修改
     */

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        String help = tip + ": ";
        System.out.print(help);
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {

        String moduleName = scanner("请输入本次构建的模块名");
        String[] tables = scanner("请输入本次构建的表名(多个表明用英文逗号隔开)").split(",");

        log.info("本次构建的模块路径为: {}.{}", parentPackege, moduleName);
        log.info("本次构建的表: ");
        for (String table : tables) {
            log.info(" -> " + table);
        }

        String answer = scanner("是否继续? (Y/N)");
        if (!"Y".equalsIgnoreCase(answer)) {
            System.exit(0);
        }

        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir").replace('\\', '/');
        String outPutDir = projectPath + "/src/main/java";
        log.info("样板代码输出路径: " + outPutDir);

        globalConfig.setOutputDir(outPutDir);
        globalConfig.setAuthor(author);
        globalConfig.setOpen(false);
        autoGenerator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(url);
        dataSourceConfig.setSchemaName(schemaName);
        dataSourceConfig.setDriverName(driver);
        dataSourceConfig.setUsername(username);
        dataSourceConfig.setPassword(password);
        autoGenerator.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(moduleName);
        packageConfig.setParent(parentPackege);
        packageConfig.setEntity("entity.po");
        autoGenerator.setPackageInfo(packageConfig);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("/templates/controller.java.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                String path = projectPath + "/src/main/java/" + parentPackege.replace('.', '/') + "/" + packageConfig.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Controller" + StringPool.DOT_JAVA;
//                System.out.println("controller路径为: " + path);
//                return path;
//            }
//        });


        cfg.setFileOutConfigList(focList);
        autoGenerator.setCfg(cfg);
        autoGenerator.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setInclude(tables);
        strategy.setRestControllerStyle(true);
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(packageConfig.getModuleName() + "_");

        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController("/automatically/controller.java");
        templateConfig.setService("/automatically/service.java");
        templateConfig.setServiceImpl("/automatically/serviceImpl.java");
        templateConfig.setEntity("/automatically/entity.java");
        templateConfig.setMapper("/automatically/mapper.java");
        templateConfig.setXml("/automatically/mapper.xml");
        autoGenerator.setTemplate(templateConfig);

        autoGenerator.setStrategy(strategy);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }

}
