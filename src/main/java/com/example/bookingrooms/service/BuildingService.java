package com.example.bookingrooms.service;

import com.example.bookingrooms.model.Building;

import java.util.List;

public interface BuildingService {

    Building createBuilding(Building building);
    Building getBuildingId(long id);
    Building updateBuilding(long id, Building building);
    void deleteBuilding(long id);
    List<Building> getAllBuildings();
}
