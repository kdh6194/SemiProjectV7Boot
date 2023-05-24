package honeybee.springbott.semiprojectv7boot.repository;


import honeybee.springbott.semiprojectv7boot.model.Pds;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PdsRepository extends PagingAndSortingRepository<Pds, Long> {

    @Modifying
    @Transactional
    @Query(
            "update Pds set views = views + 1 where pno = :pno")
    int countViewPds(@Param("pno") long pno);

    Page findAll(Pageable paging);

    Page<Pds>findByTitleContains(Pageable paging, String fkey);
    Page<Pds>findByTitleContainsOrContentContains(Pageable paging, String fkey1, String fkey2);
    Page<Pds>findByContentContains(Pageable paging,String fkey);
    Page<Pds>findByUserid(Pageable paging,String fkey);
}
