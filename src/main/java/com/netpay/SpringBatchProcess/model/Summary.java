package com.netpay.SpringBatchProcess.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


/**
 * Entity Model Class for Summary Table.
 *
 * @since : Nov 21
 * @author : Vijay soni
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "SUMMARY")
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String summaryOfCategories;

}
