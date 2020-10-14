package com.sudhir.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhir.entity.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Serializable>{

}
