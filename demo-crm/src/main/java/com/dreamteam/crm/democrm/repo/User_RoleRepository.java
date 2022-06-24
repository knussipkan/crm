package com.dreamteam.crm.democrm.repo;


// реализует все необходимые запросы в БД

import com.dreamteam.crm.democrm.entity.User_Role;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/*

При запуске проекта Spring  находит все переменные, которые имеют тип этого интерфейса.

После этого внедряет в эти переменные нужные объекты, где уже реализованы все методы.

 */
@Repository
public interface User_RoleRepository extends JpaRepository<User_Role, Long> {
}
