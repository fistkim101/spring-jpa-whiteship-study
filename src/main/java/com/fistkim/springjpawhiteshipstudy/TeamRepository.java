package com.fistkim.springjpawhiteshipstudy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long>, JpaSpecificationExecutor<Team> {

    @Query(value = "select distinct t from Team as t join fetch t.members")
    List<Team> findAllFetchJoin();

    @Query(value = "select t from Team as t join fetch t.members", countQuery = "select count(t) from Team as t inner join t.members")
    Page<Team> findAllFetchJoin(Pageable pageable);

    @Query(value = "select t from Team as t", countQuery = "select count(t) from Team as t")
    Page<Team> findAllPage(Pageable pageable);

    List<Team> findAll();

    //@QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    Team findByName(String name);

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    Optional<Team> findById(Long id);

}
