package com.kevin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.dao.CouponDao;
import com.kevin.dao.UserCouponRelDao;
import com.kevin.entity.Coupon;
import com.kevin.entity.UserCouponRel;

@Service
@Transactional(readOnly = false)
public class CouponService {
	
	@Autowired
	private CouponDao couponDao;
	@Autowired
	private UserCouponRelDao relDao;

	public List<Coupon> findAll(){
		return couponDao.findAll();
	}

	public Page<Coupon> findAll(Pageable pageable) {
		return couponDao.findAll(pageable);
	}
	
	public Page<Coupon> findByShopId(Long shopId, Pageable pageable){
		return couponDao.findByShopId(shopId, pageable);
	}

	public Page<Coupon> findByUserIdAndShopId(Long userId, Long shopId, Pageable pageable) {
		Page<UserCouponRel> rels = relDao.findByUserId(userId, pageable);
		if(rels != null) {
			List<UserCouponRel> list = rels.getContent();
			if(list != null && list.size() > 0) {
				List<Long> ids = new ArrayList<>();
				for(UserCouponRel rel : list) {
					ids.add(rel.getCouponId());
				}
				return couponDao.findByIdIn(ids, pageable);
			}
		}
		return null;
	}

	public UserCouponRel getDefaultRel(Long userId, Long id) {
		return new UserCouponRel(userId, id);
	}

	public void saveRel(UserCouponRel rel) {
		relDao.save(rel);
	}
}
