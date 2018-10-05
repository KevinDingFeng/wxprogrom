package com.kevin.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kevin.entity.Good;
import com.kevin.entity.Good.Type;

@Repository
public interface GoodDao extends JpaRepository<Good, Long>, JpaSpecificationExecutor<Good> {

	List<Good> findByType(Type type);

	Page<Good> findByShopId(Long shopId, Pageable pageable);

}
