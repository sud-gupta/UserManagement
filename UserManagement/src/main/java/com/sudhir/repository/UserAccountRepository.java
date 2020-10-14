package com.sudhir.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhir.entity.UserAccountEntity;

public interface UserAccountRepository  extends JpaRepository<UserAccountEntity, Serializable>{

}
