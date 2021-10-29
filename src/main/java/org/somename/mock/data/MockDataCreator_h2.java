package org.somename.mock.data;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.somename.constants.F2I_C;
import org.somename.data.BaseRepository;
import org.somename.data.CourseRepository;
import org.somename.data.PersonRepository;
import org.somename.domain.course.Course;
import org.somename.domain.person.Person;
import org.springframework.context.annotation.Bean;

public class MockDataCreator_h2 {

	private static final Logger log = LoggerFactory.getLogger(MockDataCreator_h2.class);
	
    private static MockDataCreator_h2 singleInst = null;
    private boolean initialized = false;

    private MockDataCreator_h2() {
    };
    

    public static MockDataCreator_h2 getInstance() {
        if(singleInst==null) {
            singleInst = new MockDataCreator_h2();
        }
        return singleInst;
    }
    
    @Bean
    public void initialize(BaseRepository... manyRepos) {

    	if(initialized) {
    		System.out.println("ALREADY INITIALIZED");
    		return;
    	}

    	System.out.println("==================================================="+manyRepos.length);
    	
    	for(BaseRepository anyRepo : manyRepos) {
    		
    		if(anyRepo instanceof PersonRepository) {
    			ArrayList<Person> studentList = MockDataHelper.getAllStudents();
    			for(Person p: studentList)
    				anyRepo.save(p);
    			
    			ArrayList<Person> facultyList = MockDataHelper.getAllFaculty();
    			for(Person p: facultyList)
    				anyRepo.save(p);
    			
    			if(F2I_C.printDebug) {
    				log.info("Persons found with findAll():");
    				log.info("-------------------------------");
    				for (Object p : anyRepo.findAll()) {
    					log.info(p.toString());
    				}
    				log.info("");
    			}	
    		}
    		
    		if(anyRepo instanceof CourseRepository ) {
    			System.out.println("dsdsdsdsdsdsd");
    			ArrayList<Course> courseList = MockDataHelper.getAllCourses();
    			for(Course c: courseList)
    				anyRepo.save(c);
    			
    			if(F2I_C.printDebug) {
    				log.info("Courses found with findAll():");
    				log.info("-------------------------------");
    				for (Object c : anyRepo.findAll()) {
    					log.info(c.toString());
    				}
    				log.info("");
    			}	
    		}
    	}
        
		initialized = true;
    }

    
}
