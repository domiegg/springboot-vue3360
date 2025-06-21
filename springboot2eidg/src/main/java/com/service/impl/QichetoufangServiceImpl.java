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


import com.dao.QichetoufangDao;
import com.entity.QichetoufangEntity;
import com.service.QichetoufangService;
import com.entity.vo.QichetoufangVO;
import com.entity.view.QichetoufangView;

@Service("qichetoufangService")
public class QichetoufangServiceImpl extends ServiceImpl<QichetoufangDao, QichetoufangEntity> implements QichetoufangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QichetoufangEntity> page = this.selectPage(
                new Query<QichetoufangEntity>(params).getPage(),
                new EntityWrapper<QichetoufangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QichetoufangEntity> wrapper) {
		  Page<QichetoufangView> page =new Query<QichetoufangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QichetoufangVO> selectListVO(Wrapper<QichetoufangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QichetoufangVO selectVO(Wrapper<QichetoufangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QichetoufangView> selectListView(Wrapper<QichetoufangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QichetoufangView selectView(Wrapper<QichetoufangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
