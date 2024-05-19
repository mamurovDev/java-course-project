package com.itpu.warehouse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.itpu.warehouse.controller.*;
import com.itpu.warehouse.entity.*;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VehicleToyTest {

  @Mock
  private VehicleController vehicleController;

  @BeforeEach
  public void setUp() {
    when(vehicleController.getAllToys())
      .thenReturn(
        Collections.singletonList(
          new VehicleToy.VehicleToyBuilder()
            .id("5")
            .name("Car")
            .category("Vehicle")
            .price(24.99)
            .recommendedAge(4)
            .numberOfWheels(4)
            .build()
        )
      );
  }

  @Test
  public void testListAllVehicleToys() {
    List<VehicleToy> vehicleToys = vehicleController.getAllToys();
    assertEquals(1, vehicleToys.size());
    assertEquals("Car", vehicleToys.get(0).getName());
    assertEquals("Vehicle", vehicleToys.get(0).getCategory());
    assertEquals(24.99, vehicleToys.get(0).getPrice());
    assertEquals(4, vehicleToys.get(0).getRecommendedAge());
    assertEquals(4, vehicleToys.get(0).getNumberOfWheels());
  }
}
