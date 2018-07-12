package com.dss.wechatApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dss.wechatApp.entity.Area;
import com.dss.wechatApp.service.AreaService;

@RestController
@RequestMapping(value = "/area")
public class AreaController {

	@Autowired
	private AreaService areaService;
	
	/**
	 * 查询所有的区域信息
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/listAllArea")
	public List<Area> listAllArea() throws Exception{
		
		List<Area> list = areaService.listAllArea();
		
		return list;      
	}
	
	/**
	 * 通过areaId查询一个区域信息
	 * @param areaId
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/getAreaById")
	public Area getAreaById(@RequestParam(value = "areaId") Integer areaId) throws Exception{
		
		Area area = new Area();
		area.setAreaId(areaId);
		
		area = areaService.getAreaById(area);
		
		return area;
	}
	
	/**
	 * 添加一个区域信息
	 * @param area
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/saveArea")
	public String saveArea(@RequestBody Area area) throws Exception{
		
		areaService.saveArea(area);
		return "success";
	}
	
	/**
	 * 修改一个区域信息
	 * @param area
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/updateArea")
	public String updateArea(@RequestBody Area area) throws Exception{
		
		areaService.updateArea(area);
		return "success";
	}
	
	/**
	 * 删除一个区域信息
	 * @param areaId
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/deleteArea")
	public String deleteArea(@RequestParam(value = "areaId") Integer areaId) throws Exception{
		
		Area area = new Area();
		area.setAreaId(areaId);
		
		areaService.deleteArea(area);
		
		return "success";
	}
}
