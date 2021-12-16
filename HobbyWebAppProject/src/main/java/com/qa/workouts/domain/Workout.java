package com.qa.workouts.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Workout {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String workoutName;

	private String bodyPart;
	private String targetMuscle;
	private int weight;
	private int reps;
	private int sets;

//	CONSTRUCTORS

	public Workout() {
		super();
	}

//	public Workout(String workoutName, String bodyPart, String targetMuscle, int weight, int reps, int sets) {
//		super();
//		this.workoutName = workoutName;
//		this.bodyPart = bodyPart;
//		this.targetMuscle = targetMuscle;
//		this.weight = weight;
//		this.reps = reps;
//		this.sets = sets;
//	}

	public Workout(Integer id, String workoutName, String bodyPart, String targetMuscle, int weight, int reps,
			int sets) {
		super();
		this.id = id;
		this.workoutName = workoutName;
		this.bodyPart = bodyPart;
		this.targetMuscle = targetMuscle;
		this.weight = weight;
		this.reps = reps;
		this.sets = sets;
	}

//	GETTERS AND SETTERS

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWorkoutName() {
		return workoutName;
	}

	public void setWorkoutName(String workoutName) {
		this.workoutName = workoutName;
	}

	public String getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}

	public String getTargetMuscle() {
		return targetMuscle;
	}

	public void setTargetMuscle(String targetMuscle) {
		this.targetMuscle = targetMuscle;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

//	TO STRING

	@Override
	public String toString() {
		return "Workout [id=" + id + ", workout=" + workoutName + ", bodypart=" + bodyPart + ", targetMuscle="
				+ targetMuscle + ", weight=" + weight + ", reps=" + reps + ", sets=" + sets + "]";
	}

}
