package com.kevin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kevin.entity.UserCardRel;

@Repository
public interface UserCardRelDao extends JpaRepository<UserCardRel, Long>, JpaSpecificationExecutor<UserCardRel> {

	List<UserCardRel> findByUserId(Long userId);

}
