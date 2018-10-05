package com.kevin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.dao.PrizeDao;
import com.kevin.entity.Prize;
import com.kevin.entity.Prize.Type;

@Service
@Transactional(readOnly = false)
public class PrizeService {
	
	@Autowired
	private PrizeDao prizeDao;

	public List<Prize> findAll(){
		return prizeDao.findAll();
	}
	
	public List<Prize> findByShopId(Long shopId){
		return prizeDao.findByShopIdAndRemoved(shopId, false);
	}
	
	public List<Prize> getPrizesByShopId(Long shopId){
		List<Prize> list = this.findByShopId(shopId);
		if(list != null && !list.isEmpty()) {
			if(list.size() < 6) {
				for(int i = 0 ; i < (6 - list.size()) ; i ++) {
					list.add(this.getDefaultPrize());
				}
			}
		}else {
			list = this.getDefaultPrizes();
		}
		return list;
	}
	
	public Prize getDefaultPrize() {
		Prize p = new Prize();
		
		p.setType(Type.Other);
		
		return p;
	}
	
	public List<Prize> getDefaultPrizes(){
		List<Prize> list = new ArrayList<>();
		for(int i = 0 ; i < 6 ; i ++) {
			list.add(this.getDefaultPrize());
		}
		return list;
	}

	public Prize getOneForPunchIn(int num) {
		Prize p = this.getDefaultPrize();//TODO
		return p;
	}

}
