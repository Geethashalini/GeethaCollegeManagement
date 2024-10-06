package com.tnsif.placementmanagementsystem;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tnsif.placementmanagementsystem.GeethaCollege;
import com.tnsif.placementmanagementsystem.GeethaCollegeController;
import com.tnsif.placementmanagementsystem.GeethaCollegeService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit test class for {@link CollegeController}.
 */
public class GeethaCollegeControllerTest {

    @Mock
    private GeethaCollegeService geethaCollegeService;

    @InjectMocks
    private GeethaCollegeController collegeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test for getting all colleges.
     * It should return a list of colleges with HTTP status OK.
     */
    @Test
    public void testGetAllColleges() {
        GeethaCollege college1 = new GeethaCollege(1, "ABC College", "New York");
        GeethaCollege college2 = new GeethaCollege(2, "XYZ College", "California");
        List<GeethaCollege> colleges = Arrays.asList(college1, college2);

        when(geethaCollegeService.listAll()).thenReturn(colleges);

        ResponseEntity<List<GeethaCollege>> response = collegeController.getAllColleges();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        verify(geethaCollegeService, times(1)).listAll();
    }

    /**
     * Test for adding a new college.
     * It should return a success message with HTTP status CREATED.
     */
    @Test
    public void testAddCollege() {
    	GeethaCollege college = new GeethaCollege(3, "DEF College", "Chicago");
        when(geethaCollegeService.save(any(GeethaCollege.class))).thenReturn(college);

        ResponseEntity<String> response = collegeController.addCollege(college);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("College added successfully", response.getBody());
        verify(geethaCollegeService, times(1)).save(college);
    }

    /**
     * Test for getting a college by ID.
     * It should return the college details with HTTP status OK.
     */
    @Test
    public void testGetCollege() {
    	GeethaCollege college = new GeethaCollege(1, "ABC College", "New York");

        when(geethaCollegeService.get(1)).thenReturn(college);

        ResponseEntity<GeethaCollege> response = collegeController.getCollege(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("ABC College", response.getBody().getCollegeName());
        verify(geethaCollegeService, times(1)).get(1);
    }

    /**
     * Test for updating a college.
     * It should return a success message with HTTP status OK.
     */
    @Test
    public void testUpdateCollege() {
    	GeethaCollege college = new GeethaCollege(1, "Updated College", "Updated Location");

        when(geethaCollegeService.get(1)).thenReturn(college);
        when(geethaCollegeService.save(any(GeethaCollege.class))).thenReturn(college);

        ResponseEntity<String> response = collegeController.updateCollege(college, 1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("College updated successfully", response.getBody());
        verify(geethaCollegeService, times(1)).save(college);
    }

    /**
     * Test for deleting a college by ID.
     * It should return a success message with HTTP status OK.
     */
    @Test
    public void testDeleteCollege() {
        doNothing().when(geethaCollegeService).delete(1);

        ResponseEntity<String> response = collegeController.deleteCollege(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("College deleted successfully", response.getBody());
        verify(geethaCollegeService, times(1)).delete(1);
    }

    // Example failing test cases:
    // @Test
    // public void testGetCollege_NotFound() {
    //     when(geethaCollegeService.get(99)).thenThrow(new EntityNotFoundException("College not found with ID: 99"));
    //
    //     ResponseEntity<College> response = collegeController.getCollege(99);
    //
    //     assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    // }

    // @Test
    // public void testDeleteCollege_NotFound() {
    //     doThrow(new EntityNotFoundException("College not found with ID: 99")).when(geethaCollegeService).delete(99);
    //
    //     ResponseEntity<String> response = collegeController.deleteCollege(99);
    //
    //     assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    // }
}

