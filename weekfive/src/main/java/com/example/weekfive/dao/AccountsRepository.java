package com.example.weekfive.dao;

import com.example.weekfive.models.Accounts;
import org.springframework.data.repository.CrudRepository;

public interface AccountsRepository extends CrudRepository<Accounts, Integer> {
}
