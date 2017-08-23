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
 *   lvchuntian            2017年3月1日
 *
 ****************************************************************************************/

package com.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
    
    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver(){
     CommonsMultipartResolver resolver = new CommonsMultipartResolver();
     resolver.setDefaultEncoding("UTF-8");
     resolver.setResolveLazily(true);
     resolver.setMaxInMemorySize(40960);
     resolver.setMaxUploadSize(10*1024*1024);//上传文件大小 10M 10*1024*1024
     return resolver;
 } 
}
  
