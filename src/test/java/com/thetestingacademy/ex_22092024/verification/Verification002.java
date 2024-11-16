package com.thetestingacademy.ex_22092024.verification;

import org.testng.annotations.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class Verification002 {

    @Test
    public void test_verify_assertJ(){
        String name = "Shubham";
        assertThat(name).isEqualTo("Shubham").isNotBlank().isNotEmpty();
        List<String> names = Arrays.asList("John", "Jane", "Doe");
        assertThat(names).hasSize(3).isNotNull();

        LocalDate date = LocalDate.now();
        System.out.println(date);

        assertThat(date)
                .isAfterOrEqualTo(LocalDate.of(2021, 1, 12))
                .isBeforeOrEqualTo(LocalDate.of(2025,1,1))
                .isBetween(LocalDate.of(2022, 1, 1),
                        LocalDate.of(2024, 12,31)
                );

        File file = new File("E:\\ATB\\RestAssuredAPI\\RestAssuredAPI\\src\\test\\java\\com\\thetestingacademy\\ex_22092024\\verification\\Testdata.json");
        assertThat(file).exists().isFile().canRead();

        Map<String, Integer> ages = new HashMap<>();
        ages.put("Jhon", 25);
        ages.put("Jane", 29);

        assertThat(ages).hasSize(2).containsEntry("Jhon", 25).doesNotContainValue(30);
    }
}
