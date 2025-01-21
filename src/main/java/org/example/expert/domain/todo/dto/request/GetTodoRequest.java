package org.example.expert.domain.todo.dto.request;

import java.time.LocalDateTime;

public class GetTodoRequest {

  String weather;
  LocalDateTime updatedAtStart;
  LocalDateTime updatedAtEnd;

  public GetTodoRequest(String weather, LocalDateTime updatedAtStart, LocalDateTime updatedAtEnd) {
    this.weather = weather;
    this.updatedAtStart = updatedAtStart;
    this.updatedAtEnd = updatedAtEnd;
  }

  public String getWeather() {
    return weather;
  }

  public LocalDateTime getUpdatedAtStart() {
    return updatedAtStart;
  }

  public LocalDateTime getUpdatedAtEnd() {
    return updatedAtEnd;
  }
}
