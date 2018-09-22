package com.rashidi.rashidi.practice.test.junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Tag("spy")
class SpyTest {

  @Test
  void whenSpyingOnList_thenCorrect() {
    List<String> list = new ArrayList<>();
    List<String> spyList = Mockito.spy(list);

    spyList.add("one");
    spyList.add("two");

    Mockito.verify(spyList).add("one");
    Mockito.verify(spyList).add("two");

    assertEquals(2, spyList.size());
  }

}
