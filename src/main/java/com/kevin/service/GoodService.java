package com.kevin.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.dao.GoodDao;
import com.kevin.entity.Good;
import com.kevin.entity.Good.Type;

@Service
@Transactional(readOnly = false)
public class GoodService {
	
	@Autowired
	private GoodDao goodDao;

	public List<Good> findAll(){
		return goodDao.findAll();
	}

	public Page<Good> findAll(Pageable pageable) {
		return goodDao.findAll(pageable);
	}
	
	public Page<Good> findAll(Specification<Good> generateSpecification, Pageable pageable) {
		return goodDao.findAll(generateSpecification, pageable);
	}

	public Good findById(Long id) {
		return goodDao.findOne(id);
	}
	
	public Specification<Good> generateSpecification(Type type) {
		return new Specification<Good>() {
	        public Predicate toPredicate(Root<Good> root,  
		                CriteriaQuery<?> query, CriteriaBuilder cb) {  
	        	
//	        	root.join("order", JoinType.INNER);//inner join
//	        	root.join("restingOrder", JoinType.INNER);
	            List<Predicate> list = new ArrayList<Predicate>();
	            if(type != null) {
	            	list.add(cb.equal(root.get("type"), type));
	            }
//	            list.add(cb.isFalse(root.get("order").<Boolean>get("removed")));
	            Predicate[] p = new Predicate[list.size()];  
	            return cb.and(list.toArray(p));
//	            if(StringUtils.isNotEmpty(orderedSelStatus) && !"allStatus".equals(orderedSelStatus)){//查询条件不是全部状态时，增加where条件查询对应状态的订单
//	            	if(Status.COMPLETE.getText().equals(orderedSelStatus) || Status.ABNORMAL_SHUTDOWN.getText().equals(orderedSelStatus)){//查询 已完成或异常关闭 状态的现货订单
//	            		Timestamp t = new Timestamp(System.currentTimeMillis());
//	            		Predicate pre = cb.lessThan(root.get("order").get("completeTime"), t);
//	            		Predicate pre1 = cb.equal(root.get("order").get("completeOrderProgress"), CompleteOrderProgress.BUYER_BEGIN);
//	            		Predicate pre2 = cb.equal(root.get("order").get("completeOrderProgress"), CompleteOrderProgress.SELLER_BEGIN);
//	            		if(Status.ABNORMAL_SHUTDOWN.getText().equals(orderedSelStatus)){
//	            			pre1 = cb.equal(root.get("order").get("completeOrderProgress"), CompleteOrderProgress.BUYER_ERR_BEGIN);
//		            		pre2 = cb.equal(root.get("order").get("completeOrderProgress"), CompleteOrderProgress.SELLER_ERR_BEGIN);
//	            		}
//	            		Predicate pre3 = cb.notEqual(root.get("order").get("orderStatus").get("status"), Status.COMPLETE);
//	            		Predicate pre4 = cb.notEqual(root.get("order").get("orderStatus").get("status"), Status.ABNORMAL_SHUTDOWN);
//	            		Predicate pre5 = cb.notEqual(root.get("order").get("orderStatus").get("status"), Status.CANCEL);
//	            		
//	            		Predicate pre6 =cb.equal(root.get("order").get("orderStatus").get("reason").as(String.class), orderedSelStatus);
//	            		list.add(cb.or(cb.and(pre, cb.or(pre1, pre2), pre3, pre4,pre5), pre6));
//	            	}else if(Status.CANCEL.getText().equals(orderedSelStatus) || Status.OUT_OF_STOCK.getDesc().equals(orderedSelStatus)){
//	            		list.add(cb.equal(root.get("order").get("orderStatus").get("reason").as(String.class), orderedSelStatus));
//	            	}else{
//	            		//剩下的状态，在查询时，查询未自动完成交易的订单
//	            		Timestamp t = new Timestamp(System.currentTimeMillis());
//	            		Predicate pre = cb.greaterThanOrEqualTo(root.get("order").get("completeTime"), t);
//	            		Predicate pre1 = cb.isNull(root.get("order").get("completeTime"));
//	            		Predicate pre2 =cb.equal(root.get("order").get("orderStatus").get("reason").as(String.class), orderedSelStatus);
//	            		list.add(cb.and(pre2, cb.or(pre, pre1)));
//	            	}
//	            }
//	            if(orderedStartDate != null && orderedEndDate != null){//查询下单时间
//	        		list.add(cb.between(root.get("order").get("creation"), orderedStartDate, DateUtil.getNextDayDate(orderedEndDate)));
//	            }
//	            //模糊查询商品类别、名称、商家、交收地、合同编号、订单编号、客服等
//	            if(keyword != null){
//	            	//商家名称
////	            	Predicate pre4 = cb.like(root.get("sellerCompany").as(String.class), "%" + keyword + "%");
//	            	//任强修改，买家和卖家名称查询
//	            	Predicate pre4 = cb.like(root.get("order").get("seller").get("name").as(String.class), "%" + keyword + "%");
//	            	Predicate pre7 = cb.like(root.get("order").get("buyer").get("name").as(String.class), "%" + keyword + "%");
//	            	//主合同编号
//	            	Predicate pre5 = cb.like(root.get("order").get("contractNumber").as(String.class), "%" + keyword + "%");
//	            	//订单编号
//	            	Predicate pre6 = cb.like(root.get("order").get("no").as(String.class), "%" + keyword + "%");
//	            	list.add(cb.or(pre4,pre5,pre6, pre7));
//	            }
	            
	            //任强，把已删除的订单除外
	            
//	            list.add(cb.equal(root.get("order").get("removed").as(Integer.class), 0));//查询未删除订单
//	            list.add(cb.equal(root.get("removed").as(Integer.class), 0));//查询未取消extends
//	            if(ids!=null && !"".equals(ids)) {
//	            	List<Long> idl=new ArrayList<Long>();
//		            String[] idArr =  ids.split(",");
//		            for (int i = 0; i < idArr.length; i++) {
//		            	long id = Long.valueOf(idArr[i]);
//		            	idl.add(id);
//					}
//		            list.add(root.get("order").get("buyer").get("dealerId").in(idl));
//	            }
//	            if(!"allStatus".equals(orderedSelStatus)&&orderedSelStatus!=null){//查询条件不是全部状态时，增加where条件查询对应状态的订单
//	            	list.add(cb.equal(root.get("order").get("orderStatus").get("reason").as(String.class), orderedSelStatus));
//	            }
	            
	        }
        };
	}

	public List<Good> findByType(Type type) {
		List<Good> list = goodDao.findByType(type);
		return list;
	}

	public Page<Good> findByShopId(Long shopId, Pageable pageable) {
		return goodDao.findByShopId(shopId, pageable);
	}


	
}
