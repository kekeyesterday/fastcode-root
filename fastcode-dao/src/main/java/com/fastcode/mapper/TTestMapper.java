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

package com.fastcode.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.fastcode.domain.entity.TTest;

import tk.mybatis.mapper.common.Mapper;
@Repository
public interface TTestMapper extends Mapper<TTest> {
	
	@Select("select * from tb_test tt where tt.id=#{id}")
	public TTest getById(@Param("id")Integer id);
	
	@Select("select 1 from dual")
	public Integer getTestById(@Param("id")Integer id);
	
}