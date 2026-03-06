package com.Autonation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.Autonation.Binding.Inventory;


@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Long>{

}
