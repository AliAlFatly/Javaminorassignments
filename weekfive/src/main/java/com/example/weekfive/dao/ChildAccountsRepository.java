package com.example.weekfive.dao;

import com.example.weekfive.models.ChildAccounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildAccountsRepository extends CrudRepository<ChildAccounts, Integer> {
}
