package com.qa.workouts.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.workouts.domain.Workout;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:workout-schema.sql",
		"classpath:workout-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class WorkoutControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

//	CREATE TEST
	@Test
	void testCreate() throws Exception {
		Workout testWorkout = new Workout(null, "Chest Press", "chest", "pectorals", 32, 8, 4);
		String testWorkoutAsJson = this.mapper.writeValueAsString(testWorkout);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testWorkoutAsJson);

		Workout testCreatedWorkout = new Workout(2, "Chest Press", "chest", "pectorals", 32, 8, 4);
		String testCreatedWorkoutAsJson = this.mapper.writeValueAsString(testCreatedWorkout);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedWorkoutAsJson);
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

//	GET ALL TEST
	@Test
	void testGetAll() throws Exception {
		List<Workout> testWorkouts = List.of(new Workout(1, "Leg Press", "Legs", "quads", 100, 10, 5));
		String json = this.mapper.writeValueAsString(testWorkouts);

		RequestBuilder req = get("/getAll");
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

//	GET BY ID TEST
	@Test
	void testGetById() throws Exception {
		Workout testWorkout = new Workout(1, "Leg Press", "Legs", "quads", 100, 10, 5);
		String json = this.mapper.writeValueAsString(testWorkout);

		RequestBuilder req = get("/get/1");
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

//	GET BY WORKOUT NAME
	@Test
	void testGetByWorkoutName() throws Exception {
		List<Workout> testWorkouts = List.of(new Workout(1, "Leg Press", "Legs", "quads", 100, 10, 5));
		String json = this.mapper.writeValueAsString(testWorkouts);

		RequestBuilder req = get("/getByWorkoutName/Leg Press");
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}

//	GET BY BODY PART 
	@Test
	void testGetByBodyPart() throws Exception {
		List<Workout> testWorkouts = List.of(new Workout(1, "Leg Press", "Legs", "quads", 100, 10, 5));
		String json = this.mapper.writeValueAsString(testWorkouts);

		RequestBuilder req = get("/getByBodyPart/Legs");
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
//	GET BY TARGET MUSCLE GROUP
	@Test
	void testGetByTargetMuscle() throws Exception {
		List<Workout> testWorkouts = List.of(new Workout(1, "Leg Press", "Legs", "quads", 100, 10, 5));
		String json = this.mapper.writeValueAsString(testWorkouts);

		RequestBuilder req = get("/getByTargetMuscle/quads");
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

}
