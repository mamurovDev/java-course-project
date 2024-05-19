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
public class PuzzleToyTest {

  @Mock
  private PuzzleController puzzleController;

  @BeforeEach
  public void setUp() {
    when(puzzleController.getAllToys())
      .thenReturn(
        Collections.singletonList(
          new PuzzleToy.PuzzleToyBuilder()
            .id("2")
            .name("Puzzle")
            .category("Puzzle")
            .price(19.99)
            .recommendedAge(8)
            .difficulty("Hard")
            .build()
        )
      );
  }

  @Test
  public void testListAllPuzzleToys() {
    List<PuzzleToy> puzzleToys = puzzleController.getAllToys();
    assertEquals(1, puzzleToys.size());
    assertEquals("Puzzle", puzzleToys.get(0).getName());
    assertEquals("Puzzle", puzzleToys.get(0).getCategory());
    assertEquals(19.99, puzzleToys.get(0).getPrice());
    assertEquals(8, puzzleToys.get(0).getRecommendedAge());
    assertEquals("Hard", puzzleToys.get(0).getDifficulty());
  }
}
