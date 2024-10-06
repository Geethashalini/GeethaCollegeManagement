package com.tnsif.placementmanagementsystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for College operations.
 */
@RestController
@RequestMapping("/colleges")
public class GeethaCollegeController {

    @Autowired
    private GeethaCollegeService geethaCollegeService;

    /**
     * Retrieves a list of all colleges.
     *
     * @return a ResponseEntity containing a list of colleges and HTTP status OK
     */
    @GetMapping
    public ResponseEntity<List<GeethaCollege>> getAllColleges() {
        List<GeethaCollege> colleges = geethaCollegeService.listAll();
        return new ResponseEntity<>(colleges, HttpStatus.OK);
    }

    /**
     * Adds a new college.
     *
     * @param college the college to be added
     * @return a ResponseEntity containing a success message and HTTP status CREATED
     */
    //@PostMapping
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addCollege(@RequestBody GeethaCollege college) {
        geethaCollegeService.save(college);
        return new ResponseEntity<>("College added successfully", HttpStatus.CREATED);
    }

    /**
     * Retrieves a college by its ID.
     *
     * @param id the ID of the college to be retrieved
     * @return a ResponseEntity containing the college and HTTP status OK, or HTTP status NOT FOUND if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<GeethaCollege> getCollege(@PathVariable Integer id) {
        try {
            GeethaCollege college = geethaCollegeService.get(id);
            return new ResponseEntity<>(college, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Updates an existing college.
     *
     * @param college the college with updated information
     * @param id      the ID of the college to be updated
     * @return a ResponseEntity containing a success message and HTTP status OK, or HTTP status NOT FOUND if not found
     */
    //@PutMapping("/{id}")
    //@PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updateCollege(@RequestBody GeethaCollege college, @PathVariable Integer id) {
        System.out.println("Received request to update college: " + college);
        try {
            GeethaCollege existingCollege = geethaCollegeService.get(id);
            college.setId(id);
            geethaCollegeService.save(college);
            return new ResponseEntity<>("College updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Deletes a college by its ID.
     *
     * @param id the ID of the college to be deleted
     * @return a ResponseEntity containing a success message and HTTP status OK, or HTTP status NOT FOUND if not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCollege(@PathVariable Integer id) {
        try {
            geethaCollegeService.delete(id);
            return new ResponseEntity<>("College deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

