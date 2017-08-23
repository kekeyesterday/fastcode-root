package com;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


public class MybatisGeneator {

    public static void main(String[] args) throws Exception {
        String path = "D:/MySpace/fastcode-root/fastcode-dao/src/main";
        String entityPkg = "com.fastcode.domain.entity";
        String mapperPkg = "com.fastcode.mapper";
        String userId = "root";
        String password = "Pass1234";
        String dbUrl = "jdbc:mysql://10.25.23.14:3306/db_parking?useUnicode=true&amp;characterEncoding=UTF-8";

        Map<String, String> tables = new Hashtable<>();

        tables.put("t_test2", "tb_test2");
//        tables.put("TMsgAppKey", "t_msg_app_key");
//        tables.put("TMsgHis", "t_msg_his");
//        tables.put("TMsgResc", "t_msg_resc");
//        tables.put("TMsgTemplate", "t_msg_template");
//        tables.put("TMsgTopicRappkey", "t_msg_topic_r_appkey");
//        tables.put("TMmgTopic", "t_smg_topic");

        List<String> warnings = new ArrayList<>();
        Configuration config = new Configuration();
        Context ctx = new Context(ModelType.FLAT);
        ctx.setId("mySql");
        ctx.setTargetRuntime("MyBatis3Simple");
        ctx.addProperty("beginningDelimiter", "`");
        ctx.addProperty("endingDelimiter", "`");

        PluginConfiguration pc = new PluginConfiguration();
        pc.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");
        pc.addProperty("mappers", "tk.mybatis.mapper.common.Mapper");
        ctx.addPluginConfiguration(pc);

        JDBCConnectionConfiguration jcc = new JDBCConnectionConfiguration();
        jcc.setUserId(userId);
        jcc.setPassword(password);
        jcc.setConnectionURL(dbUrl);
        jcc.setDriverClass("com.mysql.jdbc.Driver");
        ctx.setJdbcConnectionConfiguration(jcc);

        JavaModelGeneratorConfiguration jmgc = new JavaModelGeneratorConfiguration();
        jmgc.setTargetPackage(entityPkg);
        jmgc.setTargetProject(path + "/java");
        ctx.setJavaModelGeneratorConfiguration(jmgc);

        SqlMapGeneratorConfiguration smgc = new SqlMapGeneratorConfiguration();
        smgc.setTargetPackage("mapper");
        smgc.setTargetProject(path + "/resource");
        ctx.setSqlMapGeneratorConfiguration(smgc);

        JavaClientGeneratorConfiguration jcgc = new JavaClientGeneratorConfiguration();
        jcgc.setTargetPackage(mapperPkg);
        jcgc.setTargetProject(path + "/java");
        jcgc.setConfigurationType("XMLMAPPER");
        ctx.setJavaClientGeneratorConfiguration(jcgc);

        for (String k : tables.keySet()) {
            TableConfiguration tc = new TableConfiguration(ctx);
            tc.setSchema(k);
            tc.setTableName(tables.get(k));
            ctx.addTableConfiguration(tc);
        }

        config.addContext(ctx);

        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
