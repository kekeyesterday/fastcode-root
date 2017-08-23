/***************************************************************************************
 *
 *  Project:        ZXQ
 *
 *  Copyright ©     2014-2017 Banma Technologies Co.,Ltd
 *                  All rights reserved.
 *
 *  This software is supplied only under the terms of a license agreement,
 *  nondisclosure agreement or other written agreement with Banma Technologies
 *  Co.,Ltd. Use, redistribution or other disclosure of any parts of this
 *  software is prohibited except in accordance with the terms of such written
 *  agreement with Banma Technologies Co.,Ltd. This software is confidential
 *  and proprietary information of Banma Technologies Co.,Ltd.
 *
 ***************************************************************************************
 *
 *  Header Name: Banma.h
 *
 *  General Description: Copyright and file header.
 *
 *  Revision History:
 *                           Modification
 *   Author                Date(MM/DD/YYYY)   JiraID           Description of Changes
 *   ---------------------   ------------    ----------     -----------------------------
 *   lvchuntian            2017年3月17日
 *
 ****************************************************************************************/

package com.config;  

import java.util.Properties;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;


@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.fastcode.mapper");
        Properties properties = new Properties();
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }
}
  
