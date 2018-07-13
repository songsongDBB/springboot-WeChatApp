package com.dss.wechatApp.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dss.wechatApp.entity.Area;
import com.dss.wechatApp.mapper.AreaMapper;
import com.dss.wechatApp.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaMapper areaMapper;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Area> listAllArea() {
		return areaMapper.listAllArea();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Area getAreaById(Area area) {
		return areaMapper.getAreaById(area);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveArea(Area area) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		area.setCreateTime(sdf.format(new Date()));
		
		areaMapper.saveArea(area);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteArea(Area area) {
		areaMapper.deleteArea(area);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateArea(Area area) {
		areaMapper.updateArea(area);
	}

}
