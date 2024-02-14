package com.fetchrewards.receiptprocessor.service;

import com.fetchrewards.receiptprocessor.model.Item;
import com.fetchrewards.receiptprocessor.model.Receipt;
import com.fetchrewards.receiptprocessor.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptService {
    @Autowired
    private ReceiptRepository receiptRepository;

    public Receipt saveReceipt(Receipt receipt){
        Receipt savedReceipt = receiptRepository.save(receipt);
        return savedReceipt;
    }

    public String calculatePoints(Receipt receipt) {

        if (receipt.getItems().isEmpty()) {
            return "Receipt does not contain any items!";
        }

        // One point for each alphanumeric character in the retailer name
        int points = receipt.getRetailer().replaceAll("[^a-zA-Z0-9]", "").length();

        double total = receipt.getTotal();

        // 50 points if the total is a round dollar amount with no cents
        if (total == Math.floor(total))
            points += 50;

        // 25 points if the total is a multiple of 0.25
        if (total % 0.25 == 0)
            points += 25;

        // 5 points for every two items on the receipt
        points += (receipt.getItems().size() / 2) * 5;
//        System.out.println("points after no. of items: " + points);

        // If the trimmed length of the item description is a multiple of 3
        points += receipt.getItems().parallelStream()
                .mapToInt(item -> {
                    int descriptionLength = item.getShortDescription().trim().length();
                    int itemPoints = 0;
                    if (descriptionLength % 3 == 0) {
                        itemPoints = (int) Math.ceil(Double.parseDouble(item.getPrice()) * 0.2);
                    }
                    return itemPoints;
                })
                .sum();
//        List<Item> items = receipt.getItems();
//        for(Item item : items){
//            int descriptionLength = item.getShortDescription().trim().length();
//            if (descriptionLength % 3 == 0) {
//                double itemPoints = Math.ceil(Double.parseDouble(item.getPrice()) * 0.2);
//                points += itemPoints;
//            }
//        }

        // 6 points if the day in the purchase date is odd
        if (Integer.parseInt(receipt.getPurchaseDate().split("-")[2]) % 2 != 0)
            points += 6;

        int purchaseHour = Integer.parseInt(receipt.getPurchaseTime().split(":")[0]);

        // 10 points if the time of purchase is after 2:00pm and before 4:00pm
        if (purchaseHour >= 14 && purchaseHour <= 16)
            points += 10;

        return String.valueOf(points);
    }
}
