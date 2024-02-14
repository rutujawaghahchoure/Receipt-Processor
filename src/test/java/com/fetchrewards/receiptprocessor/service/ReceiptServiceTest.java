package com.fetchrewards.receiptprocessor.service;

import com.fetchrewards.receiptprocessor.controller.ReceiptController;
import com.fetchrewards.receiptprocessor.model.Item;
import com.fetchrewards.receiptprocessor.model.Receipt;
import com.fetchrewards.receiptprocessor.repository.ReceiptRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ReceiptServiceTest {

    @Test
    @DisplayName("Test passes when we get the expected points")
    void calculatedPointsAreCorrect() {
        ReceiptService receiptService = new ReceiptService();
        Receipt receipt = new Receipt();
        receipt.setRetailer("Target");
        receipt.setPurchaseDate("2022-01-01");
        receipt.setPurchaseTime("13:01");
        receipt.setTotal(35.35);
        List<Item> item = new ArrayList<>();
        item.add(new Item("Mountain Dew 12PK", "6.49"));
        item.add(new Item("Emils Cheese Pizza", "12.25"));
        item.add(new Item("Knorr Creamy Chicken", "1.26"));
        item.add(new Item("Doritos Nacho Cheese", "3.35"));
        item.add(new Item("   Klarbrunn 12-PK 12 FL OZ  ", "12.00"));
        receipt.setItems(item);
        String expectedPoints = "28";
        String actualPoints = receiptService.calculatePoints(receipt);
        Assertions.assertEquals(expectedPoints, actualPoints);
    }

    @Test
    @DisplayName("Test passes if the list of items is empty")
    void checkIfListIsEmpty(){
        ReceiptService receiptService = new ReceiptService();
        Receipt receipt = new Receipt();
        receipt.setRetailer("Target");
        receipt.setPurchaseDate("2022-01-01");
        receipt.setPurchaseTime("13:01");
        receipt.setTotal(35.35);
        List<Item> item = new ArrayList<>();
        receipt.setItems(item);
        String expectedResult = "Receipt does not contain any items!";
        String actualResult = receiptService.calculatePoints(receipt);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}