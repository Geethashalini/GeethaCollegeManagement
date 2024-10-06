package com.tnsif.placementmanagementsystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tnsif.placementmanagementsystem.GeethaCollege;
import com.tnsif.placementmanagementsystem.GeethaCollegeRepository;
import com.tnsif.placementmanagementsystem.GeethaCollegeService;

import jakarta.persistence.EntityNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit test class for {@link CollegeService}.
 */
public class GeethaCollegeServiceTest {

    @Mock
    private GeethaCollegeRepository collegeRepository;

    @InjectMocks
    private GeethaCollegeService collegeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test for listing all colleges.
     * It should return a list of colleges.
     */
    @Test
    public void testListAll() {
        GeethaCollege college1 = new GeethaCollege(1, "ABC College", "New York");
        GeethaCollege college2 = new GeethaCollege(2, "XYZ College", "California");
        List<GeethaCollege> colleges = Arrays.asList(college1, college2);

        when(collegeRepository.findAll()).thenReturn(colleges);

        List<GeethaCollege> result = collegeService.listAll();

        assertEquals(2, result.size());
        verify(collegeRepository, times(1)).findAll();
    }

    /**
     * Test for getting a college by ID.
     * It should return the college if found.
     */
    @Test
    public void testGetCollege() {
    	GeethaCollege college = new GeethaCollege(1, "ABC College", "New York");

        when(collegeRepository.findById(1)).thenReturn(Optional.of(college));

        GeethaCollege result = collegeService.get(1);

        assertNotNull(result);
        assertEquals("ABC College", result.getCollegeName());
        verify(collegeRepository, times(1)).findById(1);
    }

    /**
     * Test for saving a college.
     * It should return the saved college.
     */
    @Test
    public void testSaveCollege() {
    	GeethaCollege college = new GeethaCollege(1, "ABC College", "New York");

        when(collegeRepository.save(any(GeethaCollege.class))).thenReturn(college);

        GeethaCollege result = collegeService.save(college);

        assertNotNull(result);
        assertEquals("ABC College", result.getCollegeName());
        verify(collegeRepository, times(1)).save(college);
    }

    /**
     * Test for deleting a college.
     * It should delete the college if it exists.
     */
    @Test
    public void testDeleteCollege() {
        when(collegeRepository.existsById(1)).thenReturn(true);
        doNothing().when(collegeRepository).deleteById(1);

        collegeService.delete(1);

        verify(collegeRepository, times(1)).existsById(1);
        verify(collegeRepository, times(1)).deleteById(1);
    }

    /**
     * Test for getting a college by ID that doesn't exist.
     * It should throw an EntityNotFoundException.
     */
    @Test
    public void testGetCollege_NotFound() {
        when(collegeRepository.findById(99)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> collegeService.get(99));
    }

    // Example failing test cases:
    // @Test
    // public void testDeleteCollege_NotFound() {
    //     when(collegeRepository.existsById(99)).thenReturn(false);
    //
    //     assertThrows(EntityNotFoundException.class, () -> collegeService.delete(99));
    // }
}
