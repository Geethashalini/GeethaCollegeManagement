package com.tnsif.placementmanagementsystem;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tnsif.placementmanagementsystem.GeethaCollege;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for College entity.
 */
public class GeethaCollegeTest {

    private GeethaCollege college;
    //private User collegeAdmin;

//    @BeforeEach
//    public void setUp() {
//        // Initialize mock User object for collegeAdmin
//        collegeAdmin = new User();
//        collegeAdmin.setId((long) 1);
//        collegeAdmin.setName("Test Admin");
//
//        // Initialize College object
//        college = new College(1, "Test College", "Test Location", collegeAdmin);
//    }

    @Test
    public void testGetId() {
        assertEquals(1, college.getId());
    }

    @Test
    public void testGetCollegeName() {
        assertEquals("Test College", college.getCollegeName());
    }

    @Test
    public void testGetLocation() {
        assertEquals("Test Location", college.getLocation());
    }

    @Test
    public void testGetCollegeAdmin() {
//        assertNotNull(college.getCollegeAdmin());
//        assertEquals("Test Admin", college.getCollegeAdmin().getName());
    }

    @Test
    public void testSetCollegeName() {
        college.setCollegeName("New College Name");
        assertEquals("New College Name", college.getCollegeName());
    }

    // Failing test cases (for demonstration purposes, commented out)
    
    // @Test
    // public void testFailingGetId() {
    //     // This test will fail because the expected ID is different
    //     assertEquals(2, college.getId());  // Expected ID is incorrect
    // }

    // @Test
    // public void testFailingGetLocation() {
    //     // This test will fail because the location is not "Wrong Location"
    //     assertEquals("Wrong Location", college.getLocation());  // Expected location is incorrect
    // }
}

