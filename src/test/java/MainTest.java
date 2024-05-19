import static org.mockito.Mockito.*;

import com.itpu.warehouse.Main;
import com.itpu.warehouse.controller.*;
import com.itpu.warehouse.entity.*;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

public class MainTest {

  @Mock
  private ConstructiveController constructiveController;

  @Mock
  private DollController dollController;

  @Mock
  PuzzleController puzzleController;

  @Mock
  private VehicleController vehicleController;

  @Mock
  private SoftController softController;

  @InjectMocks
  private Main main;

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
    when(dollController.getAllToys())
      .thenReturn(
        Collections.singletonList(
          new DollToy.DollToyBuilder()
            .id("2")
            .name("Barbie")
            .category("Doll")
            .price(19.99)
            .recommendedAge(3)
            .build()
        )
      );
    when(puzzleController.getAllToys())
      .thenReturn(
        Collections.singletonList(
          new PuzzleToy.PuzzleToyBuilder()
            .id("1")
            .name("Puzzle")
            .category("Puzzle")
            .price(9.99)
            .recommendedAge(5)
            .build()
        )
      );
    when(softController.getAllToys())
      .thenReturn(
        Collections.singletonList(
          new SoftToy.SoftToyBuilder()
            .id("1")
            .name("Teddy Bear")
            .category("Soft")
            .price(14.99)
            .recommendedAge(2)
            .build()
        )
      );
    when(vehicleController.getAllToys())
      .thenReturn(
        Collections.singletonList(
          new VehicleToy.VehicleToyBuilder()
            .id("1")
            .name("Car")
            .category("Vehicle")
            .price(24.99)
            .recommendedAge(4)
            .build()
        )
      );
  }

  @Test
  public void testListAllToys() {
    main.listAllToys();
    verify(constructiveController).getAllToys();
    verify(dollController).getAllToys();
    verify(puzzleController).getAllToys();
    verify(softController).getAllToys();
    verify(vehicleController).getAllToys();
  }
}
