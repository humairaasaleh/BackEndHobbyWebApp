package com.qa.workouts.service;

import java.util.List;

import com.qa.workouts.domain.Workout;

public interface WorkoutService {

	Workout createWorkout(Workout workout);

	List<Workout> getAllWorkouts();

	List<Workout> getAllWorkoutsByWorkoutName(String workoutName);

	List<Workout> getAllWorkoutsByBodyPart(String bodyPart);

	List<Workout> getAllWorkoutsByTargetMuscle(String targetMuscle);

	Workout getWorkout(Integer id);

	Workout replaceWorkout(Integer id, Workout newWorkout);

	void removeWorkout(Integer id);

}
