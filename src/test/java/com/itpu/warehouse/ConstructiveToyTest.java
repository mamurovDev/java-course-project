package com.itpu.warehouse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.itpu.warehouse.controller.*;
import com.itpu.warehouse.entity.*;
import com.itpu.warehouse.enums.*;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ConstructiveToyTest {

  @Mock
  private ConstructiveController constructiveController;

  @Mock
  private PuzzleController puzzleController;

  @Mock
  private SoftController softController;

  @Mock
  private VehicleController vehicleController;

  @Mock
  private DollController dollController;

  @BeforeEach
  public void setUp() {
    when(constructiveController.getAllToys())
      .thenReturn(
        Collections.singletonList(
          new ConstructiveToy.ConstructiveToyBuilder()
            .id("1")
            .name("Lego")
            .category("Constructive")
            .price(29.99)
            .recommendedAge(6)
            .material("Plastic")
            .build()
        )
      );
  }

  @Test
  public void testListAllConstructiveToys() {
    List<ConstructiveToy> expectedToys = Collections.singletonList(
      new ConstructiveToy.ConstructiveToyBuilder()
        .id("1")
        .name("Lego")
        .category("Constructive")
        .price(29.99)
        .recommendedAge(6)
        .material("Plastic")
        .build()
    );

    List<ConstructiveToy> actualToys = constructiveController.getAllToys();

    assertEquals(expectedToys.size(), actualToys.size());
    for (int i = 0; i < expectedToys.size(); i++) {
      assertEquals(expectedToys.get(i), actualToys.get(i));
    }
  }
}
