package com.rony.creditinfix.models;


import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelResponseDTO<T> {

    List<T> responseDTOs;
}
