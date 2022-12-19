package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.KhoangSan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoangSanRepository extends JpaRepository<KhoangSan, Long>{

}
