package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ToufangdiquDao;
import com.entity.ToufangdiquEntity;
import com.service.ToufangdiquService;
import com.entity.vo.ToufangdiquVO;
import com.entity.view.ToufangdiquView;

@Service("toufangdiquService")
public class ToufangdiquServiceImpl extends ServiceImpl<ToufangdiquDao, ToufangdiquEntity> implements ToufangdiquService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ToufangdiquEntity> page = this.selectPage(
                new Query<ToufangdiquEntity>(params).getPage(),
                new EntityWrapper<ToufangdiquEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ToufangdiquEntity> wrapper) {
		  Page<ToufangdiquView> page =new Query<ToufangdiquView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ToufangdiquVO> selectListVO(Wrapper<ToufangdiquEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ToufangdiquVO selectVO(Wrapper<ToufangdiquEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ToufangdiquView> selectListView(Wrapper<ToufangdiquEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ToufangdiquView selectView(Wrapper<ToufangdiquEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
