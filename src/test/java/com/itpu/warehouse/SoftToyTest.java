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
public class SoftToyTest {

  @Mock
  private SoftController softController;

  @BeforeEach
  public void setUp() {
    when(softController.getAllToys())
      .thenReturn(
        Collections.singletonList(
          new SoftToy.SoftToyBuilder()
            .id("3")
            .name("Teddy Bear")
            .category("Soft")
            .price(9.99)
            .recommendedAge(3)
            .mass(0.5)
            .build()
        )
      );
  }

  @Test
  public void testListAllSoftToys() {
    List<SoftToy> softToys = softController.getAllToys();
    assertEquals(1, softToys.size());
    assertEquals("Teddy Bear", softToys.get(0).getName());
    assertEquals("Soft", softToys.get(0).getCategory());
    assertEquals(9.99, softToys.get(0).getPrice());
    assertEquals(3, softToys.get(0).getRecommendedAge());
    assertEquals(0.5, softToys.get(0).getMass());
  }
}
