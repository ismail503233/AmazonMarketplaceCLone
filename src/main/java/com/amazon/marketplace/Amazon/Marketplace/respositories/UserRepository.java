package com.amazon.marketplace.Amazon.Marketplace.respositories;

import com.amazon.marketplace.Amazon.Marketplace.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
