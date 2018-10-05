package com.kevin.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kevin.entity.Collection;

@Repository
public interface CollectionDao extends JpaRepository<Collection, Long> , JpaSpecificationExecutor<Collection>{

	Page<Collection> findByShopId(Long shopId, Pageable pageable);

}
