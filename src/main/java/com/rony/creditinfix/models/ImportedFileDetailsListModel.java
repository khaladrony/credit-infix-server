package com.rony.creditinfix.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportedFileDetailsListModel<T> {
    List<T> responseModels;
    Boolean invalidExists;
}
