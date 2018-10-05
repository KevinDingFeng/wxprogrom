package com.kevin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.dao.CardDao;
import com.kevin.dao.UserCardRelDao;
import com.kevin.entity.Card;
import com.kevin.entity.UserCardRel;

@Service
@Transactional(readOnly = false)
public class CardService {
	
	@Autowired
	private CardDao cardDao;
	@Autowired
	private UserCardRelDao userCardRelDao;
	
	public List<Card> findAll(){
		return cardDao.findAll();
	}

	public Card findByUserIdAndShopId(Long userId, Long shopId) {
		List<UserCardRel> rels = userCardRelDao.findByUserId(userId);
		if(rels != null && rels.size() > 0) {
			List<Long> ids = new ArrayList<>();
			for(UserCardRel rel : rels) {
				ids.add(rel.getUserId());
			}
			Card card = cardDao.findByShopIdAndIdIn(shopId, ids);
			return card;
		}
		
		return null;
	}
	
	

}
