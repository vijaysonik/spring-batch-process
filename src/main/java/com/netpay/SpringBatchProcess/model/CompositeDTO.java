package com.netpay.SpringBatchProcess.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompositeDTO {

    private Category category;
    private Summary summary;
}
