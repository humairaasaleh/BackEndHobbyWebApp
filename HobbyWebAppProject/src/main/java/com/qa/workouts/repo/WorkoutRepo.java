package com.qa.workouts.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.workouts.domain.Workout;

@Repository
public interface WorkoutRepo extends JpaRepository<Workout, Integer> {

	List<Workout> findByWorkoutNameIgnoreCase(String workoutName);

	List<Workout> findByBodyPartIgnoreCase(String bodypart);

	List<Workout> findByTargetMuscleIgnoreCase(String targetMuscle);

}
