package com.jwm.drive.controller;

import com.jwm.j3dfw.controller.Controller;
import com.jwm.j3dfw.production.Camera;

import com.jwm.drive.domain.car.CarMovement.Move;
import com.jwm.drive.geometry.objects.Car;

public class CarController extends Controller {
	private Car c;

	public CarController(Car c) {
		super(c);
		this.c = c;
	}
	public void leftMouseDown() {
		c.setMovement(Move.ACCELERATING);
	}
	public void rightMouseDown() {
		c.setMovement(Move.DECELERATING);
	}
	public void leftMouseUp() {
		c.setMovement(Move.COASTING);
	}
	public void rightMouseUp() {
		c.setMovement(Move.COASTING);
	}
	public void keyPress(int keyCode) {
		if (keyCode == 49) {
			c.toggleHoodOpenClose();
		}
		else if ((char)keyCode == 'r') {
			c.getCamera().toggleAutoRotate();
		}
		else if ((char)keyCode == 't') {
			c.getCamera().toggleAutoTrack();
		}
	}
	public void setMousePosition(double xPos, double percent) {
		c.setFrontWheelAngle(percent);
	}
}