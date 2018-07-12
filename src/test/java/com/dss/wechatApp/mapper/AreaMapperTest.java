package com.dss.wechatApp.mapper;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dss.wechatApp.entity.Area;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaMapperTest {

	@Autowired
	private AreaMapper areaMapper;
	
	@Test
	public void testListAllArea() {
		
		List<Area> areaList = areaMapper.listAllArea();
		
		System.out.println(areaList);
		
		assertEquals(2, areaList.size());
		
	}
	
	@Test
	public void testGetAreaById() {
		
		Area area = new Area();
		area.setAreaId(1);
		
		area = areaMapper.getAreaById(area);
		
		System.out.println(area);
		
		assertEquals("东街", area.getAreaName());
		
	}
	
	@Test
	public void testSaveArea() {
		
		Area area = new Area();
		area.setAreaName("北街");
		area.setPriority(5);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		area.setCreateTime(sdf.format(new Date()));
		
		areaMapper.saveArea(area);
		
		System.out.println(area);
		
		assertEquals("10", area.getAreaId().toString());
		
	}
	
	@Test
	public void testUpdateArea() {
		
		Area area = new Area();
		area.setAreaId(10);
		area.setAreaName("中街");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		area.setLastEditTime(sdf.format(new Date()));
		
		areaMapper.updateArea(area);
		
		System.out.println(area);
		
		assertEquals("北街街", area.getAreaName());
		
	}
	
	@Test
	public void testDeleteArea() {
		
		Area area = new Area();
		area.setAreaId(10);
		
		areaMapper.deleteArea(area);
	}
	
}
