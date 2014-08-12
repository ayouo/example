package com.blogspot.dikuro.example.quiz.stair;

public class Climber {
	
	private int maxStep;
	private int currentStep;
	private String stairStep;
	
	private Climber(int maxStep, String stairStep, int currentStep) {
		this.maxStep = maxStep;
		this.stairStep = stairStep;
		this.currentStep = currentStep;
	}
	
	private Climber(int maxStep, String stairStep) {
		this(maxStep, stairStep, 0);
	}
	
	public Climber(int maxStep) {
		this(maxStep, "");
	}
	
	public void nextStep(int step) {
		this.stairStep = this.stairStep + String.valueOf(step);
		this.currentStep  = this.currentStep + step;
	}
	
	public String stairStep() {
		return this.stairStep;
	}

	public int getMaxStep() {
		return maxStep;
	}

	public void setMaxStep(int maxStep) {
		this.maxStep = maxStep;
	}
	
	public Climber clone() {
		return new Climber(this.maxStep, this.stairStep, this.currentStep);
	}

	public int getCurrentStep() {
		return currentStep;
	}

	public void setCurrentStep(int currentStep) {
		this.currentStep = currentStep;
	}

	public String getStairStep() {
		return stairStep;
	}

	public void setStairStep(String stairStep) {
		this.stairStep = stairStep;
	}

}
