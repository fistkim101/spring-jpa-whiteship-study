package com.fistkim.springjpawhiteshipstudy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "select m from Member as m join fetch m.team where m.team.name = :teamName")
    List<Member> findAllByTeamNameFetchJoin(@Param(value = "teamName") String teamName);

    List<Member> findAll();

}
