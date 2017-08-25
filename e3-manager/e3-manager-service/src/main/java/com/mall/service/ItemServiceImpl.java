package com.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.mapper.TbItemMapper;
import com.mall.pojo.TbItem;
import com.mall.pojo.TbItemExample;
import com.mall.pojo.TbItemExample.Criteria;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;

	public TbItem getItemById(long itemId) {
		/*
		 * TbItem item = itemMapper.selectByPrimaryKey(id); return item;
		 */
		TbItemExample itemExample = new TbItemExample();
		Criteria createCriteria = itemExample.createCriteria();
		createCriteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(itemExample);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
