package com.kevin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.dao.OrderDao;
import com.kevin.entity.Order;
import com.kevin.entity.Order.Status;
import com.kevin.entity.Order.Type;

@Service
@Transactional(readOnly = false)
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;

	public Order getDefault(Long userId, Long id) {
		Order order = new Order();
		order.setType(Type.Exchange);
		order.setStatus(Status.Complete);
		order.setGoodId(id);
		order.setUserId(userId);
		return order;
	}

	public Order save(Order order) {
		return orderDao.save(order);
	}

	
}
