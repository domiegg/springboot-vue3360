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


import com.dao.ShiyongdingdanDao;
import com.entity.ShiyongdingdanEntity;
import com.service.ShiyongdingdanService;
import com.entity.vo.ShiyongdingdanVO;
import com.entity.view.ShiyongdingdanView;

@Service("shiyongdingdanService")
public class ShiyongdingdanServiceImpl extends ServiceImpl<ShiyongdingdanDao, ShiyongdingdanEntity> implements ShiyongdingdanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShiyongdingdanEntity> page = this.selectPage(
                new Query<ShiyongdingdanEntity>(params).getPage(),
                new EntityWrapper<ShiyongdingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShiyongdingdanEntity> wrapper) {
		  Page<ShiyongdingdanView> page =new Query<ShiyongdingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShiyongdingdanVO> selectListVO(Wrapper<ShiyongdingdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShiyongdingdanVO selectVO(Wrapper<ShiyongdingdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShiyongdingdanView> selectListView(Wrapper<ShiyongdingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShiyongdingdanView selectView(Wrapper<ShiyongdingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
