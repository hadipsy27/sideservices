package com.bni.sidservices.repository;

import com.bni.sidservices.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, String> {
    @Query(value = "SELECT * FROM ksei_fund_sep_account_ksei WHERE no_sid = :no_sid AND no_sub_rek_efek = :no_sub_rek_efek", nativeQuery = true)
    List <Investor> findByNoSid(@Param("no_sid") String noSid, @Param("no_sub_rek_efek") String noSubRekEfek);
}
