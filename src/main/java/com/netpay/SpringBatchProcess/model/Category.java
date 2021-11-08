package com.netpay.SpringBatchProcess.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity Model Class for Category Table.
 *
 * @since : Nov 21
 * @author : Vijay Soni
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "CATEGORY")
public class Category {
    @Id
    private int id;
    private String categories;
    private String value;
    private int status;
}
