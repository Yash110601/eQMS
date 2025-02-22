package com.example.documentmanagement.repository;

import org.springframework.stereotype.Repository;
import com.example.documentmanagement.model.Action;
import java.util.UUID;

@Repository
public interface ActionsRepository extends BaseRepository<Action, UUID> {
}
