package com.cozyhome.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cozyhome.inventory.model.ProductColor;

@Repository
public interface ProductColorRepository extends JpaRepository<ProductColor, Integer>{

}
