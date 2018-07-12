package com.dss.wechatApp.mapper;

import java.util.List;

import com.dss.wechatApp.entity.Area;

public interface AreaMapper {

	/**
	 * 查询所有的区域信息
	 * @return
	 */
	List<Area>	listAllArea();
	
	/**
	 * 通过area_id查询区域信息
	 * @param area
	 * @return
	 */
	Area getAreaById(Area area);
	
	/**
	 * 添加一个区域信息
	 * @param area
	 * @return
	 */
	void saveArea(Area area);
	
	/**
	 * 删除一个区域信息
	 * @param area
	 */
	void deleteArea(Area area);
	
	/**
	 * 修改一个区域信息
	 * @param area
	 */
	void updateArea(Area area);
	
}
