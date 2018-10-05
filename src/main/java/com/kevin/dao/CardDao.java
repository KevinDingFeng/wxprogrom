package com.kevin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kevin.entity.Card;

@Repository
public interface CardDao extends JpaRepository<Card, Long> , JpaSpecificationExecutor<Card>{

	Card findByShopIdAndIdIn(Long shopId, List<Long> ids);

}
