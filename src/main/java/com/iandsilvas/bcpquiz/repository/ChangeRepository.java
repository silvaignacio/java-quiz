package com.iandsilvas.bcpquiz.repository;

import com.iandsilvas.bcpquiz.domain.Change;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChangeRepository extends JpaRepository<Change, Integer> {
}
