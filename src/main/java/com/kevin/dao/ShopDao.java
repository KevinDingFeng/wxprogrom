package com.kevin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kevin.entity.Shop;

@Repository
public interface ShopDao extends JpaRepository<Shop, Long>, JpaSpecificationExecutor<Shop> {

}
