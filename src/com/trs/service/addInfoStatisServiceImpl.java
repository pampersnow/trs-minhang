package com.trs.service;

import javax.annotation.Resource;

import trs.springframework.stereotype.Service;

import com.trs.dao.InfoStatisMapper;
import com.trs.pojo.Info;

/**
 * @author JYB
 *创建时间：上午 9:00 
 * 接口实现类：实现，接收控制器处理后的json数据，传入持久层做保存
 */
@Service
public class addInfoStatisServiceImpl implements addInfoStatisService {
    
	@Resource  
	private InfoStatisMapper infoStatisMapper;
		
	@Override
	public boolean addInfo(Info info) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if (flag) {
			
		} else {
			int inf=infoStatisMapper.addInfoStatis(info);
			if(inf > 0){
				flag = true;
				System.out.println("add success!");
			}else{
				System.out.println("add failed!");
			}
		}
		
		return flag;
	}
}
