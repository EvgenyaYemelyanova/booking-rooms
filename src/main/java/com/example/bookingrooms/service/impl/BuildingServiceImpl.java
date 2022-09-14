package com.example.bookingrooms.service.impl;

import com.example.bookingrooms.exception.BuildingNotFoundException;
import com.example.bookingrooms.model.Building;
import com.example.bookingrooms.model.Customer;
import com.example.bookingrooms.repositories.BuildingRepository;
import com.example.bookingrooms.service.BuildingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {
    BuildingRepository buildingRepository;

    public BuildingServiceImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }
    @Override
    public Building createBuilding(Building building) {
        return buildingRepository.save(building);
    }
    @Override
    public Building getBuildingId(long id) {
        return buildingRepository.findById(id).orElseThrow(
                () -> new BuildingNotFoundException(String.format("Building with id '%d' not found", id))
        );
    }
    @Override
    public Building updateBuilding(long id, Building newBuilding) {
        Building building = buildingRepository.findById(id).orElseThrow(
                () -> new BuildingNotFoundException(String.format("Building with id '%d' not found", id))
        );

        handleBuildingUpdate(building, newBuilding);
        buildingRepository.save(building);
        return building;
    }
    @Override
    public void deleteBuilding(long id) {
        Building building = buildingRepository.findById(id).orElseThrow(
                () -> new BuildingNotFoundException(String.format("Building with id '%d' not found", id))
        );
        buildingRepository.delete(building);
    }
    @Override
    public List<Building> getAllBuildings() {
        Page<Building> buildings = buildingRepository.findAll(PageRequest.of(0, 10));
        return buildings.toList();
    }
    private void handleBuildingUpdate(Building building, Building newBuilding) {
        building.setAddressBuilding(newBuilding.getAddressBuilding());
        building.setTypeBuilding(newBuilding.getTypeBuilding());
        building.setFloorBuilding(newBuilding.getFloorBuilding());
        building.setApartment(newBuilding.getApartment());
    }
}
