package com.fetchrewards.receiptprocessor.repository;

import com.fetchrewards.receiptprocessor.model.Receipt;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ReceiptRepository extends CrudRepository<Receipt, UUID> {
}
