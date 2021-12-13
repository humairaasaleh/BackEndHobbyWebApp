package com.qa.workouts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.workouts.domain.Workout;
import com.qa.workouts.repo.WorkoutRepo;

@Service
public class WorkoutServiceDB implements WorkoutService {

	private WorkoutRepo repo;

	@Autowired
	public WorkoutServiceDB(WorkoutRepo repo) {
		super();
		this.repo = repo;
	}

//	CREATE WORKOUT
	@Override
	public Workout createWorkout(Workout workout) {
		Workout created = this.repo.save(workout);
		return created;
	}

//	GET ALL WORKOUTS
	@Override
	public List<Workout> getAllWorkouts() {
		return this.repo.findAll();
	}

//GET ALL WORKOUTS BY WORKOUT NAME	
	@Override
	public List<Workout> getAllWorkoutsByWorkoutName(String workoutName) {
		List<Workout> found = this.repo.findByWorkoutNameIgnoreCase(workoutName);
		return found;
	}

//	GET ALL WORKOUTS BY BODY PART
	@Override
	public List<Workout> getAllWorkoutsByBodyPart(String bodyPart) {
		List<Workout> found = this.repo.findByBodyPartIgnoreCase(bodyPart);
		return found;
	}

//	GET ALL WORKOUTS BY TARGET MUSCLE GROUP
	@Override
	public List<Workout> getAllWorkoutsByTargetMuscle(String targetMuscle) {
		List<Workout> found = this.repo.findByTargetMuscleIgnoreCase(targetMuscle);
		return found;
	}

//	GET BY ID
	@Override
	public Workout getWorkout(Integer id) {
		Optional<Workout> found = this.repo.findById(id);
		return found.get();
	}

//	UPDATE WORKOUT
	@Override
	public Workout replaceWorkout(Integer id, Workout newWorkout) {
		Workout existing = this.repo.findById(id).get();

		existing.setWorkoutName(newWorkout.getWorkoutName());
		existing.setBodypart(newWorkout.getBodypart());
		existing.setTargetMuscle(newWorkout.getTargetMuscle());
		existing.setWeight(newWorkout.getWeight());
		existing.setReps(newWorkout.getReps());
		existing.setSets(newWorkout.getSets());
		Workout updated = this.repo.save(existing);
		return updated;
	}

	@Override
	public void removeWorkout(Integer id) {
		this.repo.deleteById(id);
	}

}
