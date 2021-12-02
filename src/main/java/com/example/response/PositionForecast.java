package com.example.response;

import java.util.List;

import com.example.iss.model.Forecast;
import com.example.iss.model.Position;

public class PositionForecast {
	private List<Position> position;
	private List<Forecast> forecasts;

	public List<Position> getPosition() {
		return position;
	}

	public void setPosition(List<Position> position) {
		this.position = position;
	}

	public List<Forecast> getForecasts() {
		return forecasts;
	}

	public void setForecasts(List<Forecast> forecasts) {
		this.forecasts = forecasts;
	}

}
