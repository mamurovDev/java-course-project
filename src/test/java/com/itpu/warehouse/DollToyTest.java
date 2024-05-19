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
public class DollToyTest {

  @Mock
  private DollController dollController;

  @BeforeEach
  public void setUp() {
    when(dollController.getAllToys())
      .thenReturn(
        Collections.singletonList(
          new DollToy.DollToyBuilder()
            .id("4")
            .name("Barbie")
            .category("Doll")
            .price(14.99)
            .recommendedAge(5)
            .gender(Gender.FEMALE)
            .build()
        )
      );
  }

  @Test
  public void testGetAllToys() {
    List<DollToy> dollToys = dollController.getAllToys();
    assertEquals(1, dollToys.size());
    assertEquals("Barbie", dollToys.get(0).getName());
    assertEquals("Doll", dollToys.get(0).getCategory());
    assertEquals(14.99, dollToys.get(0).getPrice());
    assertEquals(5, dollToys.get(0).getRecommendedAge());
  }
}
