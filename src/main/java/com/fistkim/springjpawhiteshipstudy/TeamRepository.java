package com.fistkim.springjpawhiteshipstudy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query(value = "select distinct t from Team as t join fetch t.members")
    List<Team> findAllFetchJoin();

    @Query(value = "select t from Team as t join fetch t.members", countQuery = "select count(t) from Team as t inner join t.members")
    Page<Team> findAllFetchJoin(Pageable pageable);

    @Query(value = "select t from Team as t", countQuery = "select count(t) from Team as t")
    Page<Team> findAllPage(Pageable pageable);

}
