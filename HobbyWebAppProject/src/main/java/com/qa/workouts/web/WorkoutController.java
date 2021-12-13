package com.qa.workouts.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.workouts.domain.Workout;
import com.qa.workouts.service.WorkoutService;

@CrossOrigin

@RestController
public class WorkoutController {

	private WorkoutService service;

	@Autowired

	public WorkoutController(WorkoutService service) {
		super();
		this.service = service;
	}

//CREATE WORKOUT	
	@PostMapping("/create") // 201
	public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout) {
		Workout created = this.service.createWorkout(workout);
		ResponseEntity<Workout> response = new ResponseEntity<Workout>(created, HttpStatus.CREATED);
		return response;
	}

//GET ALL WORKOUTS
	@GetMapping("/getAll") // 200
	public ResponseEntity<List<Workout>> getAllWorkouts() {
		return ResponseEntity.ok(this.service.getAllWorkouts());
	}

//GET WORKOUTS BY ID
	@GetMapping("/get/{id}") // 200
	public Workout getWorkout(@PathVariable Integer id) {
		return this.service.getWorkout(id);
	}

//GET WORKOUTS BY WORKOUT NAME
	@GetMapping("/getByWorkoutName/{workoutName}")
	public ResponseEntity<List<Workout>> getWorkoutByWorkoutName(@PathVariable String workoutName) {
		List<Workout> found = this.service.getAllWorkoutsByWorkoutName(workoutName);
		return ResponseEntity.ok(found);
	}

//GET WORKOUTS BY BODYPART
	@GetMapping("/getByBodypart/{bodypart}")
	public ResponseEntity<List<Workout>> getWorkoutByBodypart(@PathVariable String bodypart) {
		List<Workout> found = this.service.getAllWorkoutsByBodyPart(bodypart);
		return ResponseEntity.ok(found);
	}

// GET WORKOUTS BY TARGET MUSCLE GROUP
	@GetMapping("/getByTargetMuscle/{targetMuscle}")
	public ResponseEntity<List<Workout>> getWorkoutByTargetMuscle(@PathVariable String targetMuscle) {
		List<Workout> found = this.service.getAllWorkoutsByTargetMuscle(targetMuscle);
		return ResponseEntity.ok(found);
	}

//UPDATE THE WORKOUT
	@PutMapping("/replace/{id}") // 202
	public ResponseEntity<Workout> replaceWorkout(@PathVariable Integer id, @RequestBody Workout newWorkout) {
		Workout body = this.service.replaceWorkout(id, newWorkout);
		ResponseEntity<Workout> response = new ResponseEntity<Workout>(body, HttpStatus.ACCEPTED);
		return response;
	}

//DELETE THE WORKOUT
	@DeleteMapping("/remove/{id}") // 204
	public ResponseEntity<?> removeWorkout(@PathVariable Integer id) {
		this.service.removeWorkout(id);
		return new ResponseEntity<Workout>(HttpStatus.NO_CONTENT);
	}

}
