package com.kevin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.entity.Group;

@Repository
public interface GroupDao extends JpaRepository<Group, Long> {

	public Group findByOpenGid(String openGid);
}
