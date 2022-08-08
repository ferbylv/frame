package com.yichuang.common.util;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collections;

public class MybatisPlusGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://mysql.ferbylv.top:3366/test","root","toor")
                .globalConfig(builder -> {
                    builder.author("yichuang")
                            .outputDir("/Users/mac/IdeaProjects/yichuang/common/src/main/java")
                            .commentDate("yyyy-MM-dd HH:mm:ss")
                            .dateType(DateType.ONLY_DATE)
                            .enableSpringdoc()
                            .enableSwagger()
                            .fileOverride()
                            .disableOpenDir();

                }).strategyConfig(builder -> {
                    builder.addInclude(Collections.emptyList())
                            .disableSqlFilter()
                            .entityBuilder()
                            .enableLombok()
                            .naming(NamingStrategy.underline_to_camel)
                            .columnNaming(NamingStrategy.underline_to_camel)
                            .enableTableFieldAnnotation()
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                            .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
                            .mapperBuilder()
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sMapper")
                            .formatXmlFileName("%sXml")
                            .enableBaseColumnList()
                            .enableBaseResultMap()
                            .mapperAnnotation(Mapper.class)
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .controllerBuilder()
                            .enableRestStyle()
                            .formatFileName("%sController")
                            .build();

                }).packageConfig(builder -> {
                    builder.parent("com.yichuang.common")
                            .entity("entity")
                            .mapper("mapper")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "/Users/mac/IdeaProjects/yichuang/common/src/main" +
                                    "/resources/mapper"))    //配置 **Mapper.xml 路径信息：项目的 resources 目录的 Mapper 目录下
                            .build();

                }).execute();

    }
}
