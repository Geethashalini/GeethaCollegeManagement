package com.tnsif.placementmanagementsystem;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for College entity.
 * 
 * This interface extends JpaRepository to provide CRUD operations
 * and custom query methods for the College entity.
 */
@Repository
public interface GeethaCollegeRepository extends JpaRepository<GeethaCollege, Integer> {

    /**
     * Finds a college by its ID and includes the associated college admin.
     *
     * @param id the ID of the college to be retrieved
     * @return a list of colleges with the associated admin information,
     *         or an empty list if no college is found
     */
    //@Query("SELECT c FROM College c LEFT JOIN User u ON u.id = c.collegeAdmin.id WHERE c.id = :id")
    //List<GeethaCollege> findCollegeWithAdmin(@Param("id") Long id);
}
