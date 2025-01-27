package com.test.api.persistance.repository;

import com.test.api.persistance.entity.UserInteractionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInteractionLogRepository extends JpaRepository<UserInteractionLog, Long> {
}
