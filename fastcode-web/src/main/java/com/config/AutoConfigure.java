/*
 * Project:        ZXQ
 * Copyright ©     2014-2017 Banma Technologies Co.,Ltd
 *                 All rights reserved.
 * This software is supplied only under the terms of a license agreement,
 * nondisclosure agreement or other written agreement with Banma Technologies
 * Co.,Ltd. Use, redistribution or other disclosure of any parts of this
 * software is prohibited except in accordance with the terms of such written
 * agreement with Banma Technologies Co.,Ltd. This software is confidential
 * and proprietary information of Banma Technologies Co.,Ltd.
 * ***********************************************************************************
 * General Description: Copyright and file header.
 * Revision History:
 *                          Modification
 *  Author                Date(MM/DD/YYYY)   Email           Description of Changes
 *  ---------------------   ------------    ----------     -----------------------------
 *  chong.song                 ${DATE}         chong.song@alibaba-inc.com
 */

package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AutoConfigure {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
