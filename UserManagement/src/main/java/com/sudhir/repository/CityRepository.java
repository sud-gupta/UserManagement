package com.sudhir.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhir.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Serializable>{

}
